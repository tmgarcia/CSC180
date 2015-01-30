package com.example.tgarcia.nubay.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tgarcia.nubay.R;
import com.example.tgarcia.nubay.models.ItemDetailModel;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by tgarcia on 1/13/2015.
 */
public class ItemDetailView extends LinearLayout
{
    private ImageView itemImage;
    private TextView longDescription;
    private TextView currentPrice;
    private Button bidButton;

    private ItemDetailModel model;

    private DecimalFormat moneyFormatter = new DecimalFormat();

    public ItemDetailView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        modelObserver = new ItemDetailModelObserver();
        moneyFormatter = new DecimalFormat("0");
    }

    public void setModel(ItemDetailModel model)
    {
        this.model = model;
        model.addObserver(modelObserver);
        updateDisplayValues();
    }

    private void updateDisplayValues()
    {
        longDescription.setText(model.getLongDescription());
        String newPriceText = moneyFormatter.format(model.getCurrentBid());
        currentPrice.setText("$" + newPriceText);
        itemImage.setContentDescription(model.getShortDescription());
    }

    private ItemDetailModelObserver modelObserver;
    private class ItemDetailModelObserver implements Observer
    {
        @Override
        public void update(Observable observable, Object data)
        {
            updateDisplayValues();
        }
    }

    private ViewListener viewListener;
    public static interface ViewListener
    {
        public void onClick(ItemDetailModel model);
    }

    public void setViewListener(ViewListener listener)
    {
        viewListener = listener;
    }

    @Override
    protected void onFinishInflate()
    {
        itemImage = (ImageView)findViewById(R.id.item_detail_image);
        longDescription = (TextView)findViewById(R.id.item_detail_longDescription);
        currentPrice = (TextView)findViewById(R.id.item_detail_currentPrice);
        bidButton = (Button)findViewById(R.id.item_detail_bidButton);
        bidButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                viewListener.onClick(model);
            }
        });
    }
}
