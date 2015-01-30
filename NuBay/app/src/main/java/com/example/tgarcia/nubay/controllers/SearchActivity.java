package com.example.tgarcia.nubay.controllers;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tgarcia.nubay.Utilities.ItemService;
import com.example.tgarcia.nubay.R;
import com.example.tgarcia.nubay.models.Item;
import com.example.tgarcia.nubay.models.ItemDetailModel;
import com.example.tgarcia.nubay.models.SearchModel;
import com.example.tgarcia.nubay.views.ItemDetailView;
import com.example.tgarcia.nubay.views.SearchView;

import java.util.Set;

public class SearchActivity extends ActionBarActivity
{
    private ItemService service;
    private SearchModel model;
    private SearchView.ViewListener listener = new SearchView.ViewListener() {
        @Override
        public void onItemClick(Item clickedItem)
        {
            onSelect(clickedItem);
        }

        @Override
        public void onSearchTyped(CharSequence query)
        {
            onSearch(query);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        service = new ItemService();
        model = new SearchModel();
        SearchView view = (SearchView) View.inflate(getApplicationContext(), R.layout.activity_search, null);
        view.setModel(model);
        view.setViewListener(listener);
        setContentView(view);
        setTitle("Item Search");
    }

    public void onSearch(CharSequence query)
    {
        Set<Item> results = service.search(query);
        model.setItems(results);
    }

    public void onSelect(Item selected)
    {
        Intent itemActivity = new Intent(this, ItemDetailActivity.class);
        itemActivity.putExtra("ItemID",selected.getId());
        SearchActivity.this.startActivity(itemActivity);
    }
}
