package com.example.lab_1_2_rishabhsingh_c0788019_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dataBaseHelper  extends SQLiteOpenHelper {
    public static final String PRODUCT_TABLE = "PRODUCT_TABLE";
    public static final String PRODUCT_ID = "PRODUCT_ID";
    public static final String PRODUCT_NAME = "PRODUCT_NAME";
    public static final String PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";
    public static final String PRODUCT_PRICE = "PRODUCT_PRICE";
    public static final String LATITUDE = "LATITUDE";
    public static final String LONGITUDE = "LONGITUDE";

    public dataBaseHelper(@Nullable Context context) {
        super(context, "product.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createDataBaseStatement = "CREATE TABLE " + PRODUCT_TABLE + " (" + PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + PRODUCT_NAME + " TEXT , " + PRODUCT_DESCRIPTION + " TEXT ,  " + PRODUCT_PRICE + "  DOUBLE , " + LATITUDE + " DOUBLE , " + LONGITUDE + " DOUBLE)";
    db.execSQL(createDataBaseStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Boolean addData(productsModelClass prod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PRODUCT_NAME,prod.getName());
        cv.put(PRODUCT_DESCRIPTION,prod.getDescription());
        cv.put(PRODUCT_PRICE,prod.getPrice());
        cv.put(LATITUDE,prod.getLatitude());
        cv.put(LONGITUDE,prod.getLongitude());
        long insert = db.insert(PRODUCT_TABLE, null, cv);
        if(insert == -1)
            return false;

            return true;

    }


    public List allDataReturn() {
        List<productsModelClass> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + PRODUCT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int proID = cursor.getInt(0);
                String prodName = cursor.getString(1);
                String prodDes = cursor.getString(2);
                Double prodPrice = cursor.getDouble(3);
                Double lati = cursor.getDouble(4);
                Double longi = cursor.getDouble(5);
                productsModelClass prdInst = new productsModelClass(proID, prodName, prodDes, prodPrice, lati, longi);

                returnList.add(prdInst);
            }
            while (cursor.moveToNext());

        } else {   // failed to retrive data}


        }
        return returnList;
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("DELETE FROM "+ PRODUCT_TABLE);

    }




    }
