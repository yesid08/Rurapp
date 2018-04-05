package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.desarrollo.grupo2.rurapp.R;

public class TipoDeActividadesActivity extends AppCompatActivity {

    private FloatingActionButton buttonAgregarTipoDeActividad;

    /**
     * Método que se ejecuta cuando se crea el activity TipoDeActividades.
     * @param savedInstanceState : El estado guardado del activity.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipoact);
        this.buttonAgregarTipoDeActividad = findViewById(R.id.floatingActionButton5);
        this.buttonAgregarTipoDeActividad.setOnClickListener(onClickAgregarTipoDeactividad());
    }

    /**
     * Método que devuelve un evento de tipo onClick
     * El método que se ejecuta al darle click al boton Agregar tipo de actividad.
     * @return :Evento de tipo Onclick.
     */
    private View.OnClickListener onClickAgregarTipoDeactividad(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivityAgregarTipoDeActividad();
            }
        };
        return evento;
    }

    /**
     * Método que se encarga de lanzar un nuevo activity Agregar tipo de actividad.
     */
    private void lanzarActivityAgregarTipoDeActividad(){
        Intent activityAgregarTipoDeActividad  = new Intent(this,AgregarTipoDeActividadesActivity.class);
        startActivity(activityAgregarTipoDeActividad);
    }


}
