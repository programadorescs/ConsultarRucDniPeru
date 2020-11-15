package com.pcs.consultarrucdniperu.accesoapi;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pcs.consultarrucdniperu.entidades.migoapi.MigoApiResult;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetHttpMigoApi extends AsyncTask<String, Void, String> {

    private Context mContexto;
    private ProgressBar progressBar;
    private IMigoApiRuc iMigoApiRuc;

    public GetHttpMigoApi(Context mContexto, ProgressBar progressBar, IMigoApiRuc iMigoApiRuc) {
        this.mContexto = mContexto;
        this.progressBar = progressBar;
        this.iMigoApiRuc = iMigoApiRuc;
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
            MigoApiResult cliente = gson.fromJson(s, MigoApiResult.class);
            if(cliente != null){
                iMigoApiRuc.clienteMigoApiRuc(cliente);
            } else {
                Toast.makeText(mContexto, "NO existen datos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(mContexto, "NO existen datos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        String resultado="";
        try{
            URL url = new URL("https://api.migoperu.pe/api/v1/ruc");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.setRequestMethod("POST");

            JSONObject credencial   = new JSONObject();
            credencial.put("token","832b24ce-d9a6-4797-b75e-53950ba5aada-6974139b-ec3b-4c48-abdd-2df344923966");
            credencial.put("ruc", strings[0]);

            OutputStreamWriter wr = new OutputStreamWriter(httpsURLConnection.getOutputStream());
            wr.write(credencial.toString());
            wr.flush();

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

    public interface IMigoApiRuc {
        void clienteMigoApiRuc(MigoApiResult Cliente);
    }
}
