package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.ActividadDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Actividad;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.AdaptadorActividades;

import java.util.ArrayList;

public class ActividadesActivity extends AppCompatActivity {

    private FloatingActionButton buttonAgregarActividades;
    private RecyclerView recyclerViewActividades;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adaptadorActividades;
    private ArrayList<Actividad> actividades;
    /**
     * Método que se ejecuta cuando se crea el Activity Actividades
     * @param savedInstanceState : El estado del activity.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);
        this.buttonAgregarActividades = findViewById(R.id.floatingActionButton2);
        this.buttonAgregarActividades.setOnClickListener(onClickAgregarActividades());
        this.recyclerViewActividades = findViewById(R.id.recyclerView2);
        this.layoutManager = new LinearLayoutManager(this);
        this.actividades = new ArrayList<Actividad>();
        cargarTodasLasActividades();
        this.recyclerViewActividades.setLayoutManager(this.layoutManager);
        this.adaptadorActividades = new AdaptadorActividades(this.actividades);
        this.recyclerViewActividades.setAdapter(this.adaptadorActividades);
    }

    protected void onStart(){
        super.onStart();
        this.recyclerViewActividades = findViewById(R.id.recyclerView2);
        this.layoutManager = new LinearLayoutManager(this);
        this.actividades = new ArrayList<Actividad>();
        cargarTodasLasActividades();
        this.recyclerViewActividades.setLayoutManager(this.layoutManager);
        this.adaptadorActividades = new AdaptadorActividades(this.actividades);
        this.recyclerViewActividades.setAdapter(this.adaptadorActividades);
    }

    /**
     * Método que se encarga de Asignar un evento al hacer click al botón agregarActividades.
     * @return
     */
    private View.OnClickListener onClickAgregarActividades(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivityAgregarActividades();
            }
        };
        return evento;
    }

    /**
     * Método que se utiliza para lanzar el activity Agregar actividades
     */
    private void lanzarActivityAgregarActividades(){
        Intent agregarActividadesActivity = new Intent(this,AgregarActividadesActivity.class);
        startActivity(agregarActividadesActivity);
    }

    private void cargarTodasLasActividades () {
        ActividadDAO actividadDAO = new ActividadDAO(this);
        this.actividades = actividadDAO.getTodasActividades();
    }

    private void actualizarRecyclerViewActividades(){
        this.recyclerViewActividades = findViewById(R.id.recyclerView2);
        this.layoutManager = new LinearLayoutManager(this);
        this.actividades = new ArrayList<Actividad>();
        cargarTodasLasActividades();
        this.recyclerViewActividades.setLayoutManager(this.layoutManager);
        this.adaptadorActividades = new AdaptadorActividades(this.actividades);
        this.recyclerViewActividades.setAdapter(this.adaptadorActividades);
    }
}
