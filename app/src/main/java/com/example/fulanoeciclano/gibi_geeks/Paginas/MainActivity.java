package com.example.fulanoeciclano.gibi_geeks.Paginas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fulanoeciclano.gibi_geeks.Autenticacao.Autenticacao;
import com.example.fulanoeciclano.gibi_geeks.Pag_nick_foto.Cad_nick_foto_Activity;
import com.example.fulanoeciclano.gibi_geeks.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private String mPhotoUrl;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private TextView mNameTextView;
    private TextView mEmailTextView;
    private CircleImageView mDisplayImageView;
    private  NavigationView navigationView;
    private  ActionBarDrawerToggle toggle;
    private  DrawerLayout mdrawer;
    private String mUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null) {
            // Caso nao seja Usuario, irá para pagina de cadastro
            startActivity(new Intent(this, Autenticacao.class));
            finish();
            return;
        } else {
            mUsername = mFirebaseUser.getDisplayName();

              //carrega a foto
            if (mFirebaseUser.getPhotoUrl() != null) {
                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }
        }

        //carregando das informacoes do usuario no Drawer
        mdrawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, mdrawer, R.string.open, R.string.close);
        mdrawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigat_id);
        navigationView.setNavigationItemSelectedListener(this);
        View navHeaderView = navigationView.getHeaderView(0);
        mDisplayImageView = (CircleImageView) navHeaderView.findViewById(R.id.Img_perfil);
        mNameTextView = (TextView) navHeaderView.findViewById(R.id.Nome_usuario);
        mEmailTextView = (TextView) navHeaderView.findViewById(R.id.Email_usuario);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            //insere informacoes no Drawer
            mNameTextView.setText(user.getDisplayName());
            mEmailTextView.setText(user.getEmail());
            Glide.with(MainActivity.this)
                    .load(mPhotoUrl)
                    .into(mDisplayImageView );
            String uid = user.getUid();
            Log.i("txt","ts"+user.getPhotoUrl());
        }
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.inicio_menu) {

        }else if (id == R.id.meuanuncio_menu) {

        }else if (id == R.id.minha_conta_menu) {
            Intent intentaddwifi = new Intent(MainActivity.this,  Cad_nick_foto_Activity.class);
            startActivity(intentaddwifi);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        //ativa o botao para chamar o drawer
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
