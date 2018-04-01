package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by FRANKLINSIERRA on 27/03/2018.
 * @author : Franklin Sierra
 * Clase administrador que hereda de la clase persona
 */
public class Administrador implements Parcelable{

    private String correo;
    private String usuario;
    private String idAdmin;

    /**author: Franklin Sierra
     * @param correo: correo del admin
     * @param usuario: login del admin en la app
     */
    public Administrador(String correo , String usuario) {

        this.correo = correo;
        this.usuario = usuario;
        this.idAdmin = "0";
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

    public Administrador(Parcel entrada){
        String[] datos = new String[3];
        entrada.readStringArray(datos);
        // the order needs to be the same as in writeToParcel() method
        this.setCorreo(datos[0]);
        this.setUsuario(datos[1]);
        this.idAdmin = datos[2];
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
        destino.writeStringArray(new String[] {this.getCorreo(),
                this.getUsuario(),
                this.getIdAdmin()});
    }

    /**
     * @author: Yesid A Gutierrez
     * Variable global estática CREATOR es necesaria para implementar la clase Parcelable.
     */
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Administrador createFromParcel(Parcel entrada) {
            return new Administrador(entrada);
        }

        public Administrador[] newArray(int tamaño) {
            return new Administrador[tamaño];
        }
    };


}
