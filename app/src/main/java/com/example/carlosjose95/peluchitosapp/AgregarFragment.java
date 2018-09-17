package com.example.carlosjose95.peluchitosapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarFragment extends Fragment {

    private EditText eID, eNombre, eCantidad, ePrecio;
    private Button bRegistrar;
    ArrayList<Peluchito> Peluches = new ArrayList<Peluchito>();

    public AgregarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar, container, false);

        eID = view.findViewById(R.id.eID);
        eNombre = view.findViewById(R.id.eNombre);
        eCantidad = view.findViewById(R.id.eCantidad);
        ePrecio = view.findViewById(R.id.ePrecio);
        bRegistrar = view.findViewById(R.id.bRegistrar);

        Bundle args = getArguments();

        if(args != null){
            Peluches = args.getParcelableArrayList("peluches");
        }

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((eID.getText().toString().isEmpty()) || (eNombre.getText().toString().isEmpty()) || (eCantidad.getText().toString().isEmpty()) || (ePrecio.getText().toString().isEmpty())) {
                    Toast.makeText(getContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                } else {
                    int cont = 0;
                    boolean ok = false;
                    boolean guardar = false;
                    Peluchito nuevoPeluche = new Peluchito();
                    String ID = eID.getText().toString();
                    String nombre = eNombre.getText().toString();
                    while(ok == false) {
                        if(cont < Peluches.size()) {
                            if (Peluches.get(cont).getId().equals(ID) || Peluches.get(cont).getNombre().equals(nombre)) {
                                Toast.makeText(getContext(), "El peluche ya está registrado", Toast.LENGTH_SHORT).show();
                                ok = true;
                            } else {
                                cont++;
                            }
                        } else {
                            ok = true;
                            guardar = true;
                        }
                    }
                    if(guardar == true){
                        nuevoPeluche.setId(ID);
                        nuevoPeluche.setNombre(nombre);
                        nuevoPeluche.setCantidad(eCantidad.getText().toString());
                        nuevoPeluche.setPrecio(ePrecio.getText().toString());
                        Peluches.add(nuevoPeluche);
                        ((MainActivity)getActivity()).AgregarPeluche(nuevoPeluche);

                    }
                }
            }
        });

        return view;
    }
}
