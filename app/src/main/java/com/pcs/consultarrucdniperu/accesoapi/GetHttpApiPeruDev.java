package com.pcs.consultarrucdniperu.accesoapi;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pcs.consultarrucdniperu.entidades.apiperudev.ApiPeruDevData_Dni;
import com.pcs.consultarrucdniperu.entidades.apiperudev.ApiPeruDevData_Ruc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetHttpApiPeruDev extends AsyncTask<String, Void, String> {
    private Context mContexto;
    private ProgressBar progressBar;
    private IApiPeruDev iApiPeruDev;
    private static String tipoDoc="";

    public GetHttpApiPeruDev(Context mContexto, ProgressBar progressBar, IApiPeruDev iApiPeruDev) {
        this.mContexto = mContexto;
        this.progressBar = progressBar;
        this.iApiPeruDev = iApiPeruDev;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        this.progressBar.setVisibility(View.GONE);
        progressBar=null;

        if(s.length() != 0){
            Gson gson = new Gson();
            if(tipoDoc.trim().length() == 11){
                ApiPeruDevData_Ruc cliente = gson.fromJson(s, ApiPeruDevData_Ruc.class);
                if(cliente.getSuccess().toLowerCase().equals("true")){
                    iApiPeruDev.clienteApiPeruRuc(cliente);
                } else {
                    Toast.makeText(mContexto, "NO existen datos", Toast.LENGTH_SHORT).show();
                }
            } else {
                ApiPeruDevData_Dni cliente = gson.fromJson(s, ApiPeruDevData_Dni.class);
                if(cliente.getSuccess().toLowerCase().equals("true")){
                    iApiPeruDev.clienteApiPeruDni(cliente);
                } else {
                    Toast.makeText(mContexto, "NO existen datos", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(mContexto, "NO existen datos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        String resultado="";
        try{
            tipoDoc = strings[0];
            URL url;
            if(strings[0].trim().length() == 8)
                url = new URL("https://apiperu.dev/api/dni/" + strings[0].trim());
            else
                url = new URL("https://apiperu.dev/api/ruc/" + strings[0].trim());
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.setRequestProperty("Authorization", "Bearer " + strings[1]);
            httpsURLConnection.setRequestMethod("GET");

            resultado = inputStreamToString(new BufferedInputStream(httpsURLConnection.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultado;
    }

    private String inputStreamToString(InputStream inputStream){
        String rLine;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        try{
            while ((rLine = br.readLine()) != null){
                sb.append(rLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public interface IApiPeruDev {
        void clienteApiPeruDni(ApiPeruDevData_Dni Cliente);
        void clienteApiPeruRuc(ApiPeruDevData_Ruc Cliente);
    }
}
