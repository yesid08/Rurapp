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
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.AdaptadorEmpleados;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Empleado;

import java.util.ArrayList;
import java.util.Date;

public class EmpleadosActivity extends AppCompatActivity {

    private FloatingActionButton buttonAgregarEmpleado;
    private RecyclerView recyclerViewEmpleados;
    private RecyclerView.Adapter adaptadorDeEmpleados;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Empleado> empleados;

    /**
     * Método que se ejecuta al crear el activity
     * @param savedInstanceState : El estado del activity
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        this.buttonAgregarEmpleado = findViewById(R.id.floatingActionButton3);
        this.buttonAgregarEmpleado.setOnClickListener(onClickAgegarEmpleado());
        recyclerViewEmpleados = (RecyclerView) findViewById(R.id.recyclerView);
        empleados = new ArrayList<Empleado>();
        cargarTodosLosEmpleados();
        layoutManager = new LinearLayoutManager(this);
        recyclerViewEmpleados.setLayoutManager(layoutManager);
        adaptadorDeEmpleados = new AdaptadorEmpleados(empleados);
        recyclerViewEmpleados.setAdapter(adaptadorDeEmpleados);
        recyclerViewEmpleados.addOnItemTouchListener(eventoTouchEmpleados());
    }

    /**
     * Método que devuelve el evento al realizar click sobre el botón agregarEmpleados.
     * @return Un evento de tipo OnclickListener.
     */
    private View.OnClickListener onClickAgegarEmpleado(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivityAgregarEmpleados();
            }
        };
        return evento;
    }

    /**
     * Método que se encarga de lanzar el activity Agregar Empleados.
     */
    private void lanzarActivityAgregarEmpleados() {
        Intent activityAgregarEmpleados = new Intent(this,AgregarEmpleadosActivity.class);
        startActivity(activityAgregarEmpleados);
    }

    /**
     * Método que se encarga de devolver un escuchador de eventos cuando se toca
     * un elemento del recyclerView Empleados.
     * @return Evento OnItemTouchListener.
     */
    private RecyclerView.OnItemTouchListener eventoTouchEmpleados() {
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
                    Toast.makeText(EmpleadosActivity.this,
                            empleados.get(idPosicion).getPrimerNombre(), Toast.LENGTH_LONG).show();
                    Intent editarEmpleadoActivity = new Intent(EmpleadosActivity.this, AgregarEmpleadosActivity.class);
                    editarEmpleadoActivity.putExtra("empleado",empleados.get(idPosicion));
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
            GestureDetector gestureDetector = new GestureDetector(EmpleadosActivity.this,
                    new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }
            }
            );
        };
        return  evento;
    }

    /**
     * Método que sirve para cargar todos los empleados de la app dentro de un ArrayList
     */
    private void cargarTodosLosEmpleados() {
        empleados.add(new Empleado("0","Franklin","Samuel",
                "Sierra","",new Date(),"Coomeva",
                "","",25000,"")) ;
        empleados.add(new Empleado("0","Yesid","Alfonso",
                "Gutierrez","Guate",new Date(),"AsmetSalud",
                "3156858436","contratado",35000,"1098795086")) ;
    }
}
