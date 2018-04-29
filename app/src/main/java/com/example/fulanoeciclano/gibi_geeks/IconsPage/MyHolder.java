package com.example.fulanoeciclano.gibi_geeks.IconsPage;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fulanoeciclano.gibi_geeks.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by fulanoeciclano on 21/04/2018.
 */

public class MyHolder extends RecyclerView.ViewHolder {
    CardView carmodelo;
    SimpleDraweeView draweeView;



    public MyHolder(final View itemView) {
        super(itemView);
        // nameTxt=  itemView.findViewById(R.id.nameTxt);
        carmodelo = itemView.findViewById(R.id.modelcard);
        draweeView= (SimpleDraweeView) itemView.findViewById(R.id.drawee_foto);

        /*
       carmodelo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

      // Icones icones = new Icones();
        Toast.makeText(v.getContext(), "You clicked "+getLayoutPosition(), Toast.LENGTH_SHORT).show();
if(getLayoutPosition()==(0)){

}

    }
});
*/
    }



}
