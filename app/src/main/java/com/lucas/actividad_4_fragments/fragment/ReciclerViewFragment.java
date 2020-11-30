package com.lucas.actividad_4_fragments.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lucas.actividad_4_fragments.CustomItemClickListener;
import com.lucas.actividad_4_fragments.R;
import com.lucas.actividad_4_fragments.adapter.MascotaAdaptador;
import com.lucas.actividad_4_fragments.pojo.Mascota;

import java.util.ArrayList;


public class ReciclerViewFragment extends Fragment implements CustomItemClickListener {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private CustomItemClickListener listener;
    private MascotaAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_reciclerview, container, false);

        // traigo a objeto recyclerview
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        // defino orientacion de recyclerviw
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        //inicializo lista de mascotas
        inicializarListaMascotas();
        // inicializo adaptador
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
        adaptador.setClickListener(this);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.gato_1, "Anastasia", 2));
        mascotas.add(new Mascota(R.drawable.gato_2, "Maria", 5));
        mascotas.add(new Mascota(R.drawable.gato_3, "Blacky", 4));
        mascotas.add(new Mascota(R.drawable.gato_2, "Maria", 1));
        mascotas.add(new Mascota(R.drawable.gato_4, "Sonia", 6));
    }

    @Override
    public void likeClicked(View v, int position) {
        // sumo like y actualizo el valor en adaptador
        mascotas.get(position).setLikes( mascotas.get(position).getLikes() + 1);
        adaptador.notifyDataSetChanged();
    }
}