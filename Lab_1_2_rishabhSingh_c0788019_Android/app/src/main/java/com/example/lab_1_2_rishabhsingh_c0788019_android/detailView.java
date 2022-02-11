package com.example.lab_1_2_rishabhsingh_c0788019_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detailView extends AppCompatActivity {
     TextView name,desc,id,longi,lati,price;
    //int recievedIndex = getIntent().getIntExtra("scr",0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        name = findViewById(R.id.tvPname);
        desc = findViewById(R.id.tvpdesc);
        id = findViewById(R.id.tvpid);
        price = findViewById(R.id.tvpPrice);
        longi = findViewById(R.id.tvpLongi);
        lati = findViewById(R.id.tvpLati);

        //id.setText();



    }
}