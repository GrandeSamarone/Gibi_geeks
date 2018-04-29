package com.example.fulanoeciclano.gibi_geeks.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fulanoeciclano.gibi_geeks.R;


public class Tela_inicial extends Fragment {
    final static String DB_URLS="https://geeksgibi.firebaseio.com/";
   // private HQFirebase hqFirebase;
   // private RecyclerView recyclerViewhq;
   // private ArrayList<HQ>hq;

   public Tela_inicial(){
     //  recyclerViewhq=getView().findViewById(R.id.recyclemarvel);

     //  hqFirebase =new HQFirebase(getContext(),DB_URLS,recyclerViewhq);
     //  hqFirebase.refreshData();

   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tela_inicial, container, false);



    }
}
