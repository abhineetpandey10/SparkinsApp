package com.sparkee.sparkinsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddMedicine extends AppCompatActivity {

    private EditText medname,meddesc;
    private NumberPicker numpick;
    private Button savebtn;
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

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= medname.getText().toString();
                String desc= meddesc.getText().toString();
                int priority=numpick.getValue();

                MedicineHelper medihelp= new MedicineHelper(name,desc,priority);

                root.child(String.valueOf(priority)).setValue(medihelp);



            }
        });
    }
}