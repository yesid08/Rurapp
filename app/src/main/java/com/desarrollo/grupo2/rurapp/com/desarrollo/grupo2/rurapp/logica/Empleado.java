package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import java.util.Date;

/**
 * Created by FRANKLINSIERRA on 28/03/2018.
 */

public class Empleado extends Persona {

    private String idEmpleado;
    private String estado;
    private double valorJornal;
    private String cedula;

    /**
     * @author Franklin Sierra
     * @param estado : en que estado se encuentra el empleado (activo, despedido, vacaciones, etc)
     * @param valorJornal : valor dado en pesos de cada jornal
     * @param cedula : identificacion del empleado
     * */
    public Empleado(String primerNombre, String segundoNombre, String primerApelllido, String segundoApellido,
                    Date fechaNacimiento, String salud, String celular, String estado, double valorJornal, String cedula) {
        super(primerNombre, segundoNombre, primerApelllido, segundoApellido, fechaNacimiento, salud, celular);
        this.estado = estado;
        this.valorJornal = valorJornal;
        this.cedula = cedula;
    }

    /**
     * @author Franklin Sierra
     * Obtener el estado del trabajador
     * @return el estado actual del trabajador
     * */
    public String getEstado() {
        return estado;
    }

    /**@author Franklin Sierra
     * actualiza el estado del trabajador
     * @param estado : nuevo estado del trabajador
     * */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**@author Franklin Sierra
     * Obtener el valor del jornal del trabajador
     * @return el valor monetario del jornal del trabajador
     * */
    public double getValorJornal() {
        return valorJornal;
    }

    /**@author Franklin Sierra
     * Actualizar el valor del jornal del trabajador
     * @param valorJornal :valor monetario del jornal del trabajador
     * */
    public void setValorJornal(double valorJornal) {
        this.valorJornal = valorJornal;
    }

    /**@author Franklin Sierra
     * Obtener cedula del trabajador
     * @return cedula del trabajador
     * */
    public String getCedula() {
        return cedula;
    }

    /**@author Franklin Sierra
     * Actualizar la cedula del trabajador
     * @param cedula :cedula  del trabajador
     * */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**@author Franklin Sierra
     * Obtener id del trabajador
     * @return id del trabajador
     * */
    public String getIdEmpleado() {
        return idEmpleado;
    }
}
