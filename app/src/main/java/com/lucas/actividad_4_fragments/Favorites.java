package com.lucas.actividad_4_fragments;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lucas.actividad_4_fragments.adapter.MascotaAdaptador;
import com.lucas.actividad_4_fragments.pojo.Mascota;

import java.util.ArrayList;


public class Favorites extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites_layout);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // traigo a objeto recyclerview
        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMascotas);

        // defino orientacion de recyclerviw
        LinearLayoutManager llm2 = new LinearLayoutManager(this);

        llm2.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm2);

        //inicializo lista de mascotas
        inicializarListaMascotasFav();

        // inicializo adaptador
        inicializarAdaptador();
    }


    private void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotasFav.setAdapter(adaptador);
    }

    private void inicializarListaMascotasFav() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.gato_1, "Anastasia", 6));
        mascotas.add(new Mascota(R.drawable.gato_2, "Maria", 5));
        mascotas.add(new Mascota(R.drawable.gato_3, "Blacky", 4));
        mascotas.add(new Mascota(R.drawable.gato_1, "Anastasia", 2));
        mascotas.add(new Mascota(R.drawable.gato_2, "Maria", 1));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                Intent intent = new Intent(this, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
                finish();
                break;
            // Something else
        }
        return super.onOptionsItemSelected(item);
    }
}
