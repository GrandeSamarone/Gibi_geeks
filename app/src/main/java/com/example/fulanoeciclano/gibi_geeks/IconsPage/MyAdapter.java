package com.example.fulanoeciclano.gibi_geeks.IconsPage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fulanoeciclano.gibi_geeks.Pag_nick_foto.Cad_nick_foto_Activity;
import com.example.fulanoeciclano.gibi_geeks.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;

import java.util.List;

/**
 * Created by fulanoeciclano on 21/04/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder>  {
View v;
    Context c;
    private CardView card;
    private String imagePath;
    List<Icones> icones;


    public MyAdapter(Context c, List<Icones> icones) {
        this.c = c;
        this.icones = icones;

    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, parent, false);
        final  MyHolder holder = new  MyHolder(v);



/**/
                      /*
                        Intent intent = new Intent(c, Cad_nick_foto_Activity.class);
                        intent.putExtra("url", icones.get(position).getUrl()+icones.get(position).toString());
                Toast.makeText(c, icones.get(position).getUrl(), Toast.LENGTH_SHORT).show();
                        Log.i("txt",icones.get(position).getUrl().toString());
                        c.startActivity(intent);
                        */


            return holder;


    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        //  holder.nameTxt.setText(movies.get(position).getName());
        holder.carmodelo.setRadius(0);
        holder.carmodelo.setCardElevation(0);
        Uri uriOne= Uri.parse(icones.get(position).getUrl());

        DraweeController controllerOne = Fresco.newDraweeControllerBuilder()
                .setUri(uriOne)
                .setAutoPlayAnimations(true)

                .build();

        holder.draweeView.setController(controllerOne);



        holder.carmodelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position!=0){
                  Intent intent=new Intent(c, Cad_nick_foto_Activity.class);
                  intent.putExtra("caminho_foto",icones.get(position).getUrl());
                  c.startActivity(intent);
                }
            }
        });


    }

    /*
    public Icones getItem(int position) {
        return icones.get(position);
    }
*/
    @Override
    public int getItemCount() {
        return icones.size();
    }
}
