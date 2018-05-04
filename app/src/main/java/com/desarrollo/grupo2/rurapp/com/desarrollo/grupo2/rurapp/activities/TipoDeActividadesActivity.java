package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.TipoDeActividadDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.AdaptadorTiposDeActividades;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.TipoDeActividad;

import java.util.ArrayList;

public class TipoDeActividadesActivity extends AppCompatActivity {

    private FloatingActionButton buttonAgregarTipoDeActividad;
    private RecyclerView recyclerViewTipoDeActividades;
    private RecyclerView.Adapter adaptadorDeTipoDeActividades;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<TipoDeActividad> tiposDeActividades;

    protected void onStart(){
        super.onStart();
        actualizarRecyclerViewDeTiposDeActividades();
    }

    /**
     * Método que se ejecuta cuando se crea el activity TipoDeActividades.
     * @param savedInstanceState : El estado guardado del activity.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipoact);
        this.buttonAgregarTipoDeActividad = findViewById(R.id.floatingActionButton5);
        this.buttonAgregarTipoDeActividad.setOnClickListener(onClickAgregarTipoDeactividad());
        this.recyclerViewTipoDeActividades = findViewById(R.id.recyclerViewT);
        tiposDeActividades = new ArrayList<TipoDeActividad>();
        cargarTodosLosTiposDeActividades();
        this.layoutManager = new LinearLayoutManager(this);
        recyclerViewTipoDeActividades.setLayoutManager(layoutManager);
        this.adaptadorDeTipoDeActividades = new AdaptadorTiposDeActividades(tiposDeActividades);
        this.recyclerViewTipoDeActividades.setAdapter(adaptadorDeTipoDeActividades);
        this.recyclerViewTipoDeActividades.addOnItemTouchListener(eventoTouchTiposDeActividades());
    }

    /**
     * Método que devuelve un evento de tipo onClick
     * El método que se ejecuta al darle click al boton Agregar tipo de actividad.
     * @return :Evento de tipo Onclick.
     */
    private View.OnClickListener onClickAgregarTipoDeactividad(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivityAgregarTipoDeActividad();
            }
        };
        return evento;
    }

    /**
     * Método que se encarga de lanzar un nuevo activity Agregar tipo de actividad.
     */
    private void lanzarActivityAgregarTipoDeActividad(){
        Intent activityAgregarTipoDeActividad  = new Intent(this,AgregarTipoDeActividadesActivity.class);
        startActivity(activityAgregarTipoDeActividad);
    }

    /**
     * En este método se cargan todos los Tipos de Actividades de la Aplicación
     */
    private void cargarTodosLosTiposDeActividades(){
        TipoDeActividadDAO tipoDeActividadDAO = new TipoDeActividadDAO(this);
        tiposDeActividades = tipoDeActividadDAO.getTodasActividades();
    }

    private void actualizarRecyclerViewDeTiposDeActividades(){
        this.tiposDeActividades = new ArrayList<TipoDeActividad>();
        this.layoutManager = new LinearLayoutManager(this);
        this.recyclerViewTipoDeActividades.setLayoutManager(layoutManager);
        this.cargarTodosLosTiposDeActividades();
        this.adaptadorDeTipoDeActividades = new AdaptadorTiposDeActividades(tiposDeActividades);
        this.recyclerViewTipoDeActividades.setAdapter(adaptadorDeTipoDeActividades);
        this.recyclerViewTipoDeActividades.addOnItemTouchListener(eventoTouchTiposDeActividades());
    }

    private RecyclerView.OnItemTouchListener eventoTouchTiposDeActividades() {
        RecyclerView.OnItemTouchListener evento = new RecyclerView.OnItemTouchListener() {

            /**
             * Método que se ejecuta al tocar un item del recyclerView Empleados
             * @param rv : el RecyclerView de la acción
             * @param e : Animación del recyclerView
             * @return Evento InterceptTouch.
             */
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if(childView != null && gestureDetector.onTouchEvent(e)) {
                    int idPosicion = rv.getChildAdapterPosition(childView);
                    Toast.makeText(TipoDeActividadesActivity.this,
                            tiposDeActividades.get(idPosicion).getNombre(), Toast.LENGTH_LONG).show();
                    Intent editarEmpleadoActivity = new Intent(TipoDeActividadesActivity.this,
                            AgregarTipoDeActividadesActivity.class);
                    editarEmpleadoActivity.putExtra("tipoDeActividad",
                            tiposDeActividades.get(idPosicion));
                    startActivity(editarEmpleadoActivity);
                    return true;
                }
                return false;
            }

            /**
             * De momento este método no se está utilizando
             * @param rv: recyclerView
             * @param e : Animación.
             */
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }

            /**
             * Método que no está en uso por ahora.
             * @param disallowIntercept : parámetro de tipo boolean
             */
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
            GestureDetector gestureDetector = new GestureDetector(TipoDeActividadesActivity.this,
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
                            return true;
                        }
                    }
            );
        };
        return  evento;
    }


}
