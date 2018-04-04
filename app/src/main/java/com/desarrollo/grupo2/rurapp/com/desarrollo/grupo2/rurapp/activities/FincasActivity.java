package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.desarrollo.grupo2.rurapp.R;

public class FincasActivity extends AppCompatActivity {

    private FloatingActionButton buttonAgregarFinca;

    /**
     * Método que se ejecuta al crear el activity
     * @param savedInstanceState : Estado de la app.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fincas);
        buttonAgregarFinca = findViewById(R.id.floatingActionButton);
        buttonAgregarFinca.setOnClickListener(onClickAgregarFinca());
    }

    /**
     * Método que devuelve un objeto tipo Listener, este método ocurre cuando le dan click al botón
     * agregar finca.
     * @return : Evento tipo Listener.
     */
    private View.OnClickListener onClickAgregarFinca(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivityAgregarFica();
            }
        };
        return evento;
    }

    /**
     * Método que se utiliza para lanzar una intención con el porposito de abrir el activity Agregar
     * Finca.
     */
    private void lanzarActivityAgregarFica() {
        Intent activityAgregarFinca = new Intent(this,AgregarFincaActivity.class);
        startActivity(activityAgregarFinca);
    }
}
