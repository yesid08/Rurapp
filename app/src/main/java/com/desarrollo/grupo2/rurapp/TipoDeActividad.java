package com.desarrollo.grupo2.rurapp;

/**
 * @author : Yesid A Gutierrez
 * Clase TipoDeActividad para el proyecto Rurapp.
 */
public class TipoDeActividad {

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
}
