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
import com.pcs.consultarrucdniperu.accesoapi.GetHttpApisPeru;
import com.pcs.consultarrucdniperu.entidades.apisperu.ApisPeru_Dni;
import com.pcs.consultarrucdniperu.entidades.apisperu.ApisPeru_Ruc;
import com.pcs.consultarrucdniperu.snippets.Utilidad;

public class ApisPeruFragment extends Fragment implements GetHttpApisPeru.IApisPeru {

    private EditText txtDniRuc, txtNombre, txtDireccion, txtEstado, txtCondicion;
    private FloatingActionButton fabBuscar;
    private ProgressBar progressBar = null;
    private GetHttpApisPeru.IApisPeru iApisPeru = this;

    public ApisPeruFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apis_peru, container, false);
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
            if(!Utilidad.existeConexionInternet(view.getContext())) {
                Toast.makeText(getContext(), "NO existe acceso a Internet", Toast.LENGTH_LONG).show();
                return;
            }

            String nroDoc = txtDniRuc.getText().toString().trim();
            Utilidad.OcultarTeclado(view1.getContext(), view1);
            Utilidad.LimpiarEditText(getView());

            if(nroDoc.length() == 11 || nroDoc.length() == 8){
                SharedPreferences prefs = getActivity().getSharedPreferences("token_apis", Context.MODE_PRIVATE);
                if(!prefs.getString("token_apisperu", "").trim().equals(""))
                    new GetHttpApisPeru(getContext(), progressBar, iApisPeru).execute(nroDoc, prefs.getString("token_apisperu", "").trim());
                else
                    Toast.makeText(getContext(), "NO tiene un TOKEN configurado", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getContext(), "NRO documento no valido", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void obtenerRuc(ApisPeru_Ruc oEntidad) {
        txtDniRuc.setText(oEntidad.getRuc());
        txtNombre.setText(oEntidad.getRazonSocial());
        txtDireccion.setText(oEntidad.getDireccionCompleta());
        txtEstado.setText(oEntidad.getEstado());
        txtCondicion.setText(oEntidad.getCondicion());

        Utilidad.MostrarMensaje("",
                "Profesion: " + oEntidad.getProfesion() + "\n" +
                        "Nom. comercial: " + oEntidad.getNombreComercial(),
                getContext());
    }

    @Override
    public void obtenerDni(ApisPeru_Dni oEntidad) {
        txtDniRuc.setText(oEntidad.getDni());
        txtNombre.setText(oEntidad.getApellidoNombre());

        Utilidad.MostrarMensaje("",
                "Cod. verificacion: " + oEntidad.getCodVerifica(),
                getContext());
    }
}