package com.example.pyry.mobiilienergia;

/**
 * Created by Pyry on 21.10.2015.
 */
public class Sensor {
    private String name;
    private String tag;

    public Sensor()
    {

    }

    public Sensor(String name)
    {
        this.name = name;
    }

    public Sensor(String name, String tag)
    {
        this.name = name;
        this.tag = tag;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public String getName()
    {
        return this.name;
    }


}
