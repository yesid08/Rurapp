package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Empleado;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Persona;

/**
 * Created by FRANKLINSIERRA on 29/03/2018.
 */
public class DbHelper extends SQLiteOpenHelper {

    /**
     * @author: Franklin Sierra, Yesid A Gutierrez
     * Características básicas de la base de datos.
     */
    private static final int VERSION_DB = 1;
    private static final String Nombre_DB = "RurappDB.db";

    /**
     * @author: Yesid A Gutierrez
     * Información de la tabla Administradores
     * estos son los atributos que incluirá la tabla para realizar una comprobación básica con
     * el servicio de autenticación de Gmail.
     */
    protected static final String tabla_administrador = "Administradores";
    protected static final String column_idAdministrador = "idAdministrador";
    protected static final String column_gmailAdministrador = "gmailAdministrador";
    protected static final String column_gmailDisplayName = "gmailDisplayNameAdministrador";

    /**
     * @author: Franklin Sierra
     * Informacion de la tabla Empleado
     * */
    protected static final String tabla_empleado="Empleados";
    protected static final String column_idEmpleado="idEmpleado";
    protected static final String column_primerNombreEmpleado="primerNombreEmpleado";
    protected static final String column_segundoNombreEmpleado="segundoNombreEmpleado";
    protected static final String column_primerApellidoEmpleado="primerApellidoEmpleado";
    protected static final String column_segundoApellidoEmpleado="segundoApellidoEmpleado";
    protected static final String column_estadoEmpleado="estadoEmpleado";
    protected static final String column_valorJornalEmpleado="jornalEmpleado";
    protected static final String column_cedulaEmpleado="cedulaEmpleado";
    protected static final String column_saludEmpleado="epsEmpleado";
    protected static final String column_celEmpleado="celularEmpleado";
    protected static final String column_fechaNacimientoEmpleado="fechaNacimientoEmpleado";


    /**
     * @author: Franklin Sierra
     * Informacion de la tabla Tabla Finca
     * */
    protected static final String tabla_finca="Fincas";
    protected static final String column_idFinca="idFinca";
    protected static final String column_nombreFinca="nombreFinca";
    protected static final String column_latitudFinca="latiutdFinca";
    protected static final String column_longitudFinca="longitudFinca";
    protected static final String column_descripcionFinca="descripcionFinca";
    protected static final String column_fotoFinca="fotoFinca";

    /**
     * @author: Franklin Sierra
     * Informacion de la tabla Tipo de actividad
     * */
    protected static final String tabla_tipoAct="TipoDeActividades";
    protected static final String column_idTipoAtividad="idTipoDeActividad";
    protected static final String column_nombTipoActividad="nombreTipoDeActividad";
    protected static final String column_descriTipoActividad="descripcionTipoDeActividad";

    /**
     * @author: Franklin Sierra
     * Informacion de la tabla Actividad
     * */
    protected static final String tabla_actividad="Actividades";
    protected static final String column_idActividad="idActividad";
    protected static final String column_fechaAsignacionActividad="asignacionActividad";
    protected static final String column_revisionActividad="revisionActividad";
    protected static final String column_jornalesActividad="numeroJornalesActividad";
    protected static final String column_estadoActividad="estadoActividad";
    protected static final String column_actividadIdEmpleado="idEmpleado";
    protected static final String column_actividadIdTipoActividad="idTipoActividad";
    protected static final String column_actividadIdFinca="idFinca";

    /**
     * @author: Yesid A Gutierrez
     * creación de la tabla administradores para realizar el segundo paso de autenticación.
     */
    private static final String CREATE_TABLE_ADMINISTRADORES = " create table " + tabla_administrador+
            " ("+column_idAdministrador+ " integer primary key autoincrement, "+
            column_gmailAdministrador+" text not null, "+
            column_gmailDisplayName+ " text not null " +
            " ) ;";

    /**
     * @author: Franklin Sierra
     * creacion de la tabla empleado
     * */
    private static final String CREATE_TABLE_EMPLEADO=" create table " +tabla_empleado+ " ("+
            column_idEmpleado + " integer primary key autoincrement,"
            + column_primerNombreEmpleado + " text not null,"
            + column_segundoNombreEmpleado + " text not null,"
            + column_primerApellidoEmpleado + " text not null,"
            + column_segundoApellidoEmpleado + " text not null,"
            + column_estadoEmpleado + " text not null,"
            + column_valorJornalEmpleado + " double not null,"
            + column_cedulaEmpleado + " text not null,"
            + column_saludEmpleado + " text not null,"
            + column_celEmpleado + " text not null,"
            + column_fechaNacimientoEmpleado + " text not null);";

    /**
     * @author: Franklin Sierra
     * creacion de la tabla finca
     * */
    private static final String CREATE_TABLE_FINCA=" create table " +tabla_finca+ " ("+
            column_idFinca + " integer primary key autoincrement,"
            + column_nombreFinca + " text not null,"
            + column_latitudFinca + " double not null,"
            + column_longitudFinca + " double not null,"
            +column_descripcionFinca + " text not null,"
            + column_fotoFinca + " blob );";


    /**
     * @author: Franklin Sierra
     * creacion de la tabla tipo de actividad
     * */
    private static final String CREATE_TABLE_TIPO_ACTIVIDAD=" create table " +tabla_tipoAct+ " ("+
            column_idTipoAtividad + " integer primary key autoincrement,"
            + column_nombTipoActividad + " text not null,"
            + column_descriTipoActividad + " text not null );";


    /**
     * @author: Franklin Sierra
     * creacion de la tabla actividad
     * */
    private static final String CREATE_TABLE_ACTIVIDAD=" create table " +tabla_actividad+ " ("+
            column_idActividad + " integer primary key autoincrement,"
            + column_fechaAsignacionActividad + " text not null,"
            + column_revisionActividad + " text not null,"
            + column_jornalesActividad + " float not null,"
            + column_estadoActividad + " text not null,"
            + column_actividadIdEmpleado + " integer not null,"
            + column_actividadIdTipoActividad + " integer not null,"
            + column_actividadIdFinca + " integer not null, " +
            " FOREIGN KEY (" + column_actividadIdEmpleado+") REFERENCES " + tabla_empleado + "( "
            + column_idEmpleado + " ) ON DELETE CASCADE ,"+
            " FOREIGN KEY (" + column_actividadIdTipoActividad+ ") REFERENCES " + tabla_tipoAct + "( "
            + column_idTipoAtividad + " ) ON DELETE CASCADE ,"+
            " FOREIGN KEY (" + column_actividadIdFinca + ") REFERENCES " + tabla_finca + "( "
            + column_idFinca + " ) ); /*ON DELETE CASCADE " ;

    /**
     * Método que se encarga de hacer una inserción de datos por defecto en la tabla administradores.
     * @param db : La base de datos que ejecutará la inserción.
     */
    private void insertarAdministradores(SQLiteDatabase db){
        db.execSQL("INSERT INTO Administradores (gmailAdministrador , gmailDisplayNameAdministrador )" +
                " VALUES ('yesidgutierrez.08@gmail.com' , '')");
    }

    /**
     * @author: Franklin Sierra
     * @param context: El contexto donde se ejecuta el constructor de la clase.
     * */
    public DbHelper(Context context) {
        super(context,Nombre_DB, null, VERSION_DB);
        SQLiteDatabase database = this.getReadableDatabase();
    }

    /**
     * @author: Yesid A Gutierrez , Franlin Sierra
     * Método onCreate de la clase SQLiteOpenHelper el cual se ejecuta al crearse una base de datos
     * nueva.
     * @param db : La base de datos que ejecutará las transacciones.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ADMINISTRADORES);
        insertarAdministradores(db);
        db.execSQL(CREATE_TABLE_EMPLEADO);
        db.execSQL(CREATE_TABLE_FINCA);
        db.execSQL(CREATE_TABLE_TIPO_ACTIVIDAD);
        db.execSQL(CREATE_TABLE_ACTIVIDAD);
    }

    /**
     *Método de la clase SQLiteOpenHelper que se ejecuta cuando la base de datos se actualiza
     * @param db : la base de datos que va a ejecutar las transacciones.
     * @param oldVersion : La versión anterior.
     * @param newVersion : La versión nueva.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+tabla_administrador);
        db.execSQL("DROP TABLE IF EXISTS "+tabla_empleado);
        db.execSQL("DROP TABLE IF EXISTS "+tabla_finca);
        db.execSQL("DROP TABLE IF EXISTS "+tabla_tipoAct);
        db.execSQL("DROP TABLE IF EXISTS "+tabla_actividad);
        onCreate(db);
    }

    /**
     * @author Franklin Sierra
     * Metodo para insertar Empleados.
     * */

}
