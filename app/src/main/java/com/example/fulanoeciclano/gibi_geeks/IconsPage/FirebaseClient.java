package com.example.fulanoeciclano.gibi_geeks.IconsPage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

/**
 * Created by fulanoeciclano on 21/04/2018.
 */

public class FirebaseClient {
    Context c;
    String DB_URL;
    RecyclerView rv;

    Firebase fire;
    ArrayList<Icones> icones=new ArrayList<>();
    MyAdapter adapter;

    public FirebaseClient(Context c, String DB_URL, RecyclerView rv) {
        this.c = c;
        this.DB_URL = DB_URL;
        this.rv = rv;

        //INITIALIZE
        Firebase.setAndroidContext(c);
        //INSTANTIATE
        fire=new Firebase(DB_URL);
    }

    //SAVE
    /*
    public void saveOnline(String name,String url)
    {
        Icones m=new Icones();
        m.setName(name);
        m.setUrl(url);

        fire.child("Icones").push().setValue(m);
    }
    */

    //RETRIEVE
    public void refreshData()
    {
        fire.addChildEventListener(new com.firebase.client.ChildEventListener() {
            @Override
            public void onChildAdded(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(com.firebase.client.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void getUpdates(com.firebase.client.DataSnapshot dataSnapshot)
    {
       icones.clear();
        for(com.firebase.client.DataSnapshot ds : dataSnapshot.getChildren())
        {
            Icones m=new Icones();
            m.setName(ds.getValue(Icones.class).getName());
            m.setUrl(ds.getValue(Icones.class).getUrl());

           icones.add(m);
        }

        if(icones.size()>0)
        {
            adapter=new MyAdapter(c,icones);
            rv.setAdapter(adapter);
        }else {
            Toast.makeText(c,"No data", Toast.LENGTH_SHORT).show();
        }
    }

}
