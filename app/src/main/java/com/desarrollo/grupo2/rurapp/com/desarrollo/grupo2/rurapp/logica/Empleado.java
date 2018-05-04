package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by FRANKLINSIERRA on 28/03/2018.
 */

public class Empleado extends Persona implements Parcelable {

    private String idEmpleado;
    private String estado;
    private double valorJornal;
    private String cedula;

    /**
     * @author Franklin Sierra
     * @param idEmpleado : id que se le asigna al empleado
     * @param estado : en que estado se encuentra el empleado (activo, despedido, vacaciones, etc)
     * @param valorJornal : valor dado en pesos de cada jornal
     * @param cedula : identificacion del empleado
     * */
    public Empleado(String idEmpleado,String primerNombre, String segundoNombre,
                    String primerApelllido, String segundoApellido, Date fechaNacimiento,
                    String salud, String celular, String estado, double valorJornal, String cedula) {
        super(primerNombre, segundoNombre, primerApelllido, segundoApellido, fechaNacimiento,
                salud, celular);
        this.idEmpleado = idEmpleado;
        this.estado = estado;
        this.valorJornal = valorJornal;
        this.cedula = cedula;
    }

    /**
     * @author Franklin Sierra
     * @param idEmpleado : id que se le asigna al empleado
     * @param estado : en que estado se encuentra el empleado (activo, despedido, vacaciones, etc)
     * @param valorJornal : valor dado en pesos de cada jornal
     * @param cedula : identificacion del empleado
     * */
    public Empleado(String idEmpleado,String primerNombre, String segundoNombre,
                    String primerApelllido, String segundoApellido, String fechaNacimiento,
                    String salud, String celular, String estado, double valorJornal, String cedula) {

        super(primerNombre, segundoNombre, primerApelllido, segundoApellido, fechaNacimiento,
                salud, celular);
        this.idEmpleado = idEmpleado;
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

    /**
     * @author Franklin Sierra
     * Actualizar el id del empleado
     * */
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
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


    /**
     * @author: Yesid A Gutierrez.
     * Método que crea un tipo de actividad apartir de un objeto Parcel
     * @param entrada : la entrada de datos para implementar el parcel.
     */
    public Empleado(Parcel entrada){
        String[] datos = new String[9];
        entrada.readStringArray(datos);
        this.idEmpleado = datos[0];
        this.setPrimerNombre(datos[1]);
        this.setSegundoNombre(datos[2]);
        this.setPrimerApelllido(datos[3]);
        this.setSegundoApellido(datos[4]);
        this.setSalud(datos[5]);
        this.setCelular(datos[6]);
        this.setEstado(datos[7]);
        this.setCedula(datos[8]);
        this.setNacimiento(  (Date) entrada.readValue( Date.class.getClassLoader() ) );
        this.setValorJornal(entrada.readDouble());
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
        destino.writeStringArray(new String[] {this.getIdEmpleado(),
                this.getPrimerNombre(),
                this.getSegundoNombre(),
                this.getPrimerApelllido(),
                this.getSegundoApellido(),
                this.getSalud(),
                this.getCelular(),
                this.getEstado(),
                this.getCedula()});
        destino.writeValue(this.getNacimiento());
        destino.writeDouble(this.getValorJornal());
    }

    /**
     * @author: Yesid A Gutierrez
     * Variable global estática CREATOR es necesaria para implementar la clase Parcelable.
     */
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Empleado createFromParcel(Parcel entrada) {
            return new Empleado(entrada);
        }

        public Empleado[] newArray(int tamaño) {
            return new Empleado[tamaño];
        }
    };
}
