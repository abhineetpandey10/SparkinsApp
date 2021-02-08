package com.sparkee.sparkinsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static int tap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView image1 = findViewById(R.id.imageView1);
        ImageView image2 = findViewById(R.id.imageView2);
        ImageView image3 = findViewById(R.id.imageView3);
        ImageView image4 = findViewById(R.id.imageView4);
        ImageView image5 = findViewById(R.id.imageView5);
        ImageView image6 = findViewById(R.id.imageView6);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tap=1;
                Intent intent= new Intent(MainActivity2.this,CameraXLivePreviewActivity.class);
                startActivity(intent);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tap=2;
                Intent intent2= new Intent(MainActivity2.this,CameraXLivePreviewActivity.class);
                startActivity(intent2);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tap=3;
                Intent intent3= new Intent(MainActivity2.this,CameraXLivePreviewActivity.class);
                startActivity(intent3);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tap=4;
                Intent intent4= new Intent(MainActivity2.this,CameraXLivePreviewActivity.class);
                startActivity(intent4);
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tap=5;
                Intent intent5= new Intent(MainActivity2.this,CameraXLivePreviewActivity.class);
                startActivity(intent5);
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tap=6;
                Intent intent6= new Intent(MainActivity2.this,CameraXLivePreviewActivity.class);
                startActivity(intent6);
            }
        });




    }
}