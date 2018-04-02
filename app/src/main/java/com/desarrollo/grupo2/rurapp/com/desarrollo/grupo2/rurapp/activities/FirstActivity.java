package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Administrador;


public class FirstActivity extends AppCompatActivity {

    private Administrador administrador;
    private TextView bienvenido;
    private TextView gmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        this.bienvenido = findViewById(R.id.textView1);
        this.gmail = findViewById(R.id.textView2);
        this.administrador = getIntent().getParcelableExtra("administrador");
        actualizarUI();
        Toast.makeText(this,"Bienvenido "+administrador.getUsuario(),
                Toast.LENGTH_SHORT).show();
    }

    private void actualizarUI(){
        this.bienvenido.setText(administrador.getUsuario());
        this.gmail.setText(administrador.getCorreo());
    }

}
