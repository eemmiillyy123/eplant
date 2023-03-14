package com.example.e_plants;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class list  extends AppCompatActivity {
        //implements RecycleviewInterface {
    RecyclerView recyclerView;
   // ArrayList<Cricketer> alist;
    DatabaseReference databaseReference;
    MyAdapter adapter;
    DAOEmployee dao;
    String key=null;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(list.this,new_plant_A.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ulist);
        recyclerView=findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
       // alist=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MyAdapter(this);
        recyclerView.setAdapter(adapter);
        //databaseReference= FirebaseDatabase.getInstance().getReference("users");
        dao=new DAOEmployee();
        loadDate();
        /*
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()) {
                    Cricketer user_data = ds.getValue(Cricketer.class);
                    alist.add(user_data);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
*/
    }
    private void loadDate() {
        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Cricketer> alist=new ArrayList<>();
               for(DataSnapshot ds:snapshot.getChildren()) {
                    //VH vh;
                    //vh.textOption.setOnClickListener(v->{)
                    Cricketer user_data = ds.getValue(Cricketer.class);
                    user_data.setKey(ds.getKey());
                    alist.add(user_data);
                    key=ds.getKey();
                    System.out.println("alist"+alist);
                }
                adapter.setItems(alist);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

   /* @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(list.this,diary.class);
        startActivity(intent);
    }
    //*/

}
