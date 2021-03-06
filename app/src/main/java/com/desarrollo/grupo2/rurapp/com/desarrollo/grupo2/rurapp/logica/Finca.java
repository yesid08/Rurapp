package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.ByteArrayOutputStream;

/**
 * @author : Yesid A Gutierrez
 *Clase Finca para la aplicación Rurapp
 */
public class Finca implements  Parcelable{

    private String id;
    private String nombre;
    private double latitud;
    private double longitud;
    private String descripcion;
    private Bitmap foto;

    /**
     *@author : Yesid A Gutierrez
     * Constructor de la clase Finca con todos los parámetros.
     * @param id : un id que se le asigna a la Finca.
     * @param nombre : el nombre de la finca a la que se quiere hacer referencia.
     * @param latitud: coordenada geográfica de la finca.
     * @param longitud: Coordenada geográfica de la finca.
     * @param descripcion: Descripción de la finca.
     * @param foto: Bitmap que contiene la foto de la finca.
    */
    public Finca(String id, String nombre, double latitud, double longitud, String descripcion, Bitmap foto) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    /**
     * @author : Yesid A Gutierrez
     * Constructor sin parámetros para la clase Finca
     */
    public Finca(){
        this.nombre = "";
        this.latitud = 0;
        this.longitud = 0;
        this.descripcion = "";
        this.foto =  null;
    }

    /**
     * @author : Yesid A Gutierrez
     * Actualiza el id de la finca
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método que se encarga de devolver el id de la finca a la que se hace referencia
     * @return código único de la finca.
     */
    public String getId() {
        return id;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve el nombre de la finca.
     * @return El nombre de la finca a la que se hace referencia.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que actualiza el nombre de la finca a la que se hace referencia.
     * @param nombre : el nuevo nombre de la finca.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve la latitud de la finca.
     * @return La latitud de la finca a la que se hace referencia.
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que actualiza la latitud de la finca a la que se hace referencia.
     * @param latitud : la nueva latitud de la finca.
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve la longitud de la finca a la que se hace referencia.
     * @return la longitud de la finca.
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que actualiza la longitud de la finca a la que se hace referencia.
     * @param longitud : La nueva longitud de la finca.
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve una descripción de la finca a la que se hace referencia.
     * @return La descricpción de la finca.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que actualiza la descripción de la finca a la que se hace referencia.
     * @param descripcion : la nueva descripción de la finca.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve la foto de la finca a la que se hace referencia.
     * @return La foto de la finca.
     */
    public Bitmap getFoto() {
        return foto;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que actualiza la foto de la finca a la que se hace referencia.
     * @param foto : la nueva foto de la finca.
     */
    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    /**
     * @author: Yesid A Gutierrez.
     * Método que crea un tipo de actividad apartir de un objeto Parcel
     * @param entrada : la entrada de datos para implementar el parcel.
     */
    public Finca(Parcel entrada){
        String[] datos = new String[3];
        entrada.readStringArray(datos);
        // the order needs to be the same as in writeToParcel() method
        this.id = datos[0];
        this.setNombre(datos[1]);
        this.setDescripcion(datos[2]);
        double[] ubicacion = new double[2];
        entrada.readDoubleArray(ubicacion);
        // the order needs to be the same as in writeToParcel() method
        this.setLatitud(ubicacion[0]);
        this.setLongitud(ubicacion[1]);
        this.foto = (Bitmap) entrada.readValue(Bitmap.class.getClassLoader());
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
        destino.writeDoubleArray(new double[]{this.getLatitud(),
        this.getLongitud()});
        destino.writeValue(this.getFoto());
    }

    /**
     * @author: Yesid A Gutierrez
     * Variable global estática CREATOR es necesaria para implementar la clase Parcelable.
     */
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Finca createFromParcel(Parcel entrada) {
            return new Finca(entrada);
        }

        public Finca[] newArray(int tamaño) {
            return new Finca[tamaño];
        }
    };
}
