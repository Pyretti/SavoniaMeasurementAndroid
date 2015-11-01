package com.example.pyry.mobiilienergia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class startdisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startdisplay);
    }

    // Näyttää tekun sensorin
    public void OnTekuBtPressed(View v)
    {
        Intent intent = new Intent(this, tekugraphs.class);
        intent.putExtra("key", "SK1-tekuenergy");
        intent.putExtra("desc","Näyttää TeKun käyrät");
        intent.putExtra("name","Opistotie 2");
        startActivity(intent);
    }

    // Näyttää Kuopion Energian sensorit
    public void OnKeyBtPressed(View v)
    {
       Intent intent = new Intent(this, tekugraphs.class);
       intent.putExtra("key", "SK101-kuopioenergy");
        intent.putExtra("desc","Näyttää Kuopion Energian graafit");
        intent.putExtra("name","Kuopion Energia");
       startActivity(intent);
    }
}
