package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static List<String> ListTitle = new ArrayList<String>();
    public static List<String> ListAuthor = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        SQLiteDatabase DatabaseShop = openOrCreateDatabase("ksiegarnia.db", Context.MODE_PRIVATE, null);

        Cursor c = DatabaseShop.rawQuery("SELECT * FROM ksiegarnia ;", null);
        Cursor d = DatabaseShop.rawQuery("SELECT * FROM ksiegarnia ;", null);
        Cursor e = DatabaseShop.rawQuery("SELECT * FROM ksiegarnia ;", null);
        c.moveToFirst();
        d.moveToFirst();
        e.moveToFirst();


        for (int i = 0; i < c.getCount(); i++) {

            //ListId.add(c.getString(i));
            for (int k = 1; k < 2; k++) {

                ListTitle.add(d.getString(k));
            }
            for (int l = 2; l < 3; l++) {

                ListAuthor.add(e.getString(l));
            }
            c.moveToNext();
            d.moveToNext();
            e.moveToNext();
        }

    }

    public void Warehouse(View VVV){
        Intent i = new Intent(getApplicationContext(), Warehouse.class);
        startActivity(i);

    }
    public void Shop(View vv){
        Intent i = new Intent(getApplicationContext(), Shop.class);
        startActivity(i);
    }
}