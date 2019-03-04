package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    public void onClick(View view) {
        //un listener para recibir la respuesta
        JsonArrayRequest jor = new JsonArrayRequest(Request.Method.GET, "http://nuevo.rnrsiilge-org.mx/lista", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            //el Gson se usa para convertir de un json a una lista
                            Gson g=new Gson(); //trae la información en un jsonArray
                            //el gson necesita un array, un tipo de dato etc..

                            //Con el token se saca el tipo de dato y convertirlo de jsonArray a lista de personas
                            Type t = new TypeToken<List<Persona>>(){}.getType();

                            List<Persona> lp = g.fromJson(response.toString(),t);


                            Adapter adapter = new Adapter(lp);
                            recyclerView.setAdapter(adapter);

                            //Log.d("Listaa",adapter.toString());




                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        //ese contexto se lo pasa al constructor
        VolleyS.getInstance(this).getmRequestQueue().add(jor);


    }
}
