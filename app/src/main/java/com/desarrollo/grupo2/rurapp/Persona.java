package com.desarrollo.grupo2.rurapp;

/**
 * Created by FRANKLINSIERRA on 27/03/2018.
 * @author : Franklin Sierra.
 * Clase persona para la aplicacion Rurapp
 */

public class Persona {


    private String PrimerNombre;
    private String SegundoNombre;
    private String PrimerApelllido;
    private String SegundoApellido;
    private String Nacimiento;
    private String Salud;
    private String Celular;

    /**
     * @param primerNombre: primer nombre de la persona
     * @param segundoNombre: segundo nombre de la persona
     * @param primerApelllido: primer apellido de la persona
     * @param segundoApellido: segundo apellido de la persona
     * @param nacimiento: fecha de nacimiento de la persona
     * @param salud: EPS de la persona
     * @param celular: numero de celular de la persona
     */

    public Persona(String primerNombre, String segundoNombre, String primerApelllido, String segundoApellido, String nacimiento, String salud, String celular) {
        PrimerNombre = primerNombre;
        SegundoNombre = segundoNombre;
        PrimerApelllido = primerApelllido;
        SegundoApellido = segundoApellido;
        Nacimiento = nacimiento;
        Salud = salud;
        Celular = celular;
    }
    /**
     * @author : Franklin Sierra.
     * Metodo constructor sin parametros
     * */

    public Persona(){
        this.PrimerNombre="";
        this.SegundoNombre="";
        this.PrimerApelllido="";
        this.SegundoApellido="";
        this.Nacimiento=null;
        this.Salud="";
        this.Celular=null;
    }

    /**
     * @author : Franklin Sierra.
     * Metodo para obtener el primer nombre de la persona
     * @return primer nombre
     * */
    public String getPrimerNombre() {
        return PrimerNombre;
    }

    /**
     * @author : Franklin Sierra.
     * Metodo para actualizar el primer segundo de la persona
     **/

    public void setPrimerNombre(String primerNombre) {
        PrimerNombre = primerNombre;
    }

    /**
     * @author : Franklin Sierra.
     * Metodo para obtener el segundo nombre de la persona
     * @return segundo nombre
     * */

    public String getSegundoNombre() {
        return SegundoNombre;
    }


    /**
     * @author : Franklin Sierra.
     * Metodo para actualizar el segundo nombre de la persona
     * */

    public void setSegundoNombre(String segundoNombre) {
        SegundoNombre = segundoNombre;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener el primer apellido de la persona
     * @return primer apellido
     * */

    public String getPrimerApelllido() {
        return PrimerApelllido;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar el primer apellido de la persona
     * */

    public void setPrimerApelllido(String primerApelllido) {
        PrimerApelllido = primerApelllido;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener el segundo apellido de la persona
     * @return segundo apellido
     * */

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar el segundo apellido de la persona
     * */

    public void setSegundoApellido(String segundoApellido) {
        SegundoApellido = segundoApellido;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener la fecha de nacimiento de la persona
     * @return fecha de nacimiento
     * */

    public String getNacimiento() {
        return Nacimiento;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar la fecha de nacimiento de la persona
     * */

    public void setNacimiento(String nacimiento) {
        Nacimiento = nacimiento;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener EPS de la persona
     * @return EPS
     * */

    public String getSalud() {
        return Salud;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar la EPS de la persona
     * */

    public void setSalud(String salud) {
        Salud = salud;
    }

    /**@author : Franklin Sierra.
     * Metodo para obtener el numero de celular de la persona
     * @return celular
     * */

    public String getCelular() {
        return Celular;
    }

    /**@author : Franklin Sierra.
     * Metodo para actualizar el celular de la persona
     * */

    public void setCelular(String celular) {
        Celular = celular;
    }

    /**@author : Franklin Sierra.
     * Metodo para conocer el primer nombre y apellido de la persona
    * */
    public void PrimerNombrePrimerApellido(String primerNombre,String primerApelllido){
        System.out.println("El usuario es"+primerNombre+primerApelllido);
    }
}
