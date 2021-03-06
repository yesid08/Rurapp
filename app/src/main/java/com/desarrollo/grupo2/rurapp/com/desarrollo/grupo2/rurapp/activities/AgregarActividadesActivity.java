package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.ActividadDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.EmpleadoDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.FincaDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.TipoDeActividadDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Actividad;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Empleado;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Finca;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.TipoDeActividad;

import java.util.ArrayList;

public class AgregarActividadesActivity extends AppCompatActivity {

    private EditText fechaAsignacion;
    private EditText fechaRevision;
    private Spinner listaDesplegableEmpleados;
    private Spinner listaDesplegableTipoDeActividad;
    private Spinner listaDesplegableFincas;
    private EditText cantidadDeJornales;
    private Button agregarEditarActividad;
    private Button cancelarActividadBoton;
    private ArrayList<Empleado> empleados;
    private ArrayList<TipoDeActividad> tipoDeActividades;
    private ArrayList<Finca> fincas;

    /**
     * Método que construye el activity e inicializa los valores de cada View.
     * @param savedInstanceState : instancia guardadada.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editactividad);
        this.fechaAsignacion = findViewById(R.id.editText1);
        this.fechaRevision = findViewById(R.id.editText2);
        this.listaDesplegableTipoDeActividad = findViewById(R.id.spinner1);
        this.listaDesplegableEmpleados = findViewById(R.id.spinner2);
        this.listaDesplegableFincas = findViewById(R.id.spinner3);
        this.cantidadDeJornales = findViewById(R.id.editText7);
        this.cantidadDeJornales.setText("0");
        this.agregarEditarActividad = findViewById(R.id.button1);
        this.agregarEditarActividad.setOnClickListener(eventoAgregarEditarActividad());
        this.cancelarActividadBoton  = findViewById(R.id.button6);
        this.cancelarActividadBoton.setOnClickListener(eventoCancelarActividad());
        EmpleadoDAO empleadoDAO = new EmpleadoDAO(this);
        TipoDeActividadDAO tipoDeActividadDAO = new TipoDeActividadDAO(this);
        FincaDAO fincasDAO = new FincaDAO(this);
        this.empleados = empleadoDAO.getTodosEmpleados();
        this.tipoDeActividades = tipoDeActividadDAO.getTodasActividades();
        this.fincas = fincasDAO.getTodasFincas();
        cargarEmpleadosSpinner();
        cargarTiposDeActividadesSpinner();
        cargarFincasSpinner();
        Actividad actividad = getIntent().getParcelableExtra("actividad");
        if(actividad != null){
            utilizarInformacionActividades(actividad);
        }
    }

    /**
     * Método utilizado para cargar todos los empleados en el spinner.
     */
    private void cargarEmpleadosSpinner(){
        if (this.empleados != null){
            this.listaDesplegableEmpleados.setAdapter(new ArrayAdapter<Empleado>(this,
                    android.R.layout.simple_spinner_item,empleados));
        }
    }

    /**
     * Método utilizado para cargar todos los tipos de actividades en el spinner.
     */
    private void cargarTiposDeActividadesSpinner(){
        if(this.tipoDeActividades != null){
            this.listaDesplegableTipoDeActividad.setAdapter(new ArrayAdapter<TipoDeActividad>(this,
                    android.R.layout.simple_spinner_item,tipoDeActividades));
        }
    }

    /**
     * Método utilizado para cargar todas las fincas en el spinner
     */
    private void cargarFincasSpinner(){
        if(this.fincas != null){
            this.listaDesplegableFincas.setAdapter(new ArrayAdapter<Finca>(this,
                    android.R.layout.simple_spinner_item,fincas));
        }
    }

    /**
     * Método que devuelve una actividad la cual se crea a partir de los datos contenidos en el layout.
     * @return una Actividad.
     */
    private Actividad crearNuevaActividad(){
        return new Actividad(
                "",
                this.fechaAsignacion.getText().toString(),
                this.fechaRevision.getText().toString(),
                Double.valueOf(this.cantidadDeJornales.getText().toString()),
                "Asignada-No pagada",
                (Finca) this.listaDesplegableFincas.getSelectedItem(),
                (TipoDeActividad) this.listaDesplegableTipoDeActividad.getSelectedItem(),
                (Empleado) this.listaDesplegableEmpleados.getSelectedItem()
                );
    }

    /**
     * Evento de tipo OnClick que se ejecuta al presionar el botón de aceptar o editar.
     * @return
     */
    private View.OnClickListener eventoAgregarEditarActividad(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActividadDAO actividadDAO = new ActividadDAO(AgregarActividadesActivity.this);
                Actividad actividad = actividadDAO.crearActividad(crearNuevaActividad());
                Toast.makeText(AgregarActividadesActivity.this,"Se ha registrado la " +
                        "actividad " +actividad.getTipoDeActividad().getNombre()+"satisfactoriamente"
                        ,Toast.LENGTH_SHORT).show();
                AgregarActividadesActivity.this.finish();
            }
        };
    }

    /**
     * Método que se encarga de definir el evento que ocurre cuando se presiona el botón de cancelar
     * en la activity AgregarActividades.
     * @return : evento OnclickListener.
     */
    private View.OnClickListener eventoCancelarActividad(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarActividadesActivity.this.finish();
            }
        };
    }

    /**
     * Método que se encarga de leer los datos de una actividad y en caso de encontrarla
     * se encargará de asignar todos los valores de dicha actividad a nuestro activity.
     * @param actividad : la actividad que se encontró.
     */
    private void utilizarInformacionActividades(Actividad actividad){
        this.fechaRevision.setText(actividad.getFechaDeRevisionString());
        this.fechaRevision.setFocusable(false);
        this.fechaAsignacion.setText(actividad.getFechaDeAsignacionString());
        this.fechaAsignacion.setFocusable(false);
        this.cantidadDeJornales.setText(String.valueOf(actividad.getCantidadDeJornales()));
        this.cantidadDeJornales.setFocusable(false);
        this.listaDesplegableEmpleados.setSelection(obtenerPosicionDelSpinner(
                listaDesplegableEmpleados,actividad.getEmpleado()));
        this.listaDesplegableTipoDeActividad.setSelection(obtenerPosicionDelSpinner(
                listaDesplegableTipoDeActividad,actividad.getTipoDeActividad()));
        this.listaDesplegableFincas.setSelection(obtenerPosicionDelSpinner(
                listaDesplegableFincas,actividad.getFinca()));
        this.agregarEditarActividad.setEnabled(false);
    }

    /**
     * Método que se encarga de buscar si el elemento requerido está y su posición
     * @param lista : El spinner donde se quiere buscar el elemento.
     * @param objeto : El elemento que se quiere buscar.
     * @return La posición donde se encuentra el elemento, elige 0 por defecto si no la encuentra.
     */
    private int obtenerPosicionDelSpinner(Spinner lista , Object objeto ){
        int posicion = 0;
        for (int i = 0 ; i < lista.getCount() ; i ++){
            if(lista.getItemAtPosition(i).toString().equalsIgnoreCase(objeto.toString())){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
}
