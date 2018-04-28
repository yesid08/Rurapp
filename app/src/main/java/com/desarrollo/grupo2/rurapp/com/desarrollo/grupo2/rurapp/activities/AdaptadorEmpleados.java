package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.desarrollo.grupo2.rurapp.R;
import com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica.Empleado;

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
        EditText nombre;
        CheckBox contratado;
        Button boton;


        /**
         * Constructor de la clase ViewHolder acá se definen los punteros de memoria de los items
         * de cada recyclerView.
         * @param itemView : un item del recyclerView
         */
        public ViewHolderEmpleados(View itemView) {
            super(itemView);
            nombre = (EditText) itemView.findViewById(R.id.editText10);
            boton = (Button) itemView.findViewById(R.id.button5);
            contratado = (CheckBox) itemView.findViewById(R.id.checkBox);
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
        String nombre = empleados.get(position).getPrimerNombre() + " "+
                empleados.get(position).getPrimerApelllido();
        holder.nombre.setText(nombre);
        if (empleados.get(position).getEstado() == "contratado") {
            holder.contratado.setChecked(true);
        }
        else{
            holder.contratado.setChecked(false);
        }
        holder.boton.setText("EDITAR");
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

