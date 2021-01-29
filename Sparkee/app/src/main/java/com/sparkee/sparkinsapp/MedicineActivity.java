package com.sparkee.sparkinsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MedicineActivity extends AppCompatActivity {

    private FloatingActionButton addfab;

    private RecyclerView medilist;
    private FirebaseDatabase db= FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("medicines");
    private MedicineAdapter medadapter;
    private ArrayList<MedicineHelper> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        addfab= (FloatingActionButton)findViewById(R.id.addfab);

        medilist=(RecyclerView)findViewById(R.id.medilist);
        medilist.setHasFixedSize(true);
        list=new ArrayList<>();
        medadapter= new MedicineAdapter(this,list);
        medilist.setAdapter(medadapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    MedicineHelper model= dataSnapshot.getValue(MedicineHelper.class);
                    list.add(model);
                }
                medadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        medilist.setLayoutManager(new LinearLayoutManager(this));
        addfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fabint= new Intent(MedicineActivity.this,AddMedicine.class);
                startActivity(fabint);
            }
        });
    }
}