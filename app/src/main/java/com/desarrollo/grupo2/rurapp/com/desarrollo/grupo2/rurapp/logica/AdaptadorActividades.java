package com.desarrollo.grupo2.rurapp.com.desarrollo.grupo2.rurapp.logica;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.desarrollo.grupo2.rurapp.R;

import java.util.ArrayList;

public class AdaptadorActividades extends RecyclerView.Adapter< AdaptadorActividades.ViewHolderActividades > {

    private ArrayList<Actividad> actividades;

    public AdaptadorActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    @Override
    public AdaptadorActividades.ViewHolderActividades onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_actividad,
                null,false);
        return new AdaptadorActividades.ViewHolderActividades(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorActividades.ViewHolderActividades holder, int position) {
        holder.nombreDelEmpleado.setText(actividades.get(position).getEmpleado().toString());
        holder.nombreDeLaFinca.setText(actividades.get(position).getFinca().toString());
        holder.cantidadDeJornales.setText(String.valueOf(actividades.get(position)
                .getCantidadDeJornales()));
        holder.nombreActividad.setText(actividades.get(position).getTipoDeActividad().toString());
        holder.estadoActividad.setText(actividades.get(position).getEstado());
    }

    @Override
    public int getItemCount() {
        return this.actividades.size();
    }

    public class ViewHolderActividades extends RecyclerView.ViewHolder {
        TextView nombreActividad;
        TextView estadoActividad;
        TextView cantidadDeJornales;
        TextView nombreDeLaFinca;
        TextView nombreDelEmpleado;

        public ViewHolderActividades(View itemView){
            super(itemView);
            this.estadoActividad = itemView.findViewById(R.id.editText10);
            this.nombreActividad = itemView.findViewById(R.id.textView27);
            this.cantidadDeJornales = itemView.findViewById(R.id.editText12);
            this.nombreDeLaFinca = itemView.findViewById(R.id.textView30);
            this.nombreDelEmpleado = itemView.findViewById(R.id.textView31);
        }
    }


}
