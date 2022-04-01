package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AppCompatActivity {

    String Title1, Author1;


    public static MainActivity database1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);


        ListView listTytul=(ListView)findViewById(R.id.Title);
        ListView listAuthor=(ListView)findViewById(R.id.Author);



        ArrayAdapter Tit=new ArrayAdapter<String>(Warehouse.this, android.R.layout.simple_list_item_1, database1.ListTitle);
        ArrayAdapter Aut=new ArrayAdapter<String>(Warehouse.this, android.R.layout.simple_list_item_1, database1.ListAuthor);

       listTytul.setAdapter(Tit);
       listAuthor.setAdapter(Aut);



    }


    public void Save(View vv) {
        EditText titleEdit = (EditText) findViewById(R.id.editTextTitle);
        EditText authorEdit = (EditText) findViewById(R.id.editTextAuthor);

        Title1 = titleEdit.getText().toString();
        Author1 = authorEdit.getText().toString();

        SQLiteDatabase database = openOrCreateDatabase("ksiegarnia.db", Context.MODE_PRIVATE, null);
        // baza.execSQL("CREATE TABLE IF NOT EXISTS 'ksiazki' (id INTEGER PRIMARY KEY, tytul STRING, autor STRING)");
        database.execSQL("INSERT INTO ksiegarnia (tytul,autor) VALUES ('" + Title1 + "','" + Author1 + "')");

    }
}

