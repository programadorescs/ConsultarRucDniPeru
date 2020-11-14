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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pcs.consultarrucdniperu.R;

public class ConfiguracionFragment extends Fragment {

    private EditText txtTokenApiPeruDev, txtTokenApisPeru;
    private FloatingActionButton fabGrabar;
    private SharedPreferences.Editor editor;
    private String TOKEN_APIS = "token_apis";

    public ConfiguracionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_configuracion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtTokenApiPeruDev = view.findViewById(R.id.et_token_apiperu_dev);
        txtTokenApisPeru = view.findViewById(R.id.et_token_apisperu);
        fabGrabar = view.findViewById(R.id.fab_grabar);

        fabGrabar.setOnClickListener(view1 -> {
            editor = getActivity().getSharedPreferences(TOKEN_APIS, Context.MODE_PRIVATE).edit();
            editor.putString("token_dev", txtTokenApiPeruDev.getText().toString());
            editor.putString("token_apisperu", txtTokenApisPeru.getText().toString());
            editor.apply();
            editor.commit();

            Toast.makeText(view1.getContext(), "Operacion exitosa", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences prefs = getActivity().getSharedPreferences(TOKEN_APIS, Context.MODE_PRIVATE);
        txtTokenApiPeruDev.setText(prefs.getString("token_dev", "").trim());
        txtTokenApisPeru.setText(prefs.getString("token_apisperu", "").trim());
    }
}