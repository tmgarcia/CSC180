package com.example.tgarcia.nubay.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tgarcia.nubay.Utilities.ItemListArrayAdapter;
import com.example.tgarcia.nubay.R;
import com.example.tgarcia.nubay.models.Item;
import com.example.tgarcia.nubay.models.SearchModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by tgarcia on 1/26/2015.
 */
public class SearchView extends LinearLayout
{
    private SearchModel model;
    private ListView searchResults;
    private EditText searchInput;

    private ItemListArrayAdapter adapter;

    private SearchModelObserver modelObserver;
    private class SearchModelObserver implements Observer
    {
        @Override
        public void update(Observable observable, Object data)
        {
            updateDisplay();
        }
    }

    public SearchView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        modelObserver = new SearchModelObserver();
    }

    public void setModel(SearchModel model)
    {
        this.model = model;
        model.addObserver(modelObserver);
        ArrayList<Item> itemsAsList = new ArrayList<Item>(model.getItems());
        adapter = new ItemListArrayAdapter(getContext(),itemsAsList);
        searchResults.setAdapter(adapter);
        updateDisplay();
    }

    private ViewListener viewListener;
    public static interface ViewListener
    {
        //public void onClick(ItemDetailModel model);
        public void onItemClick(Item clickedItem);
        public void onSearchTyped(CharSequence query);
    }

    public void setViewListener(ViewListener listener)
    {
        viewListener = listener;
    }

    private void updateDisplay()
    {
        adapter.clear();
        for(Item i : model.getItems())
        {
            adapter.add(i);
        }
    }

    @Override
    protected void onFinishInflate()
    {
        searchResults = (ListView)findViewById(R.id.item_search_list);
        searchResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
            {
                final Item item = (Item) parent.getItemAtPosition(position);
                viewListener.onItemClick(item);
            }
        });
        searchInput = (EditText)findViewById(R.id.item_search_input);
        searchInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if(actionId == EditorInfo.IME_ACTION_SEARCH)
                {
                    handled = true;
                    CharSequence query = v.getText();
                    viewListener.onSearchTyped(query);
                }
                return handled;
            }
        });
    }
}
