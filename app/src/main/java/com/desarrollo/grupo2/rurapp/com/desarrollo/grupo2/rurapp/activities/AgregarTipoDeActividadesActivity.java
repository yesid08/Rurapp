package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.TipoDeActividadDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.AdaptadorActividades;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.TipoDeActividad;

public class AgregarTipoDeActividadesActivity extends AppCompatActivity {

    private EditText nombreActividad;
    private EditText descripcionActividad;
    private Button botonAceptar;
    private TipoDeActividad tipoDeActividad;
    private Button botonCancelar;

    /**
     * Método que se ejecuta al crear el activity
     * @param savedInstanceState : el estado guardado de la actividad.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editiptact);
        this.tipoDeActividad = getIntent().getParcelableExtra("tipoDeActividad");
        this.nombreActividad = findViewById(R.id.editText2);
        this.descripcionActividad = findViewById(R.id.editText1);
        this.botonAceptar = findViewById(R.id.button1);
        this.botonCancelar = findViewById(R.id.button2);
        if (this.tipoDeActividad != null){
            utilizarInformacionTipoDeActividad();
        }
        this.botonAceptar.setOnClickListener(eventoClickBotonAceptar());
        this.botonCancelar.setOnClickListener(eventoClickBotonCancelar());
    }

    /**
     * Método que permite ejecutar una acción luego de pulsar el botón aceptar.
     * @return eventoOnClick
     */
    private View.OnClickListener eventoClickBotonAceptar(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipoDeActividad tipoDeActividad = agregarNuevoTipoDeActividad();
                Toast.makeText(AgregarTipoDeActividadesActivity.this,
                        "Se ha registrado satisfactoriamente " +
                        "la actividad: "+tipoDeActividad.getNombre(),
                        Toast.LENGTH_SHORT).show();
                AgregarTipoDeActividadesActivity.this.finish();
            }
        };
        return evento;
    }

    /**
     * Método que define la acción que ocurre cuando se pulsa el botón cancelar.
     * @return : OnClickListener del botón cancelar.
     */
    private View.OnClickListener eventoClickBotonCancelar(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarTipoDeActividadesActivity.this.finish();
            }
        };
    }

    /**
     * Método que se encarga de agregar un nuevo tipo de actividad en la base de datos de la app.
      * @return : tipo de actividad agregada.
     */
    private TipoDeActividad agregarNuevoTipoDeActividad() {
        TipoDeActividad tipoDeActividad = new TipoDeActividad (
                "1",
                this.nombreActividad.getText().toString(),
                this.descripcionActividad.getText().toString()
                );
        TipoDeActividadDAO tipoDeActividadDAO = new TipoDeActividadDAO(this);
        TipoDeActividad tipoDeActividadRetorno =  tipoDeActividadDAO.crearTipoDeActividad(
                tipoDeActividad);
        return tipoDeActividadRetorno;
    }

    /**
     * Método que carga los datos del tipo de actividad pulsado en este activity.
     */
    private void utilizarInformacionTipoDeActividad(){
        this.nombreActividad.setText(this.tipoDeActividad.getNombre());
        this.descripcionActividad.setText(this.tipoDeActividad.getDescripcion());
        this.nombreActividad.setFocusable(false);
        this.descripcionActividad.setFocusable(false);
        this.botonAceptar.setEnabled(false);
    }
}
