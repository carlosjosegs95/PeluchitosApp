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
public class BuscarFragment extends Fragment {

    private EditText eParametro;
    private TextView tID, tNombre, tCantidad, tPrecio;
    private Button bBuscar;
    ArrayList<Peluchito> Peluches = new ArrayList<Peluchito>();

    public BuscarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscar, container, false);

        eParametro = view.findViewById(R.id.eParametro);
        tID = view.findViewById(R.id.tID);
        tNombre = view.findViewById(R.id.tNombre);
        tCantidad = view.findViewById(R.id.tCantidad);
        tPrecio = view.findViewById(R.id.tPrecio);
        bBuscar = view.findViewById(R.id.bBuscar);

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
                    boolean mostrar = false;
                    Peluchito ExplorarPeluches = new Peluchito();
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

        return view;
    }

}
