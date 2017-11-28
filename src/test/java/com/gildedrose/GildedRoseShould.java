package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseShould {
    @Test(expected = NullPointerException.class)
    public void not_accept_invalid_list_of_items() {
        GildedRose gildedRose = new GildedRose(null);
        gildedRose.updateQuality();
    }

    @Test
    public void accept_an_empty_list_of_items() {
        Item[] emptyItems = new Item[]{};
        GildedRose gildedRose = new GildedRose(emptyItems);

        gildedRose.updateQuality();
    }

    @Test(expected = NullPointerException.class)
    public void not_accept_list_with_undefined_item() {
        Item[] emptyItems = new Item[]{null};
        GildedRose gildedRose = new GildedRose(emptyItems);

        gildedRose.updateQuality();
    }

    @Test(expected = NullPointerException.class)
    public void not_accept_unnamed_items() {
        Item item = new Item(null, 0, 0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
    }

    @Test
    public void not_changes_the_item_name_when_the_name_is_empty() {
        Item item = new Item("", 0, 0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals("", gildedRose.items[0].name);
    }

    @Test
    public void not_change_the_item_name() {
        Item item = new Item("Bob", 0, 0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals("Bob", gildedRose.items[0].name);
    }

    @Test
    public void not_change_the_quality_when_quality_is_zero() {
        Item item = new Item("Bob", 0, 0);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }
}