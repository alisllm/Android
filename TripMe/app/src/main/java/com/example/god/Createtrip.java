package com.example.god;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.mapview.MapView;

public class Createtrip extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    private MapView mapview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("92f5caa0-3417-4288-be44-9dd46c7b3b7f");
        setContentView(R.layout.activity_createtrip);
        editText = findViewById(R.id.editText6);
        editText2 = findViewById(R.id.editText7);
    }
    EditText departT;
    EditText cominOUT;
    EditText kolvo;
    EditText price;
    EditText info;
    public void done(View view)
    {
        departT = findViewById(R.id.editText6);
        cominOUT = findViewById(R.id.editText7);
        kolvo = findViewById(R.id.editText8);
        price = findViewById(R.id.editText9);
        info = findViewById(R.id.editText11);


        Intent intent = new Intent(this, trip_info.class);
        intent.putExtra("depart", departT.getText().toString());
        intent.putExtra("cominOUT", cominOUT.getText().toString());
        intent.putExtra("kolvo", kolvo.getText().toString());
        intent.putExtra("price", price.getText().toString());
        intent.putExtra("info", info.getText().toString());

        startActivity(intent);

    }

    public void back(View view)
    {
        final Intent intent = new Intent(this, navig.class);
        new AlertDialog.Builder(this)
                .setMessage("Вы действительно хотите покинуть окно?")
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();

                       startActivity(intent);
                    }
                }).setNegativeButton("Нет", null).show();
    };

}
