package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import java.util.Date;

/**
 * Created by FRANKLINSIERRA on 27/03/2018.
 * @author : Franklin Sierra
 * Clase administrador que hereda de la clase persona
 */
public class Administrador extends Persona {

    private String correo;
    private String usuario;
    private String clave;
    private String idAdmin;

    /**author: Franklin Sierra
     * @param correo: correo del admin
     * @param usuario: login del admin en la app
     * @param clave : clave del respectivo login
     */
    public Administrador(String primerNombre, String segundoNombre, String primerApelllido, String segundoApellido,
                         Date fechaNacimiento, String salud, String celular, String correo, String usuario, String clave) {
        super(primerNombre, segundoNombre, primerApelllido, segundoApellido, fechaNacimiento, salud, celular);
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
    }

    /**
     * @author Franklin Sierra
     * @param correo : correo del admin
     * @param clave : clave del respectivo correo
     * */
    public Administrador(String correo, String clave){
        super();
        this.correo=correo;
        this.clave=clave;
        this.usuario="";
    }

    /**
     * @author: Franklin Sierra
     * @return el identificador del admin dentro de la BD
     * */
    public String getIdAdmin() {
        return idAdmin;
    }

    /**
     * @author : Franklin Sierra
     * Metodo para obtener el correo del admin
     * @return el correo del admin
     * */
    public String getCorreo() {
        return correo;
    }

    /**@author : Franklin Sierra
     * Metodo que actualiza el correo del admin
     * @param correo : correo del admin
     * */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /** @author : Franklin Sierra
     * Metodo para obtener el login del admin
     * @return el login del admin
     * */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @author : Franklin Sierra
     * Metodo para actualizar el login del admin
     * @param usuario : actualiza el login del usuario
     * */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @author : Franklin Sierra
     * Metodo para obtener clave del admin
     * @return el clave del admin
     * */
    public String getClave() {
        return clave;
    }

    /** @author : Franklin Sierra
     * Metodo para actualizar clave del admin
     * @param clave : actualiza la clave del login
     * */
    public void setClave(String clave) {
        this.clave = clave;
    }

}
