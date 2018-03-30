package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos.DbHelper;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

/**
 * @author : Yesid A Gutierrez
 * Clase MainActivity de la aplicación rurapp
 * Esta clase se encarga de controlar las acciones del activity_main
 */
public class MainActivity extends AppCompatActivity {

    private final int SERVICIO_INICIAR_SESION = 0;
    private Button botonIniciarSesion;
    private EditText inputUsuario;
    private EditText inputGmail;
    private GoogleSignInClient gClienteInicioSesion;

    /**
     * @author : Yesid A Gutierrez
     * Método que gestiona las acciones que se ejecutan al enviarse una intención al
     * sistema operativo.
     * @param codigoRequerido : El código del servicio que se va a ejecutar.
     * @param codigoResultado : El código que representa el estado que se obtiene al ejecutar la
     *                        intención
     * @param datos : datos adicionales que se le pasan a la intención
     */
    @Override
    public void onActivityResult(int codigoRequerido, int codigoResultado, Intent datos) {
        super.onActivityResult(codigoRequerido, codigoResultado, datos);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (codigoRequerido == SERVICIO_INICIAR_SESION) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> tarea = GoogleSignIn.getSignedInAccountFromIntent(datos);
            gestionarResultadoIniciarSesion(tarea);
        }
    }

    /**
     * @author : Yesid A Gutierrez
     * Ciclo de vida del activity que se ejecuta cuando se crea la actividad
     * aquí se inicializan los layouts del activity como los botones, los EditText, los clientes de
     * autenticación entre otros.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonIniciarSesion = findViewById(R.id.button);
        inputUsuario = findViewById(R.id.editText);
        inputGmail = findViewById(R.id.editText2);
        GoogleSignInOptions gOpcionesIniciarSesion = new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gClienteInicioSesion  = GoogleSignIn.getClient(this,gOpcionesIniciarSesion);
        findViewById(R.id.button).setOnClickListener(this.buttonOnClick());
        //DbHelper datos= new DbHelper(this);
        //SQLiteDatabase db= datos.getWritableDatabase();
    }

    /**
     * @author : Yesid A Gutierrez
     * Ciclo de vida del activity que se muestra justo cuando se va a mostrar los datos al usuario.
     * aquí estamos controlando el inicio de sesión del usuario si está autenticado pero la app
     * se ha ocultado
     */
    @Override
    protected void onStart(){
        super.onStart();
        GoogleSignInAccount cuentaGoogle = GoogleSignIn.getLastSignedInAccount(this);
        //cuentaGoogle == null cuando el usuario aún no se ha autenticado sattisfactoriamente
        if ( cuentaGoogle != null ) {
            inputUsuario.setText(cuentaGoogle.getDisplayName());
            inputGmail.setText(cuentaGoogle.getEmail());
        }
        else {
            inputUsuario.setText("");
            Toast.makeText(this, "Por favor autentícate.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Método que se encarga de ejecutar las acciones que ocurren cuando se presiona el boton1
     * Para este caso sólo se procede a realizar el servicio de autenticación con Google
     * @return : Un evento de tipo click.
     */
    private View.OnClickListener buttonOnClick(){
        View.OnClickListener eventoOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IniciarSesiónConGoogle();
            }
        };
        return eventoOnClick;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se encarga de lanzar una intención para el inicio de sesión del cliente de google
     * identificada por un id definido en SERVICIO_INICIAR_SESION
     */
    private void IniciarSesiónConGoogle(){
        Intent signInIntent = this.gClienteInicioSesion.getSignInIntent();
        startActivityForResult(signInIntent, SERVICIO_INICIAR_SESION);
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se usa para gestionar el Resultado del inicio de sesión
     * @param tareaCompleatada : la tarea que se va a ejecutar.
     */
    private void gestionarResultadoIniciarSesion (Task<GoogleSignInAccount> tareaCompleatada) {
        /**El método se ejecuta normalmente por try si el inicio de sesión  es exitoso, si el usuario
         * lo cancela o decide no continuar o errores de red, el flujo va por el catch
         */
        try {
            GoogleSignInAccount cuenta = tareaCompleatada.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            Toast.makeText(this,"Se ha logrado autenticar el usuario " +
                    cuenta.getDisplayName(), Toast.LENGTH_LONG).show();
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Toast.makeText(this,"Error: " +e.getStatusCode(),Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Descripción: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
