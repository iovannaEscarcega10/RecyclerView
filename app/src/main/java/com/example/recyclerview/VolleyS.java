package com.example.recyclerview;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS
{
    //para que se pueda acceder a la variable sin necesidad de instanciar la clase

    //getinstance,constructor, requestqueue
    private static VolleyS VolleyS = null;

    private RequestQueue mRequestQueue;//se crea cuando se llama el metodo getinstance



    //la clase singleton sirve para instanciar solo una vez
    //el constructor se hace privado con la intencion de que solo se acceda a el con el metodo getinstace
    private VolleyS(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }
    //public static para que se pueda acceder al metodo sin instanciar,para poder mandarlo a llamar
    public static VolleyS getInstance(Context context){
        if ( VolleyS == null){
            VolleyS = new VolleyS(context);
        }
        return VolleyS;
    }
    public RequestQueue getmRequestQueue(){
        return mRequestQueue;
    }

}
