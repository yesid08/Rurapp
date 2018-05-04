package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.Log;

import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Actividad;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Finca;

import java.util.ArrayList;
import java.util.List;

public class FincaDAO {
    public static final String TAG= "FincaDAO";

    //campos de la base de datos

    private SQLiteDatabase mDatabase;
    private DbHelper mDbHelper;
    private Context mContext;
    private String[] mTodasColumnas={
            DbHelper.column_idFinca,
            DbHelper.column_nombreFinca,
            DbHelper.column_latitudFinca,
            DbHelper.column_longitudFinca,
            DbHelper.column_descripcionFinca,
            DbHelper.column_fotoFinca
    };

    /**
     *@author: Franklin Sierra
     *metodo que permite abrir la base de datos
     */
    public FincaDAO(Context context){
        this.mContext=context;
        mDbHelper=new DbHelper(context);
        //para abrir la base de datos
        try{
            open();
        }
        catch (SQLException e){
            Log.e(TAG, " error al abir la base de datos " + e.getMessage());
            e.printStackTrace();//no se para que se usa
        }
    }

    /**@author: Franklin Sierra
     * En caso de no ocurrir ningun error se abre la base de datos
     * */
    public void open() throws SQLException{
        mDatabase=mDbHelper.getWritableDatabase();
    }

    /**
     * @author: Franklin Sierra
     * metodo para cerrar la base de datos
     * */
    public void close(){
        mDbHelper.close();
    }

    /**
     * @author: Franklin Sierra
     * metodo para creacion de cada finca
     * */
    public Finca crearFinca(String nombre, double latitud, double longitud, String descripcion
    , Bitmap foto){
        ContentValues values = new ContentValues();
        values.put(DbHelper.column_nombreFinca, nombre);
        values.put(DbHelper.column_latitudFinca, latitud);
        values.put(DbHelper.column_longitudFinca, longitud);
        values.put(DbHelper.column_descripcionFinca, descripcion);
        //falta buscar el metodo para obtener imagenes
        //values.put(DbHelper.column_fotoFinca, foto);
        long insertId = mDatabase
                .insert(DbHelper.tabla_finca, null, values);
        Cursor cursor = mDatabase.query(DbHelper.tabla_finca, mTodasColumnas, DbHelper.column_idFinca +
        " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Finca nuevaFinca = cursorToFinca(cursor);
        cursor.close();
        return nuevaFinca;
    }

    /**
     * @author: Franklin Sierra
     * metodo para eliminar finca la base de datos
     * Se implementa el on delete cascade en actividad
     * */
    /*
    public void borrarFinca(Finca finca){
        int id = Integer.parseInt(finca.getId());
        //borrar todas las actividades de la finca
        ActividadDAO actividadDAO = new ActividadDAO(mContext);
        List<Actividad> listActividades = ActividadDAO.getActividadDeFinca(id);
        if(listActividades !=null && !listActividades.isEmpty()){
            for (Actividad a : listActividades){
                ActividadDAO.deleteActividad(e);
            }
        }
     System.out.println("se borro la compañia con el id: " + id);
        mDatabase.delete(DbHelper.tabla_finca, DbHelper.column_idFinca + " = "
        + id, null);
    }*/

    /**
     * @author: Franklin Sierra
     * listar todas las fincas
     * */
    public List<Finca> getTodasFincas(){
        List<Finca> fincaList= new ArrayList<>();

        Cursor cursor = mDatabase.query(DbHelper.tabla_finca, mTodasColumnas, null, null,
                null, null, null);
        if(cursor !=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Finca finca = cursorToFinca(cursor);
                fincaList.add(finca);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return fincaList;
    }

    /**
     * @author: Franklin Sierra
     * consultar finca por id
     * */
    public Finca getFincaById(long id){
        Cursor cursor = mDatabase.query(DbHelper.tabla_finca, mTodasColumnas, DbHelper.column_idFinca
        + " = ?", new String[]{ String.valueOf(id) }, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }
        Finca finca = cursorToFinca(cursor);
        return finca;
    }

    /**
     * El orden de los items en  el cursor es definido por mTodasLasColumnas
     * @param cursor
     * @return
     */
    protected Finca cursorToFinca(Cursor cursor){
        //aca debe modificarse el id de finca
        //el problema es el setId deberia ir el siguiente comando:
        String id= String.valueOf(cursor.getLong(0));
        String nombre= cursor.getString(1);
        Double latitud= cursor.getDouble(2);
        Double longitud= cursor.getDouble(3);
        String descripcion= cursor.getString(4);

        Finca finca = new Finca(id,nombre,latitud,longitud,descripcion,null);
        return finca;
    }


}
