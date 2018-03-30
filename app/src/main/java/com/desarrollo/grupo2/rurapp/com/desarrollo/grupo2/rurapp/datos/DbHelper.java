package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by FRANKLINSIERRA on 29/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {


    /**
     * @author: Franklin Sierra
     * Informacion de la tabla Empleado
     * */

    private static final String tabla_empleado="Empleado";
    public static final String column_idEmpleado="idEmpleado";
    public static final String column_nombreEmpleado="nombreEmpleado";
    public static final String column_estadoEmpleado="estadoEmpleado";
    public static final String column_valorJornalEmpleado="jornalEmpleado";
    public static final String column_cedulaEmpleado="cedulaEmpleado";
    public static final String column_saludEmpleado="epsEmpleado";
    public static final String column_celEmpleado="celularEmpleado";



    /**
     * @author: Franklin Sierra
     * Informacion de la tabla Tabla
     * */
    private static final String tabla_finca="Finca";
    public static final String column_idFinca="idFinca";
    public static final String column_nombreFinca="nombreFinca";
    public static final String column_latitudFinca="latiutdFinca";
    public static final String column_longitudFinca="longitudFinca";
    public static final String column_descripcionFinca="descripcionFinca";
    public static final String column_fotoFinca="fotoFinca";


    /**
     * @author: Franklin Sierra
     * Informacion de la tabla Tipo de actividad
     * */
    private static final String tabla_tipoAct="TipoActividad";
    public static final String column_idTipoAtividad="idTipoActividad";
    public static final String column_nombTipoActividad="nombreTipoActividad";
    public static final String column_descriTipoActividad="descripcionTipoActividad";


    /**
     * @author: Franklin Sierra
     * Informacion de la tabla Actividad
     * */
    private static final String tabla_actividad="Actividad";
    public static final String column_idActividad="idActividad";
    public static final String column_fechaAsignacionActividad="asignacionActividad";
    public static final String column_revisionActividad="revisionActividad";
    public static final String column_jornalesActividad="numeroJornalesActividad";
    public static final String column_estadoActividad="estadoActividad";
    public static final String column_actividadIdEmpleado="idEmpleado";
    public static final String column_actividadIdTipoActividad="idTipoActividad";
    public static final String column_actividadIdFinca="idFinca";


    private static final int VERSION_DB=1;
    private static final String Nombre_DB="RurappDB.db";


    /**
     * creacion de la tabla empleado
     * */
    private static final String CREATE_TABLE_EMPLEADO=" create table " +tabla_empleado+ " ("+
            column_idEmpleado + " integer primary key autoincrement,"
            + column_nombreEmpleado + " text not null,"
            + column_estadoEmpleado + " char not null,"
            + column_valorJornalEmpleado + " double not null,"
            + column_cedulaEmpleado + " text not null,"
            + column_saludEmpleado + " text not null,"
            + column_celEmpleado + " text not null);";

    /**
     * creacion de la tabla finca
     * */
    private static final String CREATE_TABLE_FINCA=" create table " +tabla_finca+ " ("+
            column_idFinca + " integer primary key autoincrement,"
            + column_nombreFinca + " text not null,"
            + column_latitudFinca + " double not null,"
            + column_longitudFinca + " double not null,"
            +column_descripcionFinca + " text not null,"
            + column_fotoFinca + " text not null);";


    /**
     * creacion de la tabla tipo de actividad
     * */
    private static final String CREATE_TABLE_TIPO_ACTIVIDAD=" create table " +tabla_tipoAct+ " ("+
            column_idTipoAtividad + " integer primary key autoincrement,"
            + column_nombTipoActividad + " text not null,"
            + column_descriTipoActividad + " text not null);";


    /**
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
            + column_actividadIdFinca + " integer not null);";

    /**
     * @author Franklin Sierra
     * @param context:
     * */
    public DbHelper(Context context) {
        super(context,Nombre_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_EMPLEADO);
        db.execSQL(CREATE_TABLE_FINCA);
        db.execSQL(CREATE_TABLE_TIPO_ACTIVIDAD);
        db.execSQL(CREATE_TABLE_ACTIVIDAD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tabla_empleado);
        db.execSQL("DROP TABLE IF EXISTS "+tabla_finca);
        db.execSQL("DROP TABLE IF EXISTS "+tabla_tipoAct);
        db.execSQL("DROP TABLE IF EXISTS "+tabla_actividad);
        onCreate(db);
    }
}
