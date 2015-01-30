package com.example.tgarcia.nubay.Utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tgarcia.nubay.R;
import com.example.tgarcia.nubay.models.Item;

import java.util.List;

/**
 * Created by tgarcia on 1/28/2015.
 */
public class ItemListArrayAdapter extends ArrayAdapter<Item>
{
    private final Context context;
    private final List<Item> items;

    public ItemListArrayAdapter(Context context, List<Item> items)
    {
        super(context, R.layout.item_row, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemRow = inflater.inflate(R.layout.item_row, parent, false);
        ImageView itemIcon = (ImageView)itemRow.findViewById(R.id.item_row_icon);
        TextView itemName = (TextView)itemRow.findViewById(R.id.item_row_name);
        TextView itemPrice = (TextView)itemRow.findViewById(R.id.item_row_price);

        Item item = items.get(position);

        itemIcon.setImageResource(item.getImageResource());
        itemName.setText(item.getName());
        itemPrice.setText("$"+item.getCurrentBid());

        return itemRow;
    }
}
