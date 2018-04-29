package com.example.fulanoeciclano.DAO;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by fulanoeciclano on 29/04/2018.
 */

public class ConfiguracaoFirebase {

    private static DatabaseReference referencefirebase;
    private static FirebaseAuth autenticacao;

    public static DatabaseReference getFirebase(){
        if(referencefirebase ==null){
            referencefirebase= FirebaseDatabase.getInstance().getReference();
        }
        return referencefirebase;
    }
    public static FirebaseAuth getFirebaseAuth(){
        if(autenticacao== null){
            autenticacao= FirebaseAuth.getInstance();
        }
        return autenticacao;
    }
}
