package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : Yesid A Gutierrez
 * Clase TipoDeActividad para el proyecto Rurapp.
 */
public class TipoDeActividad implements Parcelable {

    private String id;
    private String nombre;
    private String descripcion;

    /**
     * @author : Yesid A Gutierrez
     * Constructor de la Clase TipoDeActividad que toma todos los parámetros.
     * @param id : el código único del tipo de actividad.
     * @param nombre : el nombre del tipo de actividad.
     * @param descripcion : una descripción más profunda de la actividad que se realiza.
     */
    public TipoDeActividad(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve el valor del código único del tipo de actividad.
     * @return : El id del tipo de actividad.
     */
    public String getId() {
        return id;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve el nombre del tipo de actividad.
     * @return el nombre del tipo de actividad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que actualiza el nombre del tipo de actividad.
     * @param nombre : nuevo nombre que se le asignará al tipo de actividad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se encarga de obtener la descripción del tipo de actividad
     * @return : Una descripción del tipo de actividad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se encarga de actualizar la descripción del tipo de actividad.
     * @param descripcion : La nueva descripción del tipo de actividad.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @author: Yesid A Gutierrez.
     * Método que crea un tipo de actividad apartir de un objeto Parcel
     * @param entrada : la entrada de datos para implementar el parcel.
     */
    public TipoDeActividad(Parcel entrada){
        String[] datos = new String[3];
        entrada.readStringArray(datos);
        // the order needs to be the same as in writeToParcel() method
        this.id = datos[0];
        this.setNombre(datos[1]);
        this.setDescripcion(datos[2]);
    }

    /**
     * @author: Yesid A Gutierrez
     * Este método no sé que hace exactamente pero debe implementarse, investigar.
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * @author: Yesid A Gutierrez
     * Método que se utiliza para escribir en un vector String en el orden que se desee
     * @param destino : El nuevo parcel que va a recibir el vector.
     * @param flags : banderas para ejecutar el String (no suele utilizarse por defecto.)
     */
    @Override
    public void writeToParcel(Parcel destino, int flags) {
        destino.writeStringArray(new String[] {this.getId(),
                this.getNombre(),
                this.getDescripcion()});
    }

    /**
     * @author: Yesid A Gutierrez
     * Variable global estática CREATOR es necesaria para implementar la clase Parcelable.
     */
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public TipoDeActividad createFromParcel(Parcel entrada) {
            return new TipoDeActividad(entrada);
        }

        public TipoDeActividad[] newArray(int tamaño) {
            return new TipoDeActividad[tamaño];
        }
    };
}
