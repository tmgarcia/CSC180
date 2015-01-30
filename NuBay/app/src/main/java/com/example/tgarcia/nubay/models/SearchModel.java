package com.example.tgarcia.nubay.models;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 * Created by tgarcia on 1/26/2015.
 */
public class SearchModel extends Observable
{
    public SearchModel()
    {
        items = new HashSet<Item>();
    }

    private Set<Item> items;
    public Set<Item> getItems() {return items;}
    public void setItems(Set<Item> items)
    {
        this.items = items;
        setChanged();
        notifyObservers(this);
    }
}
