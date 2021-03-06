package com.example.pyry.mobiilienergia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_SENSOR_KEY = "mobiilienergia.SENSOR_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView mSourceListView = (ListView)findViewById(R.id.measurementSourceListView);

        MeasurementSource[] mSources = new MeasurementSource[]{
                new MeasurementSource("SK101-kuopioenergy", "Kuopion Energia", "Kuopion energian dataa."),
                new MeasurementSource("SK1-tekuenergy", "Savonian lämpötolpat", "Savonian lämpötolppien dataa"),
                new MeasurementSource("SK106-ruokala32r", "Ruokala & Ilmanvaihto", "Ruokalan ja ilmanvaihdon dataa")
        };

        ArrayAdapter<MeasurementSource> mSourceAdapter = new ArrayAdapter<MeasurementSource>(this, android.R.layout.simple_list_item_1, mSources);

        mSourceListView.setAdapter(mSourceAdapter);


        mSourceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MeasurementSource selectedMSource = (MeasurementSource)mSourceListView.getItemAtPosition(position);

                openSensorsActivity(selectedMSource);
            }
        });
    }

    private void openSensorsActivity(MeasurementSource measurementSource)
    {
       // Intent sensorIntent = new Intent(this, SensorsActivity.class);
        Intent sensorIntent = new Intent(this, startdisplay.class);
        //sensorIntent.putExtra(EXTRA_SENSOR_KEY, measurementSource);
        startActivity(sensorIntent);
    }
    //Tervehdys vaan, tuliko perille?
}
