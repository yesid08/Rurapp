package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.EmpleadoDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.AdaptadorActividades;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.AdaptadorFincas;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Empleado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Button aceptarEditarBoton;
    private Button cancelarEmpleadoBoton;
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
        this.aceptarEditarBoton = findViewById(R.id.button1);
        this.aceptarEditarBoton.setOnClickListener(eventoBotonAgregarEditarEmpleado());
        this.cancelarEmpleadoBoton = findViewById(R.id.button2);
        this.cancelarEmpleadoBoton.setOnClickListener(eventoCancelarBoton());
        this.empleado = getIntent().getParcelableExtra("empleado");
        this.valorJornal.setText("0");
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
        this.primerNombre.setFocusable(false);
        this.segundoNombre.setFocusable(false);
        this.primerApellido.setFocusable(false);
        this.segundoApellido.setFocusable(false);
        this.cedula.setFocusable(false);
        this.salud.setFocusable(false);
        this.celular.setFocusable(false);
        this.valorJornal.setFocusable(false);
        this.fechaNacimiento.setFocusable(false);
        this.aceptarEditarBoton.setEnabled(false);
    }

    /**
     * Método que registra un empleado en la base de datos de la app.
     * @return El empleado que se agregó en la base de datos.
     */
    private Empleado agregarNuevoEmpleado(){
        empleado = new Empleado(
                "",
                this.primerNombre.getText().toString(),
                this.segundoNombre.getText().toString(),
                this.primerApellido.getText().toString(),
                this.segundoApellido.getText().toString(),
                this.fechaNacimiento.getText().toString(),
                this.salud.getText().toString(),
                this.celular.getText().toString(),
                "contratado",
                Double.valueOf(this.valorJornal.getText().toString()),
                this.cedula.getText().toString());

        EmpleadoDAO daoEmpleado = new EmpleadoDAO(this);
        Empleado empleadoRetorno = daoEmpleado.crearEmpleado(empleado);
        return empleadoRetorno;
    }

    /**
     * Método que se ejecuta al presionar el botón de agregar o editar empleado.
     * @return Evento onClick.
     */
    private View.OnClickListener eventoBotonAgregarEditarEmpleado(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empleado emp = agregarNuevoEmpleado();
                Toast.makeText(AgregarEmpleadosActivity.this,"Se registró el empleado "+emp.getPrimerNombre()+" "+
                emp.getPrimerApelllido(),Toast.LENGTH_LONG).show();
                AgregarEmpleadosActivity.this.finish();
            }
        };
        return  evento;
    }

    /**
     * Método que se ejecuta al presionar el botón de cancelar.
     * @return: Evento OnClickListener.
     */
    private View.OnClickListener eventoCancelarBoton(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarEmpleadosActivity.this.finish();
            }
        };
    }
}
