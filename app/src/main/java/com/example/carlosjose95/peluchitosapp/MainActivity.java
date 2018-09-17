package com.example.carlosjose95.peluchitosapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<Peluchito> Peluches = new ArrayList<Peluchito>();

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        InicioFragment inicioFragment = new InicioFragment();
        ft.add(R.id.frame, inicioFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        ft = fm.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("peluches", Peluches);
        for(int i=1; i<Peluches.size(); i++){
            System.out.println(Peluches.get(i).getId());
        }

        if (id == R.id.Agregar) {
            AgregarFragment agregarFragment = new AgregarFragment();
            ft.replace(R.id.frame, agregarFragment).commit();
            agregarFragment.setArguments(bundle);
        } else if (id == R.id.Buscar) {
            BuscarFragment buscarFragment = new BuscarFragment();
            ft.replace(R.id.frame, buscarFragment).commit();
            buscarFragment.setArguments(bundle);
        } else if (id == R.id.Eliminar) {
            EliminarFragment eliminarFragment = new EliminarFragment();
            ft.replace(R.id.frame, eliminarFragment).commit();
            eliminarFragment.setArguments(bundle);
        } else if (id == R.id.Inventario) {
            InventarioFragment inventarioFragment = new InventarioFragment();
            ft.replace(R.id.frame, inventarioFragment).commit();
            inventarioFragment.setArguments(bundle);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void AgregarPeluche(Peluchito Peluche) {
        Peluches.add(Peluche);
        Toast.makeText(this, "Peluche registrado con éxito", Toast.LENGTH_SHORT).show();
    }

    public void EliminarPeluche(Peluchito peluche){
        Peluches.remove(peluche);
        Toast.makeText(this, "Peluche eliminado", Toast.LENGTH_SHORT).show();
    }

}
