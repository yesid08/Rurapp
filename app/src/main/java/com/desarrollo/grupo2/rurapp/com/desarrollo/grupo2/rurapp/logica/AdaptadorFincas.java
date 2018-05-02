package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.desarrollo.grupo2.rurapp.R;

import java.util.ArrayList;

public class AdaptadorFincas extends RecyclerView.Adapter<AdaptadorFincas.ViewHolderFincas> {

    ArrayList<Finca> fincas;

    /**Constructor de la clase AdaptadorFincas
     * @param fincas : Todas las fincas de la app en un objeto de tipo ArrayList.
     */
    public AdaptadorFincas(ArrayList<Finca> fincas) {
        this.fincas = fincas;
    }

    /**
     * Clase que gestiona el Adaptador para cada Item.
     */
    public class ViewHolderFincas extends RecyclerView.ViewHolder {

        TextView nombreFinca;
        TextView descripcionFinca;

        /**
         * Constructor de la clase
         * @param itemView : Vista generada para cada clase.
         */
        public ViewHolderFincas(View itemView) {
            super(itemView);
            nombreFinca = itemView.findViewById(R.id.textView1);
            descripcionFinca = itemView.findViewById(R.id.textView3);
        }
    }

    /**
     * Método donde se apunta al layout que define la estructura de cada elemento del recyclerView
     * @param parent : grupo de vistas padre.
     * @param viewType : tipo de vista.
     * @return Objeto de tipo FincasViewHolder
     */
    @Override
    public ViewHolderFincas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fnc,
                null,false);
        return new ViewHolderFincas(view);
    }

    /**
     * Método que itera la lista y agrega gráficamente el contenido a cada uno.
     * @param holder : Objeto de tipo ViewHolderFincas
     * @param position : posicion en la que se itera.
     */
    @Override
    public void onBindViewHolder(ViewHolderFincas holder, int position) {
        String nombreFincas = fincas.get(position).getNombre();
        String descripcionFincas = fincas.get(position).getDescripcion();
        holder.nombreFinca.setText(nombreFincas);
        holder.descripcionFinca.setText(descripcionFincas);
    }

    /**
     * Método que retorna la cantidad de fincas que hay registradas en la app.
     * @return Cantidad de fincas de la app.
     */
    @Override
    public int getItemCount() {
        return fincas.size();
    }


}
