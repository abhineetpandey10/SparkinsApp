package com.sparkee.sparkinsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddMedicine extends AppCompatActivity {

    private EditText medname,meddesc;
    private NumberPicker numpick;
    private Button savebtn,show;
    private FirebaseDatabase db= FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("medicines");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        meddesc=findViewById(R.id.description);
        medname=findViewById(R.id.name);
        savebtn=findViewById(R.id.savebtn);
        numpick=findViewById(R.id.numpick);
        numpick.setMaxValue(10);
        numpick.setMinValue(1);

        show=findViewById(R.id.showbtn);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= medname.getText().toString();
                String desc= meddesc.getText().toString();
                int priority=numpick.getValue();

                MedicineHelper medihelp= new MedicineHelper(name,desc,priority);

                root.child(String.valueOf(priority)).setValue(medihelp).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(AddMedicine.this,"Saved",Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AddMedicine.this,MedicineActivity.class);
                startActivity(intent);

            }
        });
    }
}