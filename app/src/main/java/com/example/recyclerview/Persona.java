package com.example.recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class Persona {
    private Integer id;
    private String Nombre;
    private String Apellido;
    private Integer Edad;
    private String Telefono;



    public Persona(Integer id,String nombre, String apellido, Integer edad,String Telefono) {
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
        id = id;
        Telefono=Telefono;
    }
    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public String getNombre(){
        return Nombre;

    }
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getApellido(){
        return Apellido;

    }

    public void setEdad(int Edad)
    {
        this.Edad=Edad;
    }

    public int getEdad(){
        return Edad;
    }
    public void setTelefono(String Telefono)
    {
        this.Telefono=Telefono;
    }

    public String getTelefono(){
        return Telefono;
    }

    public static View.OnClickListener metodoclick(final Persona persona)
    {
        View.OnClickListener oc = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + persona.getTelefono().toString()));
                v.getContext().startActivity(intent);
            }
        };
        return oc;
    }
}
