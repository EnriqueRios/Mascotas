package com.example.mascotasapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.fab), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaDeMascotas();
        InicializarAdaptador();
    }

    public void mostrarFavoritos(){

       Intent intent = new Intent(MainActivity.this, ActivityFavoritos.class);
       startActivity(intent);
      // finish();
    }

    public void InicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaDeMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.mipmap.perrito1, "Motta",0));
        mascotas.add(new Mascota(R.mipmap.perrito2, "Zulky",0));
        mascotas.add(new Mascota(R.mipmap.gato, "Kitty",0));
        mascotas.add(new Mascota(R.mipmap.conejito, "Bony",0));
        mascotas.add(new Mascota(R.mipmap.gato2, "Manchas",0));
        mascotas.add(new Mascota(R.mipmap.hamster, "Randy",0));
        mascotas.add(new Mascota(R.mipmap.pajaro, "Rupert",0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_menu) {
            mostrarFavoritos();
            return true;
        }

        else if(id == R.id.btnFavoritos){
           mostrarFavoritos();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}