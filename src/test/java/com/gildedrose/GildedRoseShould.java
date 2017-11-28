package com.gildedrose;

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
}