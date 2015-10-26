package com.example.pyry.mobiilienergia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SensorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        MeasurementSource mSource = (MeasurementSource) getIntent().getSerializableExtra(MainActivity.EXTRA_SENSOR_KEY);

        String sensors = null;
        try {
            sensors = MyDataSource.fetchSensorsJSON(mSource.getKey());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (sensors != null)
        {
            Log.v("Sensors content", sensors);
        }
        else
        {
            Log.v("Sensors content length", "null");
        }
    }
}
