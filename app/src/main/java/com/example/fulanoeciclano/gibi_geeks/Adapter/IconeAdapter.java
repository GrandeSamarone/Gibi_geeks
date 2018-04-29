package com.example.fulanoeciclano.gibi_geeks.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.fulanoeciclano.gibi_geeks.R;

/**
 * Created by fulanoeciclano on 19/04/2018.
 */

public class IconeAdapter extends BaseAdapter {

private Context ctx;
    private  String[] Iconevalue;

    public IconeAdapter(Context ctx,String[] Iconevalue){
        this.ctx=ctx;
        this.Iconevalue=Iconevalue;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(ctx);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.icone, null);


            // set image based on selected text
            ImageView imageView = gridView
                    .findViewById(R.id.img_icone);



            /*
            String Iconeheroi = Iconevalue[position];
            if (Iconeheroi.equals("cptAmeria")) {
                imageView.setImageResource(Integer.parseInt("gs://geeksgibi.appspot.com/iconesperfil/escudoasa.png"));
            } else if (Iconeheroi.equals("iOS")) {
                Picasso.with(ctx).load("gs://geeksgibi.appspot.com/iconesperfil/escudoasa.png").into(imageView);
            } else if (Iconeheroi.equals("Blackberry")) {
                Picasso.with(ctx).load("gs://geeksgibi.appspot.com/iconesperfil/drestranho.png").into(imageView);
            } else {
                Picasso.with(ctx).load("gs://geeksgibi.appspot.com/iconesperfil/drestranho.png").into(imageView);
            }
            */

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return Iconevalue.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



}
