package com.example.ejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }
    public void register(View view){
        startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
        //finish();
    }

    public void login(View view) {
        startActivity(new Intent(getApplicationContext(), ViewDoctorActivity.class));
    }
}