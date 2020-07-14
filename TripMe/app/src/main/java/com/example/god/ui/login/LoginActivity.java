package com.example.god.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.god.CreateAkk;
import com.example.god.R;
import com.example.god.navig;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
    }

    public void Voiti(View view)
    {
        if (email.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin"))
        {
            Toast.makeText(getApplicationContext(), "Welcome admin", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, navig.class);
            startActivity(intent);
        }
        if (email.getText().toString().equals("example@mail.ru") &&
                password.getText().toString().equals("0000"))
        {
            Toast.makeText(getApplicationContext(), "Welcome example", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, navig.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Данные не найдены", Toast.LENGTH_LONG).show();
        }
    }

    public void createAkk(View view)
    {
        Intent intent = new Intent(this, CreateAkk.class);
        startActivity(intent);
    }
}

