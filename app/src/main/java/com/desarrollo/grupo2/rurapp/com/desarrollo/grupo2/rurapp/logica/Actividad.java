package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import java.util.Date;

/**
 * @author : Yesid A Gutierrez
 * clase Actividad para el proyecto Rurapp
 */
public class Actividad {

    private String id;
    private Date fechaDeAsignacion;
    private Date fechaDeRevision;
    private float cantidadDeJornales;
    private char estado;
    private Finca finca;
    private TipoDeActividad tipoDeActividad;
    private Empleado empleado;

    /**
     * @author : Yesid A Gutierrez
     * Constructor de la clase Actividad con todos los parámetros excepto el id de la actividad
     * @param fechaDeAsignacion : Fecha en la cual se asignó la actividad.
     * @param fechaDeRevision : Fecha en la que se da revisión a la actividad.
     * @param cantidadDeJornales : Cantidad decimal de jornales que requiere la actividad.
     * @param estado : El estado actual de la actividad.
     * @param finca: La finca a la que pertenece la actividad.
     * @param tipoDeActividad : Tipo o clase de actividad que identifica esta actividad.
     * @param empleado : Empleado al que se le asignaron la actividad.
     */
    public Actividad(Date fechaDeAsignacion, Date fechaDeRevision, float cantidadDeJornales,
                     char estado, Finca finca, TipoDeActividad tipoDeActividad, Empleado empleado) {
        this.fechaDeAsignacion = fechaDeAsignacion;
        this.fechaDeRevision = fechaDeRevision;
        this.cantidadDeJornales = cantidadDeJornales;
        this.estado = estado;
        this.finca = finca;
        this.tipoDeActividad = tipoDeActividad;
        this.empleado = empleado;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelte el código único de la Actividad.
     * @return : id de la actividad.
     */
    public String getId() {
        return id;
    }

    /**
     * Método que se encarga de obtener la fecha de la asignación de la actividad
     * @return : la fecha de asignación.
     */
    public Date getFechaDeAsignacion() {
        return fechaDeAsignacion;
    }

    /**
     * @author : Yesid A Gutierrez
     * método que actualiza la fecha de asignación de la actividad a la que se hace referencia.
     * @param fechaDeAsignacion : La nueva fecha de asignación pára la actividad.
     */
    public void setFechaDeAsignacion(Date fechaDeAsignacion) {
        this.fechaDeAsignacion = fechaDeAsignacion;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve la fecha de revisión de la actividad a la que se hace referencia.
     * @return: la fecha de revisión de la actividad.
     */
    public Date getFechaDeRevision() {
        return fechaDeRevision;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se encarga de actualizar la fecha de revisión
     * @param fechaDeRevision : la nueva fecha de revisión para la actividad a la que se hace referencia.
     */
    public void setFechaDeRevision(Date fechaDeRevision) {
        this.fechaDeRevision = fechaDeRevision;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuleve la cantidad decimal de jornales que cuesta realizar una actividad.
     * @return : La cantidad de jornales de la actividad.
     */
    public float getCantidadDeJornales() {
        return cantidadDeJornales;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que actualiza la cantidad de jornales que cuesta una actividad
     * @param cantidadDeJornales : la nueva cantidad de jornales que cuesta realizar una actividad.
     */
    public void setCantidadDeJornales(float cantidadDeJornales) {
        this.cantidadDeJornales = cantidadDeJornales;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se encarga de obtener el estado de la actividad a la que se hace referencia
     * @return : El estado de la actividad.
     */
    public char getEstado() {
        return estado;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se encarga de actualizar el estado actual de la actividad.
     * @param estado : El nuevo caracter que representa el estado de la actividad.
     */
    public void setEstado(char estado) {
        this.estado = estado;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve la finca en la cual se realiza una actividad.
     * @return :la finca donde se realiza la actividad.
     */
    public Finca getFinca() {
        return finca;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se encarga de actualizar la finca donde se realiza la actividad.
     * @param finca : la nueva finca donde se realiza la actividad.
     */
    public void setFinca(Finca finca) {
        this.finca = finca;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que obtiene el tipo o clase de actividad de la actividad actual.
     * @return :El tipo de actividad de la actividad.
     */
    public TipoDeActividad getTipoDeActividad() {
        return tipoDeActividad;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se encarga de actualizar el tipo de actividad de la finca.
     * @param tipoDeActividad : El nuevo tipo de actividad de la actividad.
     */
    public void setTipoDeActividad(TipoDeActividad tipoDeActividad) {
        this.tipoDeActividad = tipoDeActividad;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve el empleado al que se le asignó la actividad actual.
     * @return :El empleado que tiene a cargo la actividad actual
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que se encarga de actualizar el empleado
     * @param empleado
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
