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
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.FincaDAO;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.AdaptadorFincas;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Finca;

import java.util.ArrayList;

public class FincasActivity extends AppCompatActivity {

    private FloatingActionButton buttonAgregarFinca;
    private RecyclerView recyclerViewFincas;
    private RecyclerView.Adapter adaptadorFincas;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Finca> fincas;

    protected void onStart(){
        super.onStart();
        actualizarRecyclerViewFincas();
    }


    /**
     * Método que se ejecuta al crear el activity
     * @param savedInstanceState : Estado de la app.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fincas);
        buttonAgregarFinca = findViewById(R.id.floatingActionButton);
        buttonAgregarFinca.setOnClickListener(onClickAgregarFinca());
        fincas = new ArrayList<Finca>();
        cargarTodasLasFincas();
        adaptadorFincas = new AdaptadorFincas(fincas);
        recyclerViewFincas = findViewById(R.id.recyclerView1);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewFincas.setLayoutManager(layoutManager);
        recyclerViewFincas.setAdapter(adaptadorFincas);
        recyclerViewFincas.addOnItemTouchListener(eventoTocarItemFinca());
    }

    /**
     * Método que devuelve un objeto tipo Listener, este método ocurre cuando le dan click al botón
     * agregar finca.
     * @return : Evento tipo Listener.
     */
    private View.OnClickListener onClickAgregarFinca(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivityAgregarFica();
            }
        };
        return evento;
    }

    /**
     * Método que se utiliza para lanzar una intención con el porposito de abrir el activity Agregar
     * Finca.
     */
    private void lanzarActivityAgregarFica() {
        Intent activityAgregarFinca = new Intent(this,AgregarFincaActivity.class);
        startActivity(activityAgregarFinca);
    }

    /**
     * Método que se utiliza para cargar todas las fincas de la app al recyclerView.
     */
    private void cargarTodasLasFincas(){
        FincaDAO fincaDAO = new FincaDAO(this);
        this.fincas =  fincaDAO.getTodasFincas();
    }

    private void actualizarRecyclerViewFincas(){
        fincas = new ArrayList<Finca>();
        cargarTodasLasFincas();
        layoutManager = new LinearLayoutManager(this);
        recyclerViewFincas.setLayoutManager(layoutManager);
        adaptadorFincas = new AdaptadorFincas(fincas);
        recyclerViewFincas.setAdapter(adaptadorFincas);
        recyclerViewFincas.addOnItemTouchListener(eventoTocarItemFinca());
    }

    /**
     * Método que se encarga de controlar el evento que ocurre cuando se toca una finca.
     * @return Evento de tipo OnItemTouch
     */
    private RecyclerView.OnItemTouchListener eventoTocarItemFinca() {
        RecyclerView.OnItemTouchListener evento = new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(FincasActivity.this,
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
                            return true;
                        }
                    }
            );

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if(childView != null && gestureDetector.onTouchEvent(e)) {
                    int idPosicion = rv.getChildAdapterPosition(childView);
                    Toast.makeText(FincasActivity.this, fincas.get(idPosicion).getNombre(),
                            Toast.LENGTH_SHORT).show();
                    Intent editarFinca = new Intent(FincasActivity.this,AgregarFincaActivity.class);
                    editarFinca.putExtra("finca",fincas.get(idPosicion));
                    startActivity(editarFinca);
                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

        };
        return  evento;
    }
}
