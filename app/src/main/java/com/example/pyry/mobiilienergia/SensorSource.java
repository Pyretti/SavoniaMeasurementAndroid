package com.example.pyry.mobiilienergia;

import java.io.Serializable;

/**
 * Created by Osku on 5.11.2015.
 */
public class SensorSource implements Serializable  {


    private String sensorName;
    private String sensorDescription;
    private String sensorTag;
    private String sensorUnit;
    private String sensorValDecCo;

    public SensorSource(String sensorName, String sensorDesc, String sensorTag, String sensorUnit, String sensorValDecCo)
    {
        this.sensorName = sensorName;
        this.sensorDescription = sensorDesc;
        this.sensorTag = sensorTag;
        this.sensorUnit = sensorUnit;
        this.sensorValDecCo = sensorValDecCo;
    }
    /*
    public void setKey(String key)
    {
        this.key = key;
    }
    */
    public void setName(String name)
    {
        this.sensorName = name;
    }
    /*
    public void setDescription(String description)
    {
        this.description = description;
    }


    public String getKey()
    {
        return this.key;
    }
    public String getName()
    {
        return this.name;
    }
    public String getDescription()
    {
        return this.description;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
    */
}
