package com.example.lab_1_2_rishabhsingh_c0788019_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class newEntry extends AppCompatActivity {
    Button back ;
    Button save;
    EditText name,desc,price,longi,lati;
    //dataBaseHelper dbhelper = new dataBaseHelper(newEntry.this);
    dataBaseHelper dbHelper = new dataBaseHelper(newEntry.this);
    productsModelClass proModCls;
    MainActivity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        back = findViewById(R.id.btBacktoMain);
        save = findViewById(R.id.btsave);
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

                if (true){


                    Double uLati = Double.parseDouble(lati.getText().toString());
                    Double uLongi = Double.parseDouble(longi.getText().toString());

                    if((uLati <= 90 && uLati >= -90 ) && (uLongi <= 180 && uLongi >= -180)){

                        try {


                            proModCls = new productsModelClass(-1, name.getText().toString(), desc.getText().toString(), Double.parseDouble(price.getText().toString()), Double.parseDouble(lati.getText().toString()), Double.parseDouble(longi.getText().toString()));
                            dbHelper.addData(proModCls);
                            // --- moving to mainActivity
                            Intent movetoMainScreen = new Intent(newEntry.this,MainActivity.class);
                            startActivity(movetoMainScreen);
                        }

                        catch(Exception e){


                            Toast.makeText(newEntry.this,"error while saving data",Toast.LENGTH_SHORT).show();} }
                    else {
                        Toast.makeText(newEntry.this, "(Latitude range -90 to 90) && (Longitude range -180 to 180 )", Toast.LENGTH_SHORT).show();
                    }


                }
                else{ Toast.makeText(newEntry.this,"All fields Manadtory",Toast.LENGTH_SHORT).show(); }

            }

        });














    }
public Boolean isEmpty(){
    if(TextUtils.isEmpty(name.getText().toString()) && TextUtils.isEmpty(desc.getText().toString()) && TextUtils.isEmpty(price.getText().toString())  && TextUtils.isEmpty(lati.getText().toString()) && TextUtils.isEmpty(longi.getText().toString()))
        return true;


  return false; }





}