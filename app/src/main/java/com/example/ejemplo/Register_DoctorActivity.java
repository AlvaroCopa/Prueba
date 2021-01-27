package com.example.ejemplo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Register_DoctorActivity extends AppCompatActivity {

    TextInputEditText nombre;
    TextInputEditText apellido;
    TextInputEditText direc;
    TextInputEditText cel;
    TextInputEditText ci;
    TextInputEditText nroMat,esp;
    TextInputEditText email;
    TextInputEditText pass;
    TextInputEditText pass2;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__doctor);
        nombre = (TextInputEditText) findViewById(R.id.nombre);
        apellido = (TextInputEditText) findViewById(R.id.apellido);
        direc = (TextInputEditText) findViewById(R.id.direccion);
        ci = (TextInputEditText) findViewById(R.id.ci);
        cel = (TextInputEditText) findViewById(R.id.celular);
        nroMat = (TextInputEditText) findViewById(R.id.matricula);
        esp = (TextInputEditText) findViewById(R.id.especialidad);
        email = (TextInputEditText) findViewById(R.id.email);
        pass = (TextInputEditText) findViewById(R.id.contrasena);
        pass2 = (TextInputEditText) findViewById(R.id.contrasena2);
        btnRegister = (Button) findViewById(R.id.register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send("https://doctormario.000webhostapp.com/doctor.php");
            }
        });
    }

    private void send(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("firstName",nombre.getText().toString());
                parametros.put("secondName",nombre.getText().toString());
                parametros.put("address",direc.getText().toString());
                parametros.put("ci",ci.getText().toString());
                parametros.put("nroMatricula",nroMat.getText().toString());
                parametros.put("especialidad",esp.getText().toString());
                parametros.put("phone",cel.getText().toString());
                parametros.put("email",email.getText().toString());
                parametros.put("password",pass.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void cancelar(View view) {
        onBackPressed();
        finish();
    }
}