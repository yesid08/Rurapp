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
        actualizarRecyclerViewActividades();
    }

    protected void onStart(){
        super.onStart();
        actualizarRecyclerViewActividades();

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

    /**
     * Método que permite cargar todas las actividades registradas en la base de datos
     * para leerlas en el recyclerView.
     */
    private void cargarTodasLasActividades () {
        ActividadDAO actividadDAO = new ActividadDAO(this);
        this.actividades = actividadDAO.getTodasActividades();
    }

    /**
     * Método que se encarga de actualizar el recyclerView de las actividades.
     */
    private void actualizarRecyclerViewActividades(){
        this.recyclerViewActividades = findViewById(R.id.recyclerView2);
        this.layoutManager = new LinearLayoutManager(this);
        this.actividades = new ArrayList<Actividad>();
        cargarTodasLasActividades();
        this.recyclerViewActividades.setLayoutManager(this.layoutManager);
        this.adaptadorActividades = new AdaptadorActividades(this.actividades);
        this.recyclerViewActividades.setAdapter(this.adaptadorActividades);
        this.recyclerViewActividades.addOnItemTouchListener(eventoTocarItemRecyclerView());
    }

    /**
     * Método que se encarga de gestionar lo referente a las acciones que suceden al tocar un elemento
     * del recyclerView.
     * @return : Un eventoOnItemTouchListener
     */
    private RecyclerView.OnItemTouchListener eventoTocarItemRecyclerView(){
        return new RecyclerView.OnItemTouchListener() {

            /**
             * Instancia del gestor.
             */
            GestureDetector gestureDetector = new GestureDetector(ActividadesActivity.this,
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
                            return true;
                        }
                    }
            );

            /**
             * Método que permite ejecutar la acción que ocurre al tocar un elemento del recycler
             * view.
             * @param rv : El recyclerView al que se hace referencia.
             * @param e : evento de movimiento.
             * @return : Verdadero si ocurre, falso caso contrario.
             */
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if(childView != null && gestureDetector.onTouchEvent(e)) {
                    int idPosicion = rv.getChildAdapterPosition(childView);
                    Intent editarActividades = new Intent(ActividadesActivity.this,AgregarActividadesActivity.class);
                    editarActividades.putExtra("actividad",actividades.get(idPosicion));
                    startActivity(editarActividades);
                    return true;
                }
                return false;
            }

            /**
             * Este método no se implementa todavía.
             * @param rv : El recyclerView al que se hace referencia.
             * @param e : Evento de movimiento.
             */
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }

            /**
             * Método que no se implementa todavía.
             * @param disallowIntercept : booleano que indica si se desactiva el intercepto.
             */
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        };
    }
}
