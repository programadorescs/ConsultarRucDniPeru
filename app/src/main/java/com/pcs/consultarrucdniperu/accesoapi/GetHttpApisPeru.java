package com.pcs.consultarrucdniperu.accesoapi;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pcs.consultarrucdniperu.entidades.apisperu.ApisPeru_Dni;
import com.pcs.consultarrucdniperu.entidades.apisperu.ApisPeru_Ruc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetHttpApisPeru extends AsyncTask<String, Void, String> {
    private Context mContexto;
    private ProgressBar progressBar;
    private IApisPeru iApisPeru;
    private static String tipoDoc="";

    public GetHttpApisPeru(Context mContexto, ProgressBar progressBar, IApisPeru iApisPeru) {
        this.mContexto = mContexto;
        this.progressBar = progressBar;
        this.iApisPeru = iApisPeru;
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
                ApisPeru_Ruc oEntidad = gson.fromJson(s, ApisPeru_Ruc.class);
                iApisPeru.obtenerRuc(oEntidad);
            } else{
                ApisPeru_Dni oEntidad = gson.fromJson(s, ApisPeru_Dni.class);
                iApisPeru.obtenerDni(oEntidad);
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
            URL url=null;

            if(strings[0].trim().length() == 11)
                url = new URL("https://dniruc.apisperu.com/api/v1/ruc/" + strings[0].trim() + "?token=" + strings[1]);
            else
                url = new URL("https://dniruc.apisperu.com/api/v1/dni/" + strings[0].trim() + "?token=" + strings[1]);
            HttpURLConnection httpsURLConnection = (HttpURLConnection)url.openConnection();
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
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

    public interface IApisPeru{
        void obtenerRuc(ApisPeru_Ruc oEntidad);
        void obtenerDni(ApisPeru_Dni oEntidad);
    }
}
