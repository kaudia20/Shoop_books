package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Shop extends AppCompatActivity {

    String WantedTitle;
    int cosie=0;
    public static MainActivity database1;
    public List ListTitles, ListAuthors;
    String wantedTitle, wantedAuthor;
    EditText editS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ListTitles= database1.ListTitle;

    }
    public void Search(View vv) {
        Boolean looking=false;
        EditText editS = (EditText) findViewById(R.id.editTextSearch);
        WantedTitle = editS.getText().toString();
        TextView Szukane = (TextView) findViewById(R.id.textViewFound);

        for (int i = 0; i < database1.ListTitle.size(); i++) {

            if (WantedTitle.equals(database1.ListTitle.get(i))) {
                cosie = i;
                String cos = String.valueOf(cosie);
                Szukane.setText(database1.ListTitle.get(i) + ",  " + database1.ListAuthor.get(i));
                wantedTitle=database1.ListTitle.get(i);
                wantedAuthor=database1.ListAuthor.get(i);
                looking=true;

            }

        }
        if(looking==false) // !looking
        {
            Szukane.setText("Not Found");
        }
    }

    public void SaveDoc(View vvv)
    {
        FileOutputStream file1;

        String html1="<html>\n" +
                "<style>\n" +
                "table, th, td {\n" +
                "  border:1px solid black;\n" +
                "}\n" +
                "</style>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Your order</h2>\n" +
                "\n" +
                "<table style=\"width:100%\">\n" +
                "  <tr>\n" +
                "    <th>Title</th>\n" +
                "    <th>Author</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>" + wantedTitle + "</td>\n" +
                "    <td>"+ wantedAuthor+"</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        try {
            file1 = openFileOutput("Order.doc", MODE_APPEND);
            file1.write(html1.getBytes());
            file1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    }

