package com.example.tgarcia.nubay.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tgarcia.nubay.R;
import com.example.tgarcia.nubay.models.ItemCreateModel;

/**
 * Created by tgarcia on 1/14/2015.
 */
public class ItemCreateView extends LinearLayout //implements OnChangeListener<ItemCreateModel>
{
    private TextView nameLabel;
    private TextView descriptionLabel;
    private TextView priceLabel;
    private EditText name;
    private EditText description;
    private EditText price;
    private Button go;

    private ItemCreateModel model;

    public ItemCreateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setModel(ItemCreateModel model)
    {
        this.model = model;
        //subscribe to model
        //model.addListener(onChangeListener);
        //model.addListener(new OnChangeListener<ItemCreateModel>(){
        //  @Override
        //  void onChange()... etc
        //}
    }


    //private ItemCreateModelListener ... etc
    //private static class ItemCreateModelListener implements ONChangeListener<ItemCreateModel>
    //{
    //  @Override ... etc
    //}

    //private void bind(ItemCreateModel model)
    //{
    //    name.setText(model.getName)
    //}
    //private listener ItemCreateModelListener(etc) = new ItemCreateModelListener
    //{
    //@Override
    //OnChange()
    //{
    //  bind();
    //}
    //}

    private ViewListener viewListener;
    public static interface ViewListener//Doesn't this need to be wider scope? was private
    {
        public void onClick(ItemCreateModel model);
    }

    @Override
    protected void onFinishInflate()
    {
        nameLabel = (TextView)findViewById(R.id.item_create_name_label);
        name = (EditText)findViewById(R.id.item_create_name_value);
        go = (Button)findViewById(R.id.item_create_submit_button);
        go.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                viewListener.onClick(model);
            }
        });
    }
}
