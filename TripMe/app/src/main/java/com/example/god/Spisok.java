package com.example.god;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Spisok extends AppCompatActivity
{
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spisok);
        ListView listView = findViewById(R.id.listView);
        final String[] catNames = new String[]
        {
                "18 мая 20:00 \nОсталось мест: 2\n1000р", "5 июня 10:19 \nОсталось мест: 1 \n900р",
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNames);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    case 0:
                      //  startActivity(new Intent(context, trip_info.class));
                        break;
                    case 1:
                        startActivity(new Intent(context, trip_info.class));
                        break;
                }
            }
        });
    }
}
