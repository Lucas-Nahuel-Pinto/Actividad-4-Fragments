package com.lucas.actividad_4_fragments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lucas.actividad_4_fragments.R;
import com.lucas.actividad_4_fragments.CustomItemClickListener;
import com.lucas.actividad_4_fragments.pojo.Mascota;

import java.util.ArrayList;


public class MascotaAdaptadorPerfil extends RecyclerView.Adapter<MascotaAdaptadorPerfil.MascotaViewHolder>{

    private ArrayList<Mascota> mascotas;
    private CustomItemClickListener clickListener;

    public MascotaAdaptadorPerfil(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void setClickListener(CustomItemClickListener clickListener)
    {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas_perfil, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {   // obtiene objeto para reciclaje
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(R.drawable.foto_de_perfil);

        mascotaViewHolder.tvLikes.setText(Integer.toString(mascota.getLikes()));

    }

    @Override
    public int getItemCount() {         // cantidad de elemento de la lista
        return mascotas.size();
    }


    public class MascotaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgFoto;
        private TextView tvLikes;

        public MascotaViewHolder(final View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
    }

        @Override
        public void onClick(View view) {
        }
    }
}