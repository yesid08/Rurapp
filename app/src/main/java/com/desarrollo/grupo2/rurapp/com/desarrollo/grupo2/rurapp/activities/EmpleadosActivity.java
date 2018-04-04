package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.desarrollo.grupo2.rurapp.R;

public class EmpleadosActivity extends AppCompatActivity {

    private FloatingActionButton buttonAgregarEmpleado;

    /**
     * Método que se ejecuta al crear el activity
     * @param savedInstanceState : El estado del activity
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        this.buttonAgregarEmpleado = findViewById(R.id.floatingActionButton3);
        this.buttonAgregarEmpleado.setOnClickListener(onClickAgegarEmpleado());
    }

    /**
     * Método que devuelve el evento al realizar click sobre el botón agregarEmpleados.
     * @return Un evento de tipo OnclickListener.
     */
    private View.OnClickListener onClickAgegarEmpleado(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivityAgregarEmpleados();
            }
        };
        return evento;
    }

    /**
     * Método que se encarga de lanzar el activity Agregar Empleados.
     */
    private void lanzarActivityAgregarEmpleados() {
        Intent activityAgregarEmpleados = new Intent(this,AgregarEmpleadosActivity.class);
        startActivity(activityAgregarEmpleados);
    }
}
