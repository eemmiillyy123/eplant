package com.example.e_plants;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Queue;

public class DAOEmployee {
    private DatabaseReference  databaseReference;
    private FirebaseDatabase db;
    private String emailName;
    String Uid;
    public DAOEmployee(){
        FirebaseAuth mAuth1 = FirebaseAuth.getInstance();
        FirebaseUser user=mAuth1.getCurrentUser();
        //email=user.getEmail();
        db=FirebaseDatabase.getInstance();
        FirebaseDatabase.getInstance();
        Uid=user.getUid();
        //emailName=new login_A().getEmail();
        System.out.println("Uid=="+Uid);

        //databaseReference=db.getReference(email);
        databaseReference=db.getReference(Cricketer.class.getSimpleName());
    }
    public Task<Void> add(Cricketer emp){
            //email=new login_A().getEmail();
           //return databaseReference.child(emailName).setValue(emp);
            return databaseReference.child(Uid).push().setValue(emp);
    }
    public Task<Void> update(String key, HashMap<String,Object>hashMap){
        //db=FirebaseDatabase.getInstance();
        //databaseReference=db.getReference(Cricketer.class.getSimpleName());
       // email=new login_A().getEmail();
        return  databaseReference.child(Uid).child(key).updateChildren(hashMap);
    }
    public Task<Void> remove(String key){
        //email=new login_A().getEmail();
        return  databaseReference.child(Uid).child(key).removeValue();
    }
    public Query get(){
        return  databaseReference.child(Uid).orderByKey();
    }
}
