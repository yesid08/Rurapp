package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.EmpleadoDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.FincaDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.TipoDeActividadDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Empleado;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Finca;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.TipoDeActividad;

import java.util.ArrayList;

public class AgregarActividadesActivity extends AppCompatActivity {

    private Spinner listaDesplegableEmpleados;
    private Spinner listaDesplegableTipoDeActividad;
    private Spinner listaDesplegableFincas;
    private ArrayList<Empleado> empleados;
    private ArrayList<TipoDeActividad> tipoDeActividades;
    private ArrayList<Finca> fincas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editactividad);
        this.listaDesplegableTipoDeActividad = findViewById(R.id.spinner1);
        this.listaDesplegableEmpleados = findViewById(R.id.spinner2);
        this.listaDesplegableFincas = findViewById(R.id.spinner3);
        EmpleadoDAO empleadoDAO = new EmpleadoDAO(this);
        TipoDeActividadDAO tipoDeActividadDAO = new TipoDeActividadDAO(this);
        FincaDAO fincasDAO = new FincaDAO(this);
        this.empleados = empleadoDAO.getTodosEmpleados();
        this.tipoDeActividades = tipoDeActividadDAO.getTodasActividades();
        this.fincas = fincasDAO.getTodasFincas();
        cargarEmpleadosSpinner();
        cargarTiposDeActividadesSpinner();
        cargarFincasSpinner();
    }

    private void cargarEmpleadosSpinner(){
        if (this.empleados != null){
            this.listaDesplegableEmpleados.setAdapter(new ArrayAdapter<Empleado>(this,
                    android.R.layout.simple_spinner_item,empleados));
        }
    }

    private void cargarTiposDeActividadesSpinner(){
        if(this.tipoDeActividades != null){
            this.listaDesplegableTipoDeActividad.setAdapter(new ArrayAdapter<TipoDeActividad>(this,
                    android.R.layout.simple_spinner_item,tipoDeActividades));
        }
    }

    private void cargarFincasSpinner(){
        if(this.fincas != null){
            this.listaDesplegableFincas.setAdapter(new ArrayAdapter<Finca>(this,
                    android.R.layout.simple_spinner_item,fincas));
        }
    }
}
