package com.example.god;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class trip_info extends AppCompatActivity {

    private MapView mapview;
    private TextView depart;
    private TextView cominOUT;
    private TextView kolvo;
    private TextView price;
    private TextView info ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_info);
        MapKitFactory.setApiKey("92f5caa0-3417-4288-be44-9dd46c7b3b7f");
        MapKitFactory.initialize(this);
        mapview = (MapView)findViewById(R.id.mapview);
        mapview.getMap().move(
                new CameraPosition(new Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);


        depart = findViewById(R.id.textView12);
        cominOUT = findViewById(R.id.textView16);
        kolvo = findViewById(R.id.textView17);
        price = findViewById(R.id.textView19);
        info  = findViewById(R.id.editText5);

        String txtName = getIntent().getStringExtra("depart");
        String cominS = getIntent().getStringExtra("cominOUT");
        String kolvoS = getIntent().getStringExtra("kolvo");
        String priceS = getIntent().getStringExtra("price");
        String infoS = getIntent().getStringExtra("info");

        depart.setText(depart.getText().toString() + "" + txtName);
        cominOUT.setText(cominOUT.getText().toString() + "" + cominS);
        kolvo.setText(kolvo.getText().toString() + "" + kolvoS);
        price.setText(price.getText().toString() + "" + priceS);
        info.setText(info.getText().toString() + "" + infoS);


    }

    @Override
    protected void onStop() {
        super.onStop();
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapview.onStart();
        MapKitFactory.getInstance().onStart();
    }

    public void back(View view)
    {
        final  Intent intent = new Intent(this,Createtrip.class);
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
