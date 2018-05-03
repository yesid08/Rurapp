package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.desarrollo.grupo2.rurapp.R;

import java.util.ArrayList;

public class AdaptadorTiposDeActividades extends RecyclerView.Adapter< AdaptadorTiposDeActividades.ViewHolderTiposDeActividades > {

    private ArrayList<TipoDeActividad> tiposDeActividades;

    /**
     * Constructor de la clase AdaptadorTiposDeActividades que recibe un ArrayList de tipo Tipo de actividades
     * @param tiposDeActividades : lista de tipo de actividades.
     */
    public AdaptadorTiposDeActividades(ArrayList<TipoDeActividad> tiposDeActividades) {
        this.tiposDeActividades = tiposDeActividades;
    }

    /**
     * método que permite inflar el XML del elemento que se repite en el recyclerView.
     * @param parent : gripo de vistas padre
     * @param viewType : tipoDe vista
     * @return ViewHolder de tipos de actividades.
     */
    @Override
    public AdaptadorTiposDeActividades.ViewHolderTiposDeActividades onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tipoact,
                null,false);

        return new ViewHolderTiposDeActividades(view);
    }

    /**
     * Método que asigna la información Elemento a elemento en el recyclerView.
     * @param holder : objeto de tipo ViewHolderTipoDeActividades
     * @param position : la posición de cada elemento de la lista
     */
    @Override
    public void onBindViewHolder(AdaptadorTiposDeActividades.ViewHolderTiposDeActividades holder, int position) {
        holder.nombreTipoDeActividad.setText(tiposDeActividades.get(position).getNombre());
        holder.descripcionTipoDeActividad.setText(tiposDeActividades.get(position).getDescripcion());
    }

    /**
     * Método que obtiene la cantidad de elementos de la lista.
     * @return Total de elementos de tipo de actividades.
     */
    @Override
    public int getItemCount() {
        return tiposDeActividades.size();
    }

    public class ViewHolderTiposDeActividades extends RecyclerView.ViewHolder {

        TextView nombreTipoDeActividad;
        TextView descripcionTipoDeActividad;

        /**
         * Constructor de la clase ViewHolderTipo de actividades que recibe una vista como parámetro
         * y se encarga de asignar punteros a cada una de las vistas que la componen.
         * @param itemView Una vista.
         */
        public ViewHolderTiposDeActividades(View itemView) {
            super(itemView);
            this.nombreTipoDeActividad = itemView.findViewById(R.id.textView1);
            this.descripcionTipoDeActividad = itemView.findViewById(R.id.textView2);
        }
    }
}
