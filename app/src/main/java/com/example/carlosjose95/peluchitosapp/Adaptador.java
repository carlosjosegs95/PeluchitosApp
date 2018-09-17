package com.example.carlosjose95.peluchitosapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    public static LayoutInflater inflater = null;
    Context context;
    ArrayList<Peluchito> Peluches;

    public Adaptador(Context context, ArrayList<Peluchito> peluches) {
        this.context = context;
        Peluches = peluches;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.elemento_inventario, null);

        TextView ID = view.findViewById(R.id.tID2);
        TextView Nombre = view.findViewById(R.id.tNombre2);
        TextView Cantidad = view.findViewById(R.id.tCantidad2);
        TextView Precio = view.findViewById(R.id.tPrecio2);

        ID.setText(Peluches.get(position).getId());
        Nombre.setText(Peluches.get(position).getNombre());
        Cantidad.setText(Peluches.get(position).getCantidad());
        Precio.setText(Peluches.get(position).getPrecio());

        return view;
    }

    @Override
    public int getCount() {
        return Peluches.size()-1;
    }

    @Override
    public Object getItem(int position) {
        return Peluches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
