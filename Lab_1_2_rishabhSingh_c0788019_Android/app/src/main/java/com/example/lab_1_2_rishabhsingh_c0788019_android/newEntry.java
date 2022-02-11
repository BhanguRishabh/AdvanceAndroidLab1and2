package com.example.lab_1_2_rishabhsingh_c0788019_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class newEntry extends AppCompatActivity {
    Button back ;
    ImageButton save;
    EditText name,desc,price,longi,lati;


    MainActivity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        back = findViewById(R.id.btBacktoMain);
        save = findViewById(R.id.btSave);
        name = findViewById(R.id.etxtName);
        desc = findViewById(R.id.etxtDes);
        price = findViewById(R.id.etxtPrice);
        longi = findViewById(R.id.etxtLong);
        lati = findViewById(R.id.etxtLat);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoMainScreen = new Intent(newEntry.this,MainActivity.class);
                startActivity(movetoMainScreen);

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productsModelClass  prdMdl = new productsModelClass(-1, "name", "viuhnbjg", 67.99, 67.99, 67.99);
                dataBaseHelper dbhelper = new dataBaseHelper(newEntry.this);

                Boolean aBoolean = dbhelper.addData(prdMdl);

//              try {
//
//
////                  prdMdl = new productsModelClass(-1, name.getText().toString(), desc.getText().toString(), Double.parseDouble(price.getText().toString()), Double.parseDouble(lati.getText().toString()), Double.parseDouble(longi.getText().toString()));
//              }
//
//              catch(Exception e){
//
//                  prdMdl = new productsModelClass(-1,"error","error",0,0,0);
//                  Toast.makeText(newEntry.this,"error",Toast.LENGTH_SHORT).show();}


               // Toast.makeText(newEntry.this,aBoolean.toString(),Toast.LENGTH_SHORT).show();

               // mainActivity.loadTable();








/// --- moving to mainActivity
                Intent movetoMainScreen = new Intent(newEntry.this,MainActivity.class);
                startActivity(movetoMainScreen);

            }

        });
    }
}