package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.util.Log;

import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Finca;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.TipoDeActividad;

import java.util.ArrayList;
import java.util.List;

public class TipoDeActividadDAO {
    public static final String TAG= "TipoDeActividadDAO";

    //campos de la base de datos

    private SQLiteDatabase mDatabase;
    private DbHelper mDbHelper;
    private Context mContext;
    private String[] mTodasColumnas={
            DbHelper.column_idTipoAtividad,
            DbHelper.column_nombTipoActividad,
            DbHelper.column_descriTipoActividad,

    };

    /**
     *@author: Franklin Sierra
     *metodo que permite abrir la base de datos
     */
    public TipoDeActividadDAO(Context context){
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
     * metodo para creacion de cada tipo de actividad
     * */
    public TipoDeActividad crearTipoDeActividad(TipoDeActividad tipoDeActividad){
        ContentValues values = new ContentValues();
        values.put(DbHelper.column_nombTipoActividad, tipoDeActividad.getNombre());
        values.put(DbHelper.column_descriTipoActividad, tipoDeActividad.getDescripcion());

        long insertId = mDatabase
                .insert(DbHelper.tabla_tipoAct, null, values);
        Cursor cursor = mDatabase.query(DbHelper.tabla_tipoAct, mTodasColumnas, DbHelper.column_idTipoAtividad +
                " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        TipoDeActividad nuevoTipoDeActividad = cursorToTipoDeActividad(cursor);
        cursor.close();
        return nuevoTipoDeActividad;
    }

    /**
     * @author: Franklin Sierra
     * metodo para eliminar tipos de actividades en la base de datos
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
     * listar todas los tipos de actividades
     * */
    public ArrayList<TipoDeActividad> getTodasActividades(){
        ArrayList<TipoDeActividad> TipoActividadList= new ArrayList<>();

        Cursor cursor = mDatabase.query(DbHelper.tabla_tipoAct, mTodasColumnas, null, null,
                null, null, null);
        if(cursor !=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                TipoDeActividad TipoActividad = cursorToTipoDeActividad(cursor);
                TipoActividadList.add(TipoActividad);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return TipoActividadList;
    }

    /**
     * @author: Franklin Sierra
     * consultar Tipo de actividad por id
     * */
    public TipoDeActividad getTipoDeActividadById(long id){
        Cursor cursor = mDatabase.query(DbHelper.tabla_tipoAct, mTodasColumnas, DbHelper.column_idTipoAtividad
                + " = ?", new String[]{ String.valueOf(id) }, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }
        TipoDeActividad TipoActividad = cursorToTipoDeActividad(cursor);
        return TipoActividad;
    }

    /**
     * Este método permite devolver un objeto de tipoDeActividad basado en el query ejecutado
     * @param cursor : el cursor de la base de datos
     * @return un objeto tipoDeActividad.
     */
    protected TipoDeActividad cursorToTipoDeActividad(Cursor cursor){
        String id= cursor.getString(0);
        String nombreTipoActividad= cursor.getString(1);
        String descripcionTipoActividad= cursor.getString(2);
        TipoDeActividad tipoActividad= new TipoDeActividad(id,nombreTipoActividad,descripcionTipoActividad);
        return tipoActividad;
    }
}
