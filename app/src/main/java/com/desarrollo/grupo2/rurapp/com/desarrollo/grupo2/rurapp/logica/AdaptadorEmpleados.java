package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.desarrollo.grupo2.rurapp.R;

import java.util.ArrayList;

/**
 * Clase te tipo Adaptador que funciona para administrar el recyclerView
 * de los empleados.
 */
public class AdaptadorEmpleados extends
        RecyclerView.Adapter< AdaptadorEmpleados.ViewHolderEmpleados > {

    ArrayList<Empleado> empleados;

    /**
     * Constructor de la clase, recibe de parámetro un ArrayList de empleados.
     * @param empleados : El arrayList de empleados
     */
    public AdaptadorEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Clase que gestiona como cada item del recyclerView se relacionan con los objetos de tipo
     * Empleado.
     */
    public class ViewHolderEmpleados extends RecyclerView.ViewHolder {
        TextView primerNombre;
        TextView primerApellido;
        TextView cedula;
        TextView valorJornal;


        /**
         * Constructor de la clase ViewHolder acá se definen los punteros de memoria de los items
         * de cada recyclerView.
         * @param itemView : un item del recyclerView
         */
        public ViewHolderEmpleados(View itemView) {
            super(itemView);
            primerNombre = (TextView) itemView.findViewById(R.id.editText13);
            primerApellido = (TextView) itemView.findViewById(R.id.editText11);
            cedula = (TextView) itemView.findViewById(R.id.editText15);
            valorJornal = (TextView) itemView.findViewById(R.id.editText16);
        }
    }

    /**
     * Método que se ejecuta cuando se crea un recyclerView
     * @param parent : Vista padre
     * @param viewType : tipo de vista.
     * @return Elemento de tipo ViewHolderEmpleados
     */
    @Override
    public ViewHolderEmpleados onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pers,
                null,false);

        return new ViewHolderEmpleados(view);
    }

    /**
     * Método que se encarga de asignar la información de cada uno de los elementos de un sólo item
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolderEmpleados holder, int position) {

        holder.primerNombre.setText(empleados.get(position).getPrimerNombre());
        holder.primerApellido.setText(empleados.get(position).getPrimerApelllido());
        holder.cedula.setText(empleados.get(position).getCedula());
        holder.valorJornal.setText(String.valueOf(empleados.get(position).getValorJornal()));
    }

    /**
     * Método que se encarga de obtener el tamaño de la lista de empleados.
     * @return
     */
    @Override
    public int getItemCount() {
        return empleados.size();
    }

}

