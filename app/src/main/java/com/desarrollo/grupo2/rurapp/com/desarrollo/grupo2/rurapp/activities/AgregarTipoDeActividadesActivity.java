package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.TipoDeActividadDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.TipoDeActividad;

public class AgregarTipoDeActividadesActivity extends AppCompatActivity {

    private EditText nombreActividad;
    private EditText descripcionActividad;
    private Button botonAceptar;
    private TipoDeActividad tipoDeActividad;

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
        if (this.tipoDeActividad != null){
            utilizarInformacionTipoDeActividad();
        }
        this.botonAceptar.setOnClickListener(eventoClickBotonAceptar());
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

    private void utilizarInformacionTipoDeActividad(){
        this.nombreActividad.setText(this.tipoDeActividad.getNombre());
        this.descripcionActividad.setText(this.tipoDeActividad.getDescripcion());
        this.nombreActividad.setFocusable(false);
        this.descripcionActividad.setFocusable(false);
        this.botonAceptar.setEnabled(false);
    }
}
