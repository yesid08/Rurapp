package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.desarrollo.grupo2.rurapp.R;

public class ActividadesActivity extends AppCompatActivity {

    private FloatingActionButton buttonAgregarActividades;
    /**
     * Método que se ejecuta cuando se crea el Activity Actividades
     * @param savedInstanceState : El estado del activity.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);
        this.buttonAgregarActividades = findViewById(R.id.floatingActionButton2);
        this.buttonAgregarActividades.setOnClickListener(onClickAgregarActividades());
    }

    /**
     * Método que se encarga de Asignar un evento al hacer click al botón agregarActividades.
     * @return
     */
    private View.OnClickListener onClickAgregarActividades(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivityAgregarActividades();
            }
        };
        return evento;
    }

    /**
     * Método que se utiliza para lanzar el activity Agregar actividades
     */
    private void lanzarActivityAgregarActividades(){
        Intent agregarActividadesActivity = new Intent(this,AgregarActividadesActivity.class);
        startActivity(agregarActividadesActivity);
    }
}
