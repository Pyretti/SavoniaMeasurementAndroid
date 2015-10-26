package com.example.pyry.mobiilienergia;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Pyry on 21.10.2015.
 */
public class RetrieveSensorsTask extends AsyncTask<String, Void, String> {
    // move to settings and make changeable
    public static final String DB_URL = "http://localhost/MobiiliEnergia/public_html/";

    ProgressDialog progressDialog;

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();

    }



    @Override
    protected String doInBackground(String... params) {
        URL url = null;
        try
        {
            url = new URL(DB_URL + "?key=SK1-tekuenergy");

        }
        catch(Exception e)
        {
            Log.e("URL Error: ", e.getMessage());
        }

        Log.v("getSensors url: ", url.toString());
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(url.openStream()) // räjähtää tähän
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputLine;
        String contents = "";

        try {
            while ((inputLine = br.readLine()) != null)
            {
                contents += inputLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contents;
    }

    /*

    public static String getSensors(String key) throws IOException {
        URL url = null;
        try
        {
            url = new URL(DB_URL + "?key=" + key);

        }
        catch(Exception e)
        {
            Log.e("URL Error: ", e.getMessage());
        }

        Log.v("getSensors url: ", url.toString());
        BufferedReader br = new BufferedReader(
                new InputStreamReader(url.openStream()) // räjähtää tähän
        );
        String inputLine;
        String contents = "";

        while ((inputLine = br.readLine()) != null)
        {
            contents += inputLine;
        }

        return contents;
    }

  */
}
