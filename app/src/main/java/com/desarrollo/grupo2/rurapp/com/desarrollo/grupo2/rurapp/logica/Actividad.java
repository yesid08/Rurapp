package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Yesid A Gutierrez
 * clase Actividad para el proyecto Rurapp
 */
public class Actividad implements Parcelable{

    private String id;
    private Date fechaDeAsignacion;
    private Date fechaDeRevision;
    private double cantidadDeJornales;
    private char estado;
    private Finca finca;
    private TipoDeActividad tipoDeActividad;
    private Empleado empleado;

    /**
     * @author : Yesid A Gutierrez
     * Constructor de la clase Actividad con todos los parámetros excepto el id de la actividad
     * @param id : id que se le asigna a la actividad.
     * @param fechaDeAsignacion : Fecha en la cual se asignó la actividad.
     * @param fechaDeRevision : Fecha en la que se da revisión a la actividad.
     * @param cantidadDeJornales : Cantidad decimal de jornales que requiere la actividad.
     * @param estado : El estado actual de la actividad.
     * @param finca: La finca a la que pertenece la actividad.
     * @param tipoDeActividad : Tipo o clase de actividad que identifica esta actividad.
     * @param empleado : Empleado al que se le asignaron la actividad.
     */
    public Actividad(String id,Date fechaDeAsignacion, Date fechaDeRevision, double cantidadDeJornales,
                     char estado, Finca finca, TipoDeActividad tipoDeActividad, Empleado empleado) {
        this.id = id;
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
     * Método que se encarga de obtener la fecha de la asignación de la actividad
     * @return : la fecha de asignación.En formato String
     */
    public String getFechaDeAsignacionString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.format(fechaDeAsignacion);
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
     * método que actualiza la fecha de asignación de la actividad a la que se hace referencia en String
     * @param fechaDeAsignacion : La nueva fecha de asignación pára la actividad.
     */
    public void setFechaDeAsignacion(String fechaDeAsignacion) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {
            this.fechaDeAsignacion=formatter.parse(fechaDeAsignacion);

        } catch (ParseException e) {
            this.fechaDeAsignacion=null;
        }
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve la fecha de revisión de la actividad a la que se hace referencia.
     * @return : la fecha de revisión de la actividad.
     */
    public Date getFechaDeRevision() {
        return fechaDeRevision;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve la fecha de revisión de la actividad a la que se hace referencia en formato String.
     * @return : la fecha de revisión de la actividad.
     */
    public String getFechaDeRevisionString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.format(this.fechaDeRevision);
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
     * Método que se encarga de actualizar la fecha de revisión
     * @param fechaDeRevision : la nueva fecha de revisión para la actividad a la que se hace referencia en formato String.
     */
    public void setFechaDeRevision(String fechaDeRevision) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {

            this.fechaDeRevision=formatter.parse(fechaDeRevision);

        } catch (ParseException e) {
            this.fechaDeRevision=null;
        }
    }
    /**
     * @author : Yesid A Gutierrez
     * Método que devuleve la cantidad decimal de jornales que cuesta realizar una actividad.
     * @return : La cantidad de jornales de la actividad.
     */
    public double getCantidadDeJornales() {
        return cantidadDeJornales;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que actualiza la cantidad de jornales que cuesta una actividad
     * @param cantidadDeJornales : la nueva cantidad de jornales que cuesta realizar una actividad.
     */
    public void setCantidadDeJornales(double cantidadDeJornales) {
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
     * @param empleado: El nuevo empleado que se encargará de la actividad.
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * @author : Yesid A Gutierrez
     * Método que devuelve el valor o costo de la actividad.
     * @return : El precio de la actividad.
     */
    public double getPrecioActividad() {
        return this.empleado.getValorJornal()*this.getCantidadDeJornales();
    }

    /**
     * @author: Yesid A Gutierrez.
     * Método que crea una actividad apartir de un objeto Parcel
     * @param entrada : la entrada de datos para implementar el parcel.
     */
    public Actividad(Parcel entrada){
        this.id = entrada.readString();
        this.setFechaDeAsignacion(  (Date) entrada.readValue( Date.class.getClassLoader() ) );
        this.setFechaDeRevision(  (Date) entrada.readValue( Date.class.getClassLoader() ) );
        this.setCantidadDeJornales(entrada.readDouble());
        this.setEstado((char) entrada.readValue( char.class.getClassLoader() ));
        this.setFinca((Finca) entrada.readValue( Finca.class.getClassLoader() ));
        this.setTipoDeActividad((TipoDeActividad) entrada.readValue( TipoDeActividad.class.getClassLoader() ));
        this.setEmpleado((Empleado) entrada.readValue( Empleado.class.getClassLoader()));
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
     * Método que se utiliza para escribir sobre el objeto parcel.
     * @param destino : El nuevo parcel que va a recibir el vector.
     * @param flags : banderas para ejecutar el String (no suele utilizarse por defecto.)
     */
    @Override
    public void writeToParcel(Parcel destino, int flags) {
        destino.writeString(this.id);
        destino.writeValue(this.getFechaDeAsignacion());
        destino.writeValue(this.getFechaDeRevision());
        destino.writeDouble(this.getCantidadDeJornales());
        destino.writeValue(this.estado);
        destino.writeValue(this.getFinca());
        destino.writeValue(this.getTipoDeActividad());
        destino.writeValue(this.getEmpleado());

    }

    /**
     * @author: Yesid A Gutierrez
     * Variable global estática CREATOR es necesaria para implementar la clase Parcelable.
     */
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Actividad createFromParcel(Parcel entrada) {
            return new Actividad(entrada);
        }

        public Actividad[] newArray(int tamaño) {
            return new Actividad[tamaño];
        }
    };
}
