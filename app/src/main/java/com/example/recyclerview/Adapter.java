package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderDatos> {

    private LayoutInflater inflater;
   private List<Persona> personas;


    public Adapter (List<Persona> personas) {
        this.personas = personas;

    }


    @NonNull
    @Override
    public Adapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemd,null,false);
        return new ViewHolderDatos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos h, int i) {
        Persona ci =personas.get(i);

        String Nombre = ci.getNombre();
        String Apellido = ci.getApellido();
        Integer Edad = ci.getEdad();
        Integer id = ci.getId();
        String Telefono= ci.getTelefono();

        h.nombre.setText(Nombre);
        h.apellido.setText(Apellido);
        h.edad.setText(Edad.toString());
        h.id.setText(id.toString());
        h.telefono.setText(Telefono);

        h.itemView.setOnClickListener(Persona.metodoclick(ci));

        //h.txtnombre.setText(personas.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        //public Object nombre;
        TextView Datos;
        public TextView nombre,edad,apellido,id,telefono;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.txtid);
            nombre=itemView.findViewById(R.id.txtnom);
            apellido=itemView.findViewById(R.id.apellidos2);
            edad=itemView.findViewById(R.id.edad2);
            telefono=itemView.findViewById(R.id.telefono);
        }


    }
}
