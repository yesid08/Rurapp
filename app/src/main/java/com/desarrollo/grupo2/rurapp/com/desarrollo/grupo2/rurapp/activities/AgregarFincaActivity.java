package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Finca;

public class AgregarFincaActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText latitud;
    private EditText longitud;
    private EditText descripcion;
    private Finca finca;
    private boolean editarFinca;

    /**
     * Método que inicializa todos los View de la activity AgregarFincas
     * @param savedInstanceState : estado de la activity.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editfinca);
        this.nombre = findViewById(R.id.editText2);
        this.latitud = findViewById(R.id.editText1);
        this.longitud = findViewById(R.id.editText3);
        this.descripcion = findViewById(R.id.editText4);
        this.finca = getIntent().getParcelableExtra("finca");
        if(finca != null){
            this.editarFinca = true;
            utilizarInfomacionFincas();
        }
        else {
            this.editarFinca = false;
        }
    }

    /**
     * Método que permite cargar el formulario con la información de la finca
     * que se desdea editar.
     */
    private void utilizarInfomacionFincas(){
        this.nombre.setText(finca.getNombre());
        this.latitud.setText(String.valueOf(finca.getLatitud()));
        this.longitud.setText(String.valueOf(finca.getLongitud()));
        this.descripcion.setText(finca.getDescripcion());
    }
}
