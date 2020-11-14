package com.pcs.consultarrucdniperu.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pcs.consultarrucdniperu.R;
import com.pcs.consultarrucdniperu.accesoapi.GetHttpApiPeruDev;
import com.pcs.consultarrucdniperu.entidades.apiperudev.ApiPeruDevData_Dni;
import com.pcs.consultarrucdniperu.entidades.apiperudev.ApiPeruDevData_Ruc;
import com.pcs.consultarrucdniperu.snippets.Utilidad;

public class ApiPeruDevFragment extends Fragment implements GetHttpApiPeruDev.IApiPeruDev {

    private EditText txtDniRuc, txtNombre, txtDireccion, txtEstado, txtCondicion;
    private FloatingActionButton fabBuscar;
    private ProgressBar progressBar = null;
    private final GetHttpApiPeruDev.IApiPeruDev iApiPeruDev=this;


    public ApiPeruDevFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_api_peru_dev, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.pb_progreso);
        txtDniRuc = view.findViewById(R.id.et_nrodoc);
        txtNombre = view.findViewById(R.id.et_nombre);
        txtDireccion = view.findViewById(R.id.et_direccion);
        txtCondicion = view.findViewById(R.id.et_condicion);
        txtEstado = view.findViewById(R.id.et_estado);
        fabBuscar = view.findViewById(R.id.fab_buscar);

        fabBuscar.setOnClickListener(view1 -> {
            String nroDoc = txtDniRuc.getText().toString().trim();
            Utilidad.OcultarTeclado(view1.getContext(), view1);
            Utilidad.LimpiarEditText(getView());

            if(nroDoc.length() == 11 || nroDoc.length() == 8){
                SharedPreferences prefs = getActivity().getSharedPreferences("token_apis", Context.MODE_PRIVATE);
                if(!prefs.getString("token_dev", "").trim().equals(""))
                    new GetHttpApiPeruDev(getContext(), progressBar, iApiPeruDev).execute(nroDoc, prefs.getString("token_dev", "").trim());
                else
                    Toast.makeText(getContext(), "NO tiene un TOKEN configurado", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getContext(), "NRO documento no valido", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void clienteApiPeruDni(ApiPeruDevData_Dni Cliente) {
        txtDniRuc.setText(Cliente.getData().getNumero());
        txtNombre.setText(Cliente.getData().getNombre_completo());

        Utilidad.MostrarMensaje("",
                "Sexo: " + Cliente.getData().getSexo() + "\n" +
                        "Fec. nacimiento: " + Cliente.getData().getFecha_nacimiento() + "\n" +
                        "Cod. Verificacion: " + Cliente.getData().getCodigo_verificacion(),
                getContext());
    }

    @Override
    public void clienteApiPeruRuc(ApiPeruDevData_Ruc Cliente) {
        txtDniRuc.setText(Cliente.getData().getRuc());
        txtNombre.setText(Cliente.getData().getNombre_o_razon_social());
        txtDireccion.setText(Cliente.getData().getDireccion_completa());
        txtEstado.setText(Cliente.getData().getEstado());
        txtCondicion.setText(Cliente.getData().getCondicion());

        Utilidad.MostrarMensaje("",
                "Direccion: " + Cliente.getData().getDireccion() + "\n" +
                        "Nom. comercial: " + Cliente.getData().getNombre_comercial(),
                getContext());
    }
}