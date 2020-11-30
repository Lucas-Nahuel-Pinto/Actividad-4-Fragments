package com.lucas.actividad_4_fragments.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lucas.actividad_4_fragments.R;
import com.lucas.actividad_4_fragments.CustomItemClickListener;
import com.lucas.actividad_4_fragments.adapter.MascotaAdaptadorPerfil;
import com.lucas.actividad_4_fragments.pojo.Mascota;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private CustomItemClickListener listener;
    private MascotaAdaptadorPerfil adaptadorPerfil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas2);

        listaMascotas.setLayoutManager(new GridLayoutManager(getContext(), 3));

        inicializarListaMascotas();

        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador() {
        adaptadorPerfil = new MascotaAdaptadorPerfil(mascotas);
        listaMascotas.setAdapter(adaptadorPerfil);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.gato_1, "Anastasia", 2));
        mascotas.add(new Mascota(R.drawable.gato_2, "Maria", 5));
        mascotas.add(new Mascota(R.drawable.gato_3, "Blacky", 4));
        mascotas.add(new Mascota(R.drawable.gato_3, "Blacky", 1));
        mascotas.add(new Mascota(R.drawable.gato_4, "Sonia", 6));
        mascotas.add(new Mascota(R.drawable.gato_1, "Anastasia", 2));
        mascotas.add(new Mascota(R.drawable.gato_2, "Maria", 5));
        mascotas.add(new Mascota(R.drawable.gato_3, "Blacky", 4));
        mascotas.add(new Mascota(R.drawable.gato_2, "Maria", 1));
        mascotas.add(new Mascota(R.drawable.gato_4, "Sonia", 6));
    }
}
