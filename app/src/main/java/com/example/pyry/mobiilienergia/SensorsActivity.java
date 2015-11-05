package com.example.pyry.mobiilienergia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SensorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        SensorSource[] mSensors;
        final ListView mSensorsListView = (ListView)findViewById(R.id.SensorSourceListView);

        JSONArray SensorsArray = null;
        MeasurementSource mSource = (MeasurementSource) getIntent().getSerializableExtra(MainActivity.EXTRA_SENSOR_KEY);

        String sensorString = null;
        try {
            sensorString = MyDataSource.fetchSensorsJSON(mSource.getKey());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (sensorString != null)
        {
            //Log.v("Sensors content", sensorString);
            try
            {
                JSONObject sensorObj = new JSONObject(sensorString);

               SensorsArray = sensorObj.getJSONArray("name");
                for (int i = 0; i < SensorsArray.length(); i++)
                {
                    JSONObject o = SensorsArray.getJSONObject(i);
                    String SensorName = o.getString("name");
                    String SensorDesc = o.getString("description");
                    String SensorTag = o.getString("tag");
                    String SensorUnit = o.getString("unit");
                    String SensorValDecCo = o.getString("valueDecimalCount");

                    mSensors = new SensorSource[]{
                            new SensorSource(SensorName,SensorDesc, SensorTag, SensorUnit, SensorValDecCo )
                    };
                }

                ArrayAdapter<MeasurementSource> mSourceAdapter = new ArrayAdapter<MeasurementSource>(this, android.R.layout.simple_list_item_1, mSensors);

                mSensorsListView.setAdapter(mSourceAdapter);


                mSensorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        MeasurementSource selectedMSource = (MeasurementSource)mSensorsListView.getItemAtPosition(position);

                        //openSensorsActivity(selectedMSource);
                    }
                });

            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            Log.v("Sensors content length", "null");
        }
    }
}
