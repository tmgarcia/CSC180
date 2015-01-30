package com.example.tgarcia.nubay.controllers;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tgarcia.nubay.R;
import com.example.tgarcia.nubay.models.ItemCreateModel;
import com.example.tgarcia.nubay.views.ItemCreateView;

public class ItemCreateActivity extends ActionBarActivity
{

    private ItemCreateModel model = new ItemCreateModel();

    private ItemCreateView.ViewListener listener = new ItemCreateView.ViewListener()
    {

        @Override
        public void onClick(ItemCreateModel model) {
            //persists auction item etc
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //how to make the view (null = view group)
        ItemCreateView view = (ItemCreateView)View.inflate(getApplicationContext(), R.layout.activity_item_create, null);
        view.setModel(model);
        //Need controller to listen to view?
        setContentView(view);

    }


}
