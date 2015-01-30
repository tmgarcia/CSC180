package com.example.tgarcia.nubay.models;

/**
 * Created by tgarcia on 1/26/2015.
 */
public class Item
{

    public Item()
   {

   }
    public Item(int id, String name, int imageResource, String shortDescription, String longDescription, float currentBid)
    {
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.currentBid = currentBid;
    }

    public ItemDetailModel toItemDetailModel()
    {
        ItemDetailModel detail = new ItemDetailModel();
        detail.setId(this.id);
        detail.setShortDescription(this.shortDescription);
        detail.setLongDescription(this.longDescription);
        detail.setCurrentBid(this.currentBid);
        return detail;
    }

    private int id;
    public int getId() {return id;}
    public void setId(int value) {
        id = value;
    }

    private String name;
    public String getName() {return name;}
    public void setName(String value)
    {
        name = value;
    }

    private int imageResource;
    public int getImageResource(){return imageResource;}
    public void setImageResource(int value)
    {
        imageResource = value;
    }

    private String shortDescription;
    public String getShortDescription(){return shortDescription;}
    public void setShortDescription(String value)
    {
        shortDescription = value;
    }

    private String longDescription;
    public String getLongDescription(){return longDescription;}
    public void setLongDescription(String value)
    {
        longDescription = value;
    }

    private float currentBid;
    public float getCurrentBid(){return currentBid;}
    public void setCurrentBid(float value)
    {
        currentBid = value;
    }
}
