package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.Formatter;
import android.util.Log;

import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Actividad;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Empleado;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Finca;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.TipoDeActividad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActividadDAO {
    public static final String TAG= "ActividadDAO";
    //campos de la base de datos


    private Context mContext;

    // Campos de la base de datos
    private SQLiteDatabase mDatabase;
    private DbHelper mDbHelper;
    private String[] mAllColumns = { DbHelper.column_idActividad,
            DbHelper.column_fechaAsignacionActividad,
            DbHelper.column_revisionActividad,
            DbHelper.column_jornalesActividad,
            DbHelper.column_estadoActividad,
            DbHelper.column_actividadIdFinca,
            DbHelper.column_actividadIdTipoActividad,
            DbHelper.column_actividadIdEmpleado};

    /**
     * @author: Franklin Sierra
     * Metodo para abrir la base de datos
     * */
    public ActividadDAO(Context context) {
        mDbHelper = new DbHelper(context);
        this.mContext = context;
        // abrir la base de datos
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @author: Franklin Sierra
     * En caso de no ocurrir ningun error se abre la base de datos
     * */
    public void open() throws SQLException {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    /**
     * @author: Franklin Sierra
     * metodo para cerrar la base de datos
     * */
    public void close() {
        mDbHelper.close();
    }

    /**
    * @author: Franklin Sierra
     * metodo para crear actividades
    * */
    //para el estado (char)
    public Actividad crearActividad(Actividad actividad) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.column_fechaAsignacionActividad, actividad.getFechaDeAsignacionString());
        values.put(DbHelper.column_revisionActividad, actividad.getFechaDeRevisionString());
        values.put(DbHelper.column_jornalesActividad, actividad.getCantidadDeJornales());
        values.put(DbHelper.column_estadoActividad, actividad.getEstado());
        values.put(DbHelper.column_idFinca, actividad.getFinca().getId());///????????????
        values.put(DbHelper.column_idTipoAtividad, actividad.getTipoDeActividad().getId());
        values.put(DbHelper.column_idEmpleado, actividad.getEmpleado().getIdEmpleado());
        long insertId = mDatabase
                .insert(DbHelper.tabla_actividad, null, values);
        Cursor cursor = mDatabase.query(DbHelper.tabla_actividad, mAllColumns,
                DbHelper.column_idActividad + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        Actividad newActividad = cursorToActividad(cursor);
        cursor.close();
        return newActividad;
    }

   /* public void deleteActividad(Actividad actividad) {
        long id = actividad.getId();
        System.out.println("the deleted employee has the id: " + id);
        mDatabase.delete(DBHelper.TABLE_EMPLOYEES, DBHelper.COLUMN_EMPLOYE_ID
                + " = " + id, null);
    }*/
    /**
     * @author: Franklin Sierra
     * metodo para listar actividades
     * */
    public ArrayList<Actividad> getTodasActividades() {
        ArrayList<Actividad> listActividad = new ArrayList<Actividad>();

        Cursor cursor = mDatabase.query(DbHelper.tabla_actividad, mAllColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Actividad actividad = cursorToActividad(cursor);
            listActividad.add(actividad);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return listActividad;
    }
    /**
     * @author: Franklin Sierra
     * metodo para listar actividades por finca
     * */
    public ArrayList<Actividad> getActividadesDeFinca(long FincaId) {
        ArrayList<Actividad> listActividad = new ArrayList<Actividad>();

        Cursor cursor = mDatabase.query(DbHelper.tabla_actividad, mAllColumns,
                DbHelper.column_idFinca + " = ?",
                new String[] { String.valueOf(FincaId) }, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Actividad actividad = cursorToActividad(cursor);
            listActividad.add(actividad);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return listActividad;
    }
    /**
     * @author: Franklin Sierra
     * metodo para listar actividades por empleado
     * */
    public ArrayList<Actividad> getActividadesDeEmpleado(long EmpleadoId) {
        ArrayList<Actividad> listActividad = new ArrayList<Actividad>();

        Cursor cursor = mDatabase.query(DbHelper.tabla_actividad, mAllColumns,
                DbHelper.column_idEmpleado + " = ?",
                new String[] { String.valueOf(EmpleadoId) }, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Actividad actividad = cursorToActividad(cursor);
            listActividad.add(actividad);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return listActividad;
    }

    /**
     * @author: Franklin Sierra
     * metodo para
     * */
    private Actividad cursorToActividad(Cursor cursor) {


        String id= String.valueOf(cursor.getLong(0));
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
        Date fechaAsignacion;
        Date fechaRevision;
        try {
            fechaAsignacion= formato.parse((cursor.getString(1)));
        } catch (ParseException e) {
            fechaAsignacion = new Date();
        }

        try {
            fechaRevision= formato.parse((cursor.getString(2)));
        } catch (ParseException e) {
            fechaRevision = new Date();
        }
        Double jornales= (cursor.getDouble(3));
        String estado= (cursor.getString(4));
        // get The finca by id
        long FincaId = cursor.getLong(5);
        FincaDAO dao = new FincaDAO(mContext);
        Finca finca = dao.getFincaById(FincaId);

        //get the empleado by id
        long EmpleadoId = cursor.getLong(7);
        EmpleadoDAO dao2 = new EmpleadoDAO(mContext);
        Empleado empleado = dao2.getEmpleadoById(EmpleadoId);

        //get the tipo de actividad by id
        long TipoActividadId = cursor.getLong(6);
        TipoDeActividadDAO dao3 = new TipoDeActividadDAO(mContext);
        TipoDeActividad tipoDeActividad = dao3.getTipoDeActividadById(TipoActividadId);

        Actividad actividad = new Actividad(id,fechaAsignacion,fechaRevision,jornales,estado,
                finca,tipoDeActividad, empleado);
        return actividad;
    }
}
