package com.example.mascotasapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaviewholder, int position) {
       final Mascota mascota = mascotas.get(position);

       mascotaviewholder.imgFoto.setImageResource(mascota.getFoto());
       mascotaviewholder.tvNombre.setText(mascota.getNombre());
       mascotaviewholder.tvLike.setText(mascota.getLike()+"");

       mascotaviewholder.imgFoto.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
               /*
               Intent intent = new Intent(activity, DetalleMascota.class);
               intent.putExtra(name "lstFavoritas", );

                */
           }
       });
       mascotaviewholder.btnLike.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int like = mascota.getLike();
               like++;
               mascota.setLike(like);
               mascota.setFavorito(true);

               Toast.makeText(activity, "Like a ♥"+mascota.getNombre()+"♥", Toast.LENGTH_SHORT).show();
               mascotaviewholder.tvLike.setText(mascota.getLike()+"");

           }
       });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
       private ImageView imgFoto;
       private TextView tvNombre;
       private TextView tvLike;
       private ImageButton btnLike;

       public MascotaViewHolder(@NonNull View itemView) {
           super(itemView);
           imgFoto  = (ImageView) itemView.findViewById(R.id.imgFoto);
           tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
           tvLike   = (TextView) itemView.findViewById(R.id.tvLike);
           btnLike  = (ImageButton) itemView.findViewById(R.id.btnLike);
       }
   }
}
