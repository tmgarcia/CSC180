package com.example.tgarcia.nubay.models;

import android.graphics.drawable.Drawable;

import java.util.Observable;

/**
 * Created by tgarcia on 1/13/2015.
 */
public class ItemDetailModel extends Observable
{
    private int id;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
        setChanged();
        notifyObservers(this);
    }

    private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
        setChanged();
        notifyObservers(this);
    }

    private String shortDescription;
    public String getShortDescription()
    {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription)
    {
        this.shortDescription = shortDescription;
        setChanged();
        notifyObservers(this);
    }

    private String longDescription;
    public String getLongDescription()
    {
        return longDescription;
    }
    public void setLongDescription(String longDescription)
    {
        this.longDescription = longDescription;
        setChanged();
        notifyObservers(this);
    }

    private float currentBid;
    public float getCurrentBid()
    {
        return currentBid;
    }
    public void setCurrentBid(float currentBid)
    {
        this.currentBid = currentBid;
        setChanged();
        notifyObservers(this);
    }


}
