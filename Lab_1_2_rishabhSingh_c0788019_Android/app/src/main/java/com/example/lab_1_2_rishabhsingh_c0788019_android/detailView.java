package com.example.lab_1_2_rishabhsingh_c0788019_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class detailView extends AppCompatActivity {
     Button backButton,update;
     TextView id;
     EditText name ,longi,lati,price;
     ImageButton mapIcon,delete;
     AutoCompleteTextView desc;
    dataBaseHelper dbHelper = new dataBaseHelper(detailView.this);
    List<productsModelClass> recievedAll = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        int recivedIndex = getIntent().getIntExtra("scr",0);

        name = findViewById(R.id.etxtDname);
        desc = findViewById(R.id.atxtDesc);
        id = findViewById(R.id.tvpid);
        price = findViewById(R.id.etxtDprice);
        longi = findViewById(R.id.etxtDLongi);
        lati = findViewById(R.id.etxtDlati);
        backButton = findViewById(R.id.btBacktoMain2);
        update = findViewById(R.id.btUpdate);
        mapIcon = findViewById(R.id.ibtMap);
        delete = findViewById(R.id.ibtDelete);


        recievedAll = dbHelper.allDataReturn();
        Intent movetoMainScreen = new Intent(detailView.this,MainActivity.class);





        id.setText(String.valueOf(recievedAll.get(recivedIndex).getId()));
        name.setText(recievedAll.get(recivedIndex).getName());
        desc.setText(recievedAll.get(recivedIndex).getDescription());
        price.setText(String.valueOf(recievedAll.get(recivedIndex).getPrice()));
        longi.setText(String.valueOf(recievedAll.get(recivedIndex).getLongitude()));
        lati.setText(String.valueOf(recievedAll.get(recivedIndex).getLatitude()));



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(movetoMainScreen);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int uID = Integer.parseInt(String.valueOf(id.getText()));
                Double uPrice = Double.parseDouble(String.valueOf(price.getText()));
                Double uLongi = Double.parseDouble(String.valueOf(longi.getText()));
                Double uLati = Double.parseDouble(String.valueOf(lati.getText()));

                String uName = String.valueOf(name.getText());
                String uDesc = String.valueOf(desc.getText());





                productsModelClass updateProduct;
                if((uLati <= 90 && uLati >= -90 ) && (uLongi <= 180 && uLongi >= -180)) {
                    try {
                        updateProduct = new productsModelClass(uID, uName, uDesc, uPrice, uLati, uLongi);
                        dbHelper.updateRow(updateProduct);
                        startActivity(movetoMainScreen);
                        Toast.makeText(detailView.this, "updated", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(detailView.this, "All fields Manadtory", Toast.LENGTH_SHORT).show();
                    }
                }
                else{                         Toast.makeText(detailView.this, "(Latitude range -90 to 90) && (Longitude range -180 to 180 )", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mapIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoMaps = new Intent(detailView.this,UserLocation.class);


                movetoMaps.putExtra("lon",recievedAll.get(recivedIndex).getLongitude());
                movetoMaps.putExtra("lat",recievedAll.get(recivedIndex).getLatitude());
                startActivity(movetoMaps);

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.deleteRow(recievedAll.get(recivedIndex).getId());
                startActivity(movetoMainScreen);
            }
        });




    }
}