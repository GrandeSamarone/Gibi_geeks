package com.example.fulanoeciclano.gibi_geeks.Pag_nick_foto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fulanoeciclano.gibi_geeks.IconsPage.PageAddIcon;
import com.example.fulanoeciclano.gibi_geeks.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Cad_nick_foto_Activity extends AppCompatActivity  {
    final static String DB_URL="https://geeksgibi.firebaseio.com/";
    private static final String TAG = "NewPostActivity";
    private static final String REQUIRED = "Required";
    private DatabaseReference mDatabase;
    private CircleImageView imageNick;
    private ImageView imageView;
    private Button botaocadastrar;
    private EditText add_nick_perfil;
    private  String urlfoto;
    private Uri selectedImage;
    private AlertDialog alerta;
    public static final int PICK_IMG = 1234;

    private Intent data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_cad_nick_foto_);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        add_nick_perfil = findViewById(R.id.Edit_Nick_perfil);
        imageNick = findViewById(R.id.NIck_Icone_perfil);

        botaocadastrar=findViewById(R.id.botaocadastrar);



        //recebendo dados da pagina de icone
       final Bundle it = getIntent().getExtras();

        Picasso.with(this)
                .load(it.getString("caminho_foto"))
                .placeholder(R.drawable.placeholder)   // optional
                .error(R.drawable.placeholder1)      // optional
                .resize(400, 400)                        // optional
                .into(imageNick);



        //iniciando


        imageNick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent it = new Intent(Cad_nick_foto_Activity.this, PageAddIcon.class);
                startActivity(it);
                */
                exemplo_layout();
            }
        });

        //    File imgFile = new  File("content://media/external/images/media/113198");


    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_CANCELED){
            if(requestCode == PICK_IMG){
                 selectedImage = data.getData();
                Toast.makeText(getApplicationContext(),"Carregando...", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(Cad_nick_foto_Activity.this, Cad_nick_foto_Activity.class);
                it.putExtra("caminho_foto", selectedImage.toString());
                startActivity(it);
            }

        }
    }

    private void exemplo_layout() {
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = li.inflate(R.layout.alerta, null);
        //definimos para o botão do layout um clickListener
        view.findViewById(R.id.botaogaleria).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Selecione uma imagem"), PICK_IMG);

                //desfaz o alerta.
                alerta.dismiss();
            }
        });
        view.findViewById(R.id.botaoicones).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //exibe um Toast informativo.
                Intent it = new Intent(Cad_nick_foto_Activity.this, PageAddIcon.class);
                startActivity(it);
                //desfaz o alerta.
                alerta.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Titulo");
        builder.setView(view);
        alerta = builder.create();
        alerta.show();

    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

}
