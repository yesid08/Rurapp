package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.FincaDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Finca;

public class AgregarFincaActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText latitud;
    private EditText longitud;
    private EditText descripcion;
    private Finca finca;
    private Button agregarEditarFincaBoton;
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
        this.agregarEditarFincaBoton = findViewById(R.id.button1);
        this.agregarEditarFincaBoton.setOnClickListener(eventoClickAgregarEditarBoton());
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
        this.nombre.setFocusable(false);
        this.latitud.setFocusable(false);
        this.longitud.setFocusable(false);
        this.descripcion.setFocusable(false);
        this.agregarEditarFincaBoton.setEnabled(false);
    }

    private View.OnClickListener eventoClickAgregarEditarBoton(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Finca finca = agregarNuevaFinca();
                Toast.makeText(AgregarFincaActivity.this, "Se ha registrado " +
                        "satisfactoriamente la finca "+finca.getNombre(),Toast.LENGTH_SHORT)
                .show();
                AgregarFincaActivity.this.finish();
            }
        };
        return evento;
    }

    private Finca agregarNuevaFinca () {
        Finca finca = new Finca(
                "1",
                this.nombre.getText().toString(),
                Double.valueOf(this.latitud.getText().toString()),
                Double.valueOf(this.longitud.getText().toString()),
                this.descripcion.getText().toString(),
                null
        );
        FincaDAO fincaDAO = new FincaDAO(this);
        return fincaDAO.crearFinca(finca);
    }

}
