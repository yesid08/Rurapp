package com.desarrollo.grupo2.rurapp;

import android.graphics.Bitmap;
/**
 * @author : Yesid A Gutierrez
    *Clase Finca para la aplicación Rurapp
 */
public class Finca {

    private String nombre;
    private double latitud;
    private double longitud;
    private String descripcion;
    private Bitmap foto;

    /**
     *@author : Yesid A Gutierrez
     * @param nombre : el nombre de la finca a la que se quiere hacer referencia.
     * @param latitud: coordenada geográfica de la finca.
     * @param longitud: Coordenada geográfica de la finca.
     * @param descripcion: Descripción de la finca.
     * @param foto: Bitmap que contiene la foto de la finca.
    */
    public Finca(String nombre, double latitud, double longitud, String descripcion, Bitmap foto) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    /**
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
     * Método que devuelve el nombre de la finca.
     * @return El nombre de la finca a la que se hace referencia.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que actualiza el nombre de la finca a la que se hace referencia.
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
     */
    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }
}
