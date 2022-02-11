package com.example.lab_1_2_rishabhsingh_c0788019_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView allProductsTable;

    ImageButton addBt;


    dataBaseHelper dbHelper = new dataBaseHelper(MainActivity.this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       allProductsTable = findViewById(R.id.lvTable);
       addBt = findViewById(R.id.btMovetoadd);
//dbHelper.deleteAll();


        allProductsTable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"click detected",Toast.LENGTH_SHORT).show();
               int  index =  position;
                Intent detailSCreen = new Intent(MainActivity.this,detailView.class);
               // detailSCreen.putExtra("scr",index);
                startActivity(detailSCreen);
            }
        });


       addBt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent movetoADDScreen = new Intent(MainActivity.this,newEntry.class);
               startActivity(movetoADDScreen);

           }
       });

      preFedData();
     loadTable();





    }








    public void preFedData(){
        List<productsModelClass> predefined = new ArrayList<>();

        predefined.add(new productsModelClass(1,"TOOTH PASTE","oralhygiene",23.5,67,78));
        predefined.add(new productsModelClass(2,"PEPSI","soft drink",2.5,67,78));
        predefined.add(new productsModelClass(3,"ASPRIN","drug",35,-67,92));
        predefined.add(new productsModelClass(4,"iPHONE","mobile phone",1200,89,20));
        predefined.add(new productsModelClass(5,"BACKPACK","travelling gear",58.0,35,37));
        predefined.add(new productsModelClass(6,"AIRPODS","bluetooth earphones",350,78,42));
        predefined.add(new productsModelClass(7,"NOTEBOOK","Stationary",6.0,45,90));
        predefined.add(new productsModelClass(8,"CHAIR","furniture",90,23.5,78.9));
        predefined.add(new productsModelClass(9,"JEANS","apparels",80,90,90));
        predefined.add(new productsModelClass(10,"APPLE","fruit",1.5,99,88.80));



        for (int i = 0 ; i < predefined.size();i++){
            productsModelClass proModCls;


            proModCls = new productsModelClass(predefined.get(i).getId(),predefined.get(i).getName(),predefined.get(i).getDescription(),predefined.get(i).getPrice(),predefined.get(i).getLatitude(),predefined.get(i).getLongitude());

            dataBaseHelper dbHelper = new dataBaseHelper(MainActivity.this);
            dbHelper.addData(proModCls);


        }







    }

    public void loadTable(){
        allProductsTable.setAdapter(new tableViewAdapter(MainActivity.this,dbHelper.allDataReturn()));

    }





}