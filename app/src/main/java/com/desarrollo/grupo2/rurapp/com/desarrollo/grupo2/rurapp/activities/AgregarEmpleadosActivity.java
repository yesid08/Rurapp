package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Empleado;

public class AgregarEmpleadosActivity extends AppCompatActivity {

    private Empleado empleado;
    private EditText primerNombre;
    private EditText segundoNombre;
    private EditText primerApellido;
    private EditText segundoApellido;
    private EditText cedula;
    private EditText salud;
    private EditText fechaNacimiento;
    private EditText celular;
    private EditText valorJornal;
    private boolean editarEmpleado;

    /**
     * Método que inicializa los elementos del activity.
     * @param savedInstanceState : Elemento que guarda el estado del activity.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpersonal);
        this.primerNombre = findViewById(R.id.editText1);
        this.segundoNombre = findViewById(R.id.editText2);
        this.primerApellido = findViewById(R.id.editText3);
        this.segundoApellido = findViewById(R.id.editText4);
        this.cedula = findViewById(R.id.editText5);
        this.salud = findViewById(R.id.editText6);
        this.celular = findViewById(R.id.editText7);
        this.valorJornal = findViewById(R.id.editText8);
        this.fechaNacimiento = findViewById(R.id.editText9);
        this.empleado = getIntent().getParcelableExtra("empleado");
        // Si el empleado es nulo es porque la activity se abrió para agregar un nuevo empleado
        // Si el empleado no es nulo es porque se quiere editar el empleado.
        if (empleado != null){
            this.editarEmpleado = true;
            utilizarInformacionEmpleado();
        }
        else{
            this.editarEmpleado = false;
        }
    }

    /**
     * Este método permite llenar el formulario del empleado
     * que se desea editar.
     */
    private void utilizarInformacionEmpleado(){
        this.primerNombre.setText(empleado.getPrimerNombre());
        this.segundoNombre.setText(empleado.getSegundoNombre());
        this.primerApellido.setText(empleado.getPrimerApelllido());
        this.segundoApellido.setText(empleado.getSegundoApellido());
        this.cedula.setText(empleado.getCedula());
        this.salud.setText(empleado.getSalud());
        this.celular.setText(empleado.getCelular());
        this.valorJornal.setText(String.valueOf(empleado.getValorJornal()));
        this.fechaNacimiento.setText(empleado.getNacimientoString());
    }
}
