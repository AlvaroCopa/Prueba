package com.example.ejemplo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AdiciFarmaceuticoActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adici_farmaceutico);

    }
    public void cancelar(View view) {
        onBackPressed();
        finish();
    }
}