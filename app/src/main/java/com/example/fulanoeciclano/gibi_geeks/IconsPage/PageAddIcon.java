package com.example.fulanoeciclano.gibi_geeks.IconsPage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.example.fulanoeciclano.gibi_geeks.Pag_nick_foto.Cad_nick_foto_Activity;
import com.example.fulanoeciclano.gibi_geeks.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.util.ArrayList;

public class PageAddIcon extends AppCompatActivity {
    final static String DB_URL="https://geeksgibi.firebaseio.com/";
    private EditText nameEditText,urlEditText;
    private Button saveBtn;
    private RecyclerView rv;
    private CardView cd;
    private FirebaseClient firebaseClient;
    private FirebaseStorage storage;
    private StorageReference storageRef;
    private StorageReference imgRef;
    private Context com;
    private ArrayList<Icones> icones;
    private MyAdapter adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_page_add_icon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.icones=new ArrayList<>();
        rv = (RecyclerView) findViewById(R.id.mRecylcerID);
        cd= findViewById(R.id.modelcard);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setHasFixedSize(true);


        /*
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(this, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        if(position==0){
                            Intent i = new Intent(Intent.ACTION_PICK,
                                    android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                            startActivityForResult(Intent.createChooser(i, "Selecione uma imagem"), PICK_IMAGE);
                        }else{
                            Intent intent=new Intent(PageAddIcon.this,Cad_nick_foto_Activity.class);
                            intent.putExtra("url",icones.get(position).getUrl());
                            startActivity(intent);
                        }
                    }


                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
*/
        firebaseClient = new FirebaseClient(this, DB_URL, rv);
        firebaseClient.refreshData();


    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(requestCode==9 && resultCode == RESULT_OK) {
            Uri photoData = data.getData();
            if (photoData!=null) {
                Intent it = new Intent(PageAddIcon.this, Cad_nick_foto_Activity.class);
                it.putExtra("caminho_foto", photoData);
                startActivity(it);

            }

            Bitmap photoBitmap = null;
            try {
                photoBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), photoData);
               // imageNick.setImageBitmap(photoBitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /*
    CAMINHO DA IMAGEM
    public String getImagePath(Uri contentUri) {
        String[] campos = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(contentUri, campos, null, null, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
        cursor.close();
        return path;
    }
    */
}