package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.util.Log;

import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Actividad;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Empleado;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Finca;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Persona;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoDAO {
    public static final String TAG = "EmpleadoDAO";

    //campos de la base de datos

    private SQLiteDatabase mDatabase;
    private DbHelper mDbHelper;
    private Context mContext;
    private String[] mTodasColumnas = {
            DbHelper.column_idEmpleado,
            DbHelper.column_nombreEmpleado,
            DbHelper.column_estadoEmpleado,
            DbHelper.column_valorJornalEmpleado,
            DbHelper.column_cedulaEmpleado,
            DbHelper.column_saludEmpleado,
            DbHelper.column_celEmpleado,
    };

    /**
     * @author: Franklin Sierra
     * metodo que permite abrir la base de datos
     */
    public EmpleadoDAO(Context context) {
        this.mContext = context;
        mDbHelper = new DbHelper(context);
        //para abrir la base de datos
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, " error al abir la base de datos " + e.getMessage());
            e.printStackTrace();//no se para que se usa
        }
    }

    /**
     * @author: Franklin Sierra
     * En caso de no ocurrir ningun error se abre la base de datos
     */
    public void open() throws SQLException {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    /**
     * @author: Franklin Sierra
     * metodo para cerrar la base de datos
     */
    public void close() {
        mDbHelper.close();
    }

    /**
     * @author: Franklin Sierra
     * metodo para creacion de cada empleado
     */
    public Empleado crearEmpleado(String nombre, String estado, double valorJornal, String cedula
            ,String salud, String celular) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.column_nombreEmpleado, nombre);
        values.put(DbHelper.column_estadoEmpleado, estado);
        values.put(DbHelper.column_valorJornalEmpleado, valorJornal);
        values.put(DbHelper.column_cedulaEmpleado, cedula);
        values.put(DbHelper.column_saludEmpleado, salud);
        values.put(DbHelper.column_celEmpleado, celular);

        long insertId = mDatabase
                .insert(DbHelper.tabla_empleado, null, values);
        Cursor cursor = mDatabase.query(DbHelper.tabla_empleado, mTodasColumnas, DbHelper.column_idEmpleado +
                " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Empleado nuevoEmpleado = cursorToEmpleado(cursor);
        cursor.close();
        return nuevoEmpleado;
    }

    /**
     * @author: Franklin Sierra
     * metodo para eliminar empleado la base de datos
     * Se deja comentado el codigo ya que se usa on delete cascade en la tabla actividades
     */
    /*public void borrarEmpleado(Empleado empleado) {
        long id = empleado.getIdEmpleado();
        //borrar todas las actividades de la finca
        ActividadDAO actividadDAO = new ActividadDAO(mContext);
        List<Actividad> listActividades = ActividadDAO.getActividadDeEmpleado(id);
        if (listActividades != null && !listActividades.isEmpty()) {
            for (Actividad a : listActividades) {
                ActividadDAO.deleteActividad(e);
            }
        }
        System.out.println("se borro el empleado con el id: " + id);
        mDatabase.delete(DbHelper.tabla_empleado, DbHelper.column_idEmpleado + " = "
                + id, null);
    }*/

    /**
     * @author: Franklin Sierra
     * listar todas las fincas
     */
    public List<Empleado> getTodosEmpleados() {
        List<Empleado> empleadoList = new ArrayList<>();

        Cursor cursor = mDatabase.query(DbHelper.tabla_empleado, mTodasColumnas, null, null,
                null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Empleado empleado = cursorToEmpleado(cursor);
                empleadoList.add(empleado);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return empleadoList;
    }

    /**
     * @author: Franklin Sierra
     * consultar empleado por id
     */
    public Empleado getEmpleadoById(long id) {
        Cursor cursor = mDatabase.query(DbHelper.tabla_empleado, mTodasColumnas, DbHelper.column_idEmpleado
                + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        Empleado empleado = cursorToEmpleado(cursor);
        return empleado;
    }

    protected Empleado cursorToEmpleado(Cursor cursor) {
        String id= String.valueOf(cursor.getLong(0));
        String primerNombre=cursor.getString(1);
        String segundoNombre=cursor.getString(2);
        String primerApellido=cursor.getString(3);
        String segundoApellido=cursor.getString(4);
        SimpleDateFormat format= new SimpleDateFormat();
        Date fechaNacimiento;
        try {
             fechaNacimiento= format.parse((cursor.getString(5)));
        } catch (ParseException e) {
             fechaNacimiento=null;
        }
        String salud=cursor.getString(6);
        String celular=cursor.getString(7);
        String estado=cursor.getString(8);
        Double valorJornal=cursor.getDouble(9);
        String cedula =cursor.getString(10);
        Empleado empleado = new Empleado(id,primerNombre, segundoNombre,primerApellido, segundoApellido, fechaNacimiento,
                salud,celular,estado,valorJornal,cedula);

        return empleado;
    }
}