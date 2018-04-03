package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Administrador;


public class FirstActivity extends AppCompatActivity {

    private Administrador administrador;
    private TextView bienvenido;
    private TextView gmail;
    private Button buttonFincas;
    private Button buttonEmpleados;
    private Button buttonTiposDeActividades;
    private Button buttonActividades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        this.bienvenido = findViewById(R.id.textView1);
        this.gmail = findViewById(R.id.textView2);
        this.buttonFincas = findViewById(R.id.button1);
        this.buttonEmpleados = findViewById(R.id.button2);
        this.buttonTiposDeActividades = findViewById(R.id.button3);
        this.buttonActividades = findViewById(R.id.button4);
        this.buttonFincas.setOnClickListener(onClickFincas());
        this.buttonEmpleados.setOnClickListener(onClickEmpleados());
        this.buttonTiposDeActividades.setOnClickListener(onClickTipoActividades());
        this.buttonActividades.setOnClickListener(onClickActividades());
        this.administrador = getIntent().getParcelableExtra("administrador");
        actualizarUI();
        Toast.makeText(this,"Bienvenido "+administrador.getUsuario(),
                Toast.LENGTH_SHORT).show();
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que se encarga de actualizar el contenido visual de la UI.
     */
    private void actualizarUI(){
        this.bienvenido.setText(administrador.getUsuario());
        this.gmail.setText(administrador.getCorreo());
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que se encarga de devolver el evento que ocurre al presinar el botón empleados.
     */
    private View.OnClickListener onClickEmpleados(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarEmpleadosActivity();
            }
        };
        return evento;
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que se encarga de devolver el evento que ocurre al realizar click sobre el botón
     * de las fincas.
     */
    private View.OnClickListener onClickFincas(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarFincasActivity();
            }
        };
        return evento;
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que se encarga de devolver el evento que ocurre al realizar click sobre el botón
     * de las Actividades.
     */
    private View.OnClickListener onClickActividades(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActividadesActivity();
            }
        };
        return evento;
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que se encarga de devolver el evento que ocurre al realizar click sobre el botón
     * de los tipos de actividades.
     */
    private View.OnClickListener onClickTipoActividades(){
        View.OnClickListener evento = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarTiposDeActividadesActivity();
            }
        };
        return evento;
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que lanza el activity Empleados.
     */
    private void lanzarEmpleadosActivity(){
        Intent empleadosActivity = new Intent(this,EmpleadosActivity.class);
        startActivity(empleadosActivity);
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que lanza el activity Fincas.
     */
    private void lanzarFincasActivity(){
        Intent fincasActivity = new Intent(this,FincasActivity.class);
        startActivity(fincasActivity);
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que lanza el activity Actividades.
     */
    private void lanzarActividadesActivity(){
        Intent actividadesActivity = new Intent(this,ActividadesActivity.class);
        startActivity(actividadesActivity);
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que lanza el activity tiposDeActividades.
     */
    private void lanzarTiposDeActividadesActivity(){
        Intent tiposDeActividadesActivity = new Intent(this,TipoDeActividadesActivity.class);
        startActivity(tiposDeActividadesActivity);
    }

}
