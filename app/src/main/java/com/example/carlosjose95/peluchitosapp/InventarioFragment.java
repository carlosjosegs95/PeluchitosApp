package com.example.carlosjose95.peluchitosapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventarioFragment extends Fragment {

    private ListView listView;
    private ArrayList<Peluchito> Peluches = new ArrayList<Peluchito>();
    private Adaptador adapter;

    public InventarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventario, container, false);

        listView = view.findViewById(R.id.lvLista);

        Bundle args = getArguments();

        if(args != null){
            Peluches = args.getParcelableArrayList("peluches");
        }

        adapter = new Adaptador(getContext(), Peluches);
        listView.setAdapter(adapter);

        return view;
    }

}
