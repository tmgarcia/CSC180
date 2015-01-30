package com.example.tgarcia.nubay;
import com.example.tgarcia.nubay.Utilities.ItemService;
import com.example.tgarcia.nubay.models.Item;

import junit.framework.TestCase;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by tgarcia on 1/30/2015.
 */
public class testItemService extends TestCase
{
    public void testSearch()
    {
        ItemService service = new ItemService();
        Set<Item> results = service.search("toaster");
        assertTrue(results.contains(service.getItemByID(1)) && results.contains(service.getItemByID(4)));
    }
    public void testSearchAnd()
    {
        ItemService service = new ItemService();
        Set<Item> results = service.search("great and toaster");
        assertTrue(results.contains(service.getItemByID(1)) && !results.contains(service.getItemByID(4)));
    }
    public void testSearchOr()
    {
        ItemService service = new ItemService();
        Set<Item> results = service.search("great and toaster or bad and toaster");
        assertTrue(results.contains(service.getItemByID(1)) && results.contains(service.getItemByID(4)));
    }
    public void testBid()
    {
        ItemService service = new ItemService();
        Long itemId = new Long(1);
        Item item = service.getItemByID(itemId.intValue());
        float originalBid = item.getCurrentBid();
        BigDecimal bidIncrease = new BigDecimal(4);
        service.bid(itemId, bidIncrease);
        assertEquals(item.getCurrentBid(), originalBid+bidIncrease.floatValue());
    }
}
