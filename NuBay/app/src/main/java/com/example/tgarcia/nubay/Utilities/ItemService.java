package com.example.tgarcia.nubay.Utilities;

import com.example.tgarcia.nubay.R;
import com.example.tgarcia.nubay.models.Item;
import com.example.tgarcia.nubay.models.ItemDetailModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by tgarcia on 1/26/2015.
 */
public class ItemService
{
    public static HashSet<Item> items;
    private ItemSearchPredicateBuilder predicateBuilder;
    public ItemService()
    {
        if(items == null)
        {
            items = new HashSet<>();
            Item item1 = new Item(1, "Great Toaster", R.drawable.imagedetail, "A truly great toaster.", "This advanced, top of the line toaster will toast your toast faster than we could realistically boast.", 1.0f);
            Item item2 = new Item(2, "Great Hamster", R.drawable.imagedetail, "A hamster descended from royalty.", "When was the last time your pet was heir to a throne? Never? Well this one is next in line to be king of Hamsters.", 1.0f);
            Item item3 = new Item(3, "Great Coaster", R.drawable.imagedetail, "A coaster.", "No one knows what makes a great coaster, but this one provides a place for your drink and it does it well. So it's pretty great.", 1.0f);
            Item item4 = new Item(4, "Bad Toaster", R.drawable.imagedetail, "This is actually a really awful toaster.", "This toaster is bad. Really bad. Please take it I don't want it.", 1.0f);
            Item item5 = new Item(5, "Bad Hamster", R.drawable.imagedetail, "Peasant hamster.", "This hamster has too much hair, it eats too much, I think it might be sick.", 1.0f);
            Item item6 = new Item(6, "Bad Coaster", R.drawable.imagedetail, "A coaster.", "Yes, you can have a defective coaster. This one actually spills your drinks for you. It makes a great prank gift?", 1.0f);
            items.add(item1);
            items.add(item2);
            items.add(item3);
            items.add(item4);
            items.add(item5);
            items.add(item6);
        }
        predicateBuilder = new ItemSearchPredicateBuilder();
    }

    public Set<Item> search(CharSequence query)
    {
        String queryString = query.toString();
        CollectionUtils.Predicate searchPredicate =  predicateBuilder.buildPredicate(queryString);
        List<Item> itemsList = new ArrayList<Item>();
        itemsList.addAll(items);
        Set<Item> results = new HashSet<Item>();
        results.addAll(CollectionUtils.filter(itemsList, searchPredicate));
        return results;
    }

    public Item getItemByID(int id)
    {
        boolean foundItem = false;
        Item i = null;
        Iterator<Item> itemsIterator = items.iterator();
        while(itemsIterator.hasNext() && ! foundItem)
        {
            Item temp = itemsIterator.next();
            if(temp.getId() == id)
            {
                i = temp;
                foundItem = true;
            }
        }
        return i;
    }


    public Item bid(Long id, BigDecimal bidIncrease)
    {
        Item item = getItemByID(id.intValue());
        item.setCurrentBid(item.getCurrentBid() + bidIncrease.floatValue());
        return item;
    }
}
