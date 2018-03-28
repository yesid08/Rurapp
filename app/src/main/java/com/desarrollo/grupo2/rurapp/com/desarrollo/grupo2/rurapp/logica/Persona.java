package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import java.util.Date;

/**
 * Created by FRANKLINSIERRA on 27/03/2018.
 * @author : Franklin Sierra.
 * Clase persona para la aplicacion Rurapp
 */
public class Persona {

    private String primerNombre;
    private String segundoNombre;
    private String primerApelllido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String salud;
    private String celular;

    /**
     * @param primerNombre: primer nombre de la persona
     * @param segundoNombre: segundo nombre de la persona
     * @param primerApelllido: primer apellido de la persona
     * @param segundoApellido: segundo apellido de la persona
     * @param fechaNacimiento: fecha de nacimiento de la persona
     * @param salud: EPS de la persona
     * @param celular: numero de celular de la persona
     */
    public Persona(String primerNombre, String segundoNombre, String primerApelllido, String segundoApellido,
                   Date fechaNacimiento, String salud, String celular) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApelllido = primerApelllido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.salud = salud;
        this.celular = celular;
    }

    /**
     * @author : Franklin Sierra.
     * Metodo constructor sin parametros
     * */
    public Persona(){
        this.primerNombre="";
        this.segundoNombre="";
        this.primerApelllido="";
        this.segundoApellido="";
        this.fechaNacimiento=new Date();
        this.salud="";
        this.celular="";
    }

    /**
     * @author : Franklin Sierra.
     * Metodo para obtener el primer nombre de la persona
     * @return primer nombre
     * */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * @author : Franklin Sierra.
     * Metodo para actualizar el primer segundo de la persona
     * @param primerNombre: primer nomre de la persona
     **/
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     * @author : Franklin Sierra.
     * Metodo para obtener el segundo nombre de la persona
     * @return segundo nombre
     * */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * @author : Franklin Sierra.
     * Metodo para actualizar el segundo nombre de la persona
     * @param segundoNombre: segundo nombre de la persona
     * */
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener el primer apellido de la persona
     * @return primer apellido
     * */
    public String getPrimerApelllido() {
        return primerApelllido;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar el primer apellido de la persona
     * @param primerApelllido: primer apellido de la persona
     * */
    public void setPrimerApelllido(String primerApelllido) {
        this.primerApelllido = primerApelllido;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener el segundo apellido de la persona
     * @return segundo apellido
     * */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar el segundo apellido de la persona
     * @param segundoApellido : segundo apellido de la persona
     * */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener la fecha de nacimiento de la persona
     * @return fecha de nacimiento
     * */
    public Date getNacimiento() {
        return fechaNacimiento;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar la fecha de nacimiento de la persona
     * @param nacimiento : fecha de nacimiento de la persona
     * */
    public void setNacimiento(Date nacimiento) {
        this.fechaNacimiento = nacimiento;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener EPS de la persona
     * @return EPS
     * */
    public String getSalud() {
        return salud;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar la EPS de la persona
     * @param salud : EPS de la persona
     * */
    public void setSalud(String salud) {
        this.salud = salud;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener el numero de celular de la persona
     * @return celular
     * */
    public String getCelular() {
        return celular;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar el celular de la persona
     * @param celular : movil de la persona
     * */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**@author : Franklin Sierra.
     * Metodo para conocer el primer nombre y apellido de la persona
     * @param primerNombre : primer nombre de la persona
     * @param primerApelllido : primer apellido de la persona
    * */
    public void PrimerNombrePrimerApellido(String primerNombre,String primerApelllido){
        System.out.println("El usuario es"+primerNombre+primerApelllido);
    }
}
