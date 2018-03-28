package com.desarrollo.grupo2.rurapp;

/**
 * Created by FRANKLINSIERRA on 27/03/2018.
 * @author : Franklin Sierra
 * Clase administrador que hereda de la clase persona
 */
public class Administrador extends Persona {

    private String Correo;
    private String Usuario;
    private String Clave;

    /**author: Franklin Sierra
     * @param correo: correo del admin
     * @param usuario: login del admin en la app
     * @param clave : clave del respectivo login
     */
    public Administrador(String primerNombre, String segundoNombre, String primerApelllido,
                         String segundoApellido, String nacimiento, String salud, String celular,
                         String correo, String usuario, String clave) {
        super(primerNombre, segundoNombre, primerApelllido, segundoApellido, nacimiento, salud, celular);
        Correo = correo;
        Usuario = usuario;
        Clave = clave;
    }

    /**
     * @author : Franklin Sierra
     * Metodo para obtener el correo del admin
     * @return el correo del admin
     * */
    public String getCorreo() {
        return Correo;
    }

    /**@author : Franklin Sierra
     * Metodo que actualiza el correo del admin
     * */
    public void setCorreo(String correo) {
        Correo = correo;
    }

    /** @author : Franklin Sierra
     * Metodo para obtener el login del admin
     * @return el login del admin
     * */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @author : Franklin Sierra
     * Metodo para actualizar el login del admin
     * */
    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    /**
     * @author : Franklin Sierra
     * Metodo para obtener clave del admin
     * @return el clave del admin
     * */
    public String getClave() {
        return Clave;
    }

    /** @author : Franklin Sierra
     * Metodo para actualizar clave del admin
     * */
    public void setClave(String clave) {
        Clave = clave;
    }
}
