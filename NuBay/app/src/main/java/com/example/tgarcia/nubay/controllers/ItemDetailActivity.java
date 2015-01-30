package com.example.tgarcia.nubay.controllers;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tgarcia.nubay.R;
import com.example.tgarcia.nubay.Utilities.ItemSearchPredicateBuilder;
import com.example.tgarcia.nubay.Utilities.ItemService;
import com.example.tgarcia.nubay.models.Item;
import com.example.tgarcia.nubay.models.ItemCreateModel;
import com.example.tgarcia.nubay.models.ItemDetailModel;
import com.example.tgarcia.nubay.views.ItemCreateView;
import com.example.tgarcia.nubay.views.ItemDetailView;

import java.math.BigDecimal;


public class ItemDetailActivity extends ActionBarActivity
{
    private ItemDetailModel model = new ItemDetailModel();
    private ItemService service;
    private BigDecimal bidIncrement = BigDecimal.ONE;

    private ItemDetailView.ViewListener listener = new ItemDetailView.ViewListener()
    {
        @Override
        public void onClick(ItemDetailModel model)
        {
            service.bid(new Long((long)model.getId()), bidIncrement);
        }
    };

    protected void setupDefaultItemDetailModel()
    {
        model.setId(3);
        model.setName("Toaster");
        model.setCurrentBid(1.0f);
        model.setShortDescription("A toaster.");
        model.setLongDescription("Woah! A toaster! I can't believe it's a toaster!");
    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        service = new ItemService();
        ItemDetailView view = (ItemDetailView) View.inflate(getApplicationContext(), R.layout.activity_item_detail, null);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            int itemID = extras.getInt("ItemID");
            Item item = service.getItemByID(itemID);
            model = item.toItemDetailModel();
        }
        else
        {
            setupDefaultItemDetailModel();
        }
        view.setModel(model);
        view.setViewListener(listener);
        setContentView(view);
        setTitle(model.getName());
    }
}
