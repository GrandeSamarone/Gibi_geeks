package com.example.fulanoeciclano.gibi_geeks.Paginas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.fulanoeciclano.gibi_geeks.R;

public class Soprateste extends AppCompatActivity {
    final static String DB_URLS="https://geeksgibi.firebaseio.com/Marvel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soprateste);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
