package com.example.mascotasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityFavoritos extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar = findViewById(R.id.toolbar);

      //  setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Habilita el botón subir en el actionbar

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaDeMascotas();
        InicializarAdaptador();

    }

    public void InicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaDeMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.mipmap.perrito1, "Motta",15));
        mascotas.add(new Mascota(R.mipmap.gato, "Kitty",10));
        mascotas.add(new Mascota(R.mipmap.conejito, "Bony",8));
        mascotas.add(new Mascota(R.mipmap.gato2, "Manchas",7));
        mascotas.add(new Mascota(R.mipmap.pajaro, "Rupert",6));
    }
}