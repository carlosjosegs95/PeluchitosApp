package com.example.carlosjose95.peluchitosapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EliminarFragment extends Fragment {

    private EditText eParametro;
    private TextView tID, tNombre, tCantidad, tPrecio;
    private Button bBuscar, bEliminar;
    boolean mostrar = false;
    Peluchito ExplorarPeluches = new Peluchito();
    ArrayList<Peluchito> Peluches = new ArrayList<Peluchito>();

    public EliminarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eliminar, container, false);

        eParametro = view.findViewById(R.id.eParametro1);
        tID = view.findViewById(R.id.tID1);
        tNombre = view.findViewById(R.id.tNombre1);
        tCantidad = view.findViewById(R.id.tCantidad1);
        tPrecio = view.findViewById(R.id.tPrecio1);
        bBuscar = view.findViewById(R.id.bBuscar1);
        bEliminar = view.findViewById(R.id.bEliminar1);

        Bundle args = getArguments();

        if(args != null){
            Peluches = args.getParcelableArrayList("peluches");
        }

        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Peluches.isEmpty()){
                    Toast.makeText(getContext(), "No se encontró el peluche", Toast.LENGTH_SHORT).show();
                } else {
                    int cont = 0;
                    boolean ok = false;
                    String parametro = eParametro.getText().toString();
                    while(ok == false) {
                        if(cont < Peluches.size()) {
                            if (Peluches.get(cont).getId().equals(parametro) || Peluches.get(cont).getNombre().equals(parametro)) {
                                ExplorarPeluches = Peluches.get(cont);
                                ok = true;
                                mostrar = true;
                            } else {
                                cont++;
                            }
                        } else {
                            Toast.makeText(getContext(), "No se encontró el peluche", Toast.LENGTH_SHORT).show();
                            ok = true;
                        }
                    }
                    if(mostrar == true){
                        tID.setText(ExplorarPeluches.getId());
                        tNombre.setText(ExplorarPeluches.getNombre());
                        tCantidad.setText(ExplorarPeluches.getCantidad());
                        tPrecio.setText(ExplorarPeluches.getPrecio());
                    }
                }
            }
        });

        bEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mostrar == true){
                    mostrar = false;
                    tID.setText("");
                    tNombre.setText("");
                    tCantidad.setText("");
                    tPrecio.setText("");
                    Peluches.remove(ExplorarPeluches);
                    ((MainActivity)getActivity()).EliminarPeluche(ExplorarPeluches);
                }else {
                    Toast.makeText(getContext(), "Busca el peluche que deseas eliminar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
