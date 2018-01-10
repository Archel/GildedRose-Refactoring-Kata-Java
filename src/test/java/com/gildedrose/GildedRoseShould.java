package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        GildedRose gildedRose = initializeGildedRoseWithItem(null, 3, 49);

        gildedRose.updateQuality();
    }

    @Test
    public void not_changes_the_item_name_when_the_name_is_empty() {
        GildedRose gildedRose = initializeGildedRoseWithItem("", 0, 0);

        gildedRose.updateQuality();

        assertEquals("", gildedRose.items[0].name);
    }

    @Test
    public void not_change_the_item_name() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Bob", 0, 0);

        gildedRose.updateQuality();

        assertEquals("Bob", gildedRose.items[0].name);
    }

    @Test
    public void not_change_the_quality_when_quality_is_zero() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Bob", 0, 0);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void decrease_the_quality_to_zero_when_quality_is_one() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Bob", 0, 1);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void decreases_a_quality_by_two_when_quality_is_over_one() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Bob", 0, 2);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void decrease_sellIn_by_one_when_sellIn_is_zero() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Bob", 0, 0);

        gildedRose.updateQuality();

        assertEquals(-1, gildedRose.items[0].sellIn);
    }

    @Test
    public void not_change_the_sell_in_for_sulfuras_hand_of_ragnaros() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Sulfuras, Hand of Ragnaros", 2, 0);

        gildedRose.updateQuality();

        assertEquals(2, gildedRose.items[0].sellIn);
    }

    @Test
    public void not_change_the_quality_in_for_sulfuras_hand_of_ragnaros() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Sulfuras, Hand of Ragnaros", 0, 54);

        gildedRose.updateQuality();

        assertEquals(54, gildedRose.items[0].quality);
    }

    @Test
    public void increase_by_two_the_quality_of_aged_brie_when_the_quality_is_below_fifty() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Aged Brie", 0, -1);

        gildedRose.updateQuality();

        assertEquals(1, gildedRose.items[0].quality);
    }

    @Test
    public void not_change_the_quality_of_aged_brie_when_the_quality_is_above_fifty() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Aged Brie", 0, 50);

        gildedRose.updateQuality();

        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void increase_the_quality_by_two_for_backstage_passes_when_sell_in_is_less_than_eleven_and_more_than_six() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Backstage passes to a TAFKAL80ETC concert", 10, 30);

        gildedRose.updateQuality();

        assertEquals(32, gildedRose.items[0].quality);
    }

    @Test
    public void increase_the_quality_by_three_for_backstage_passes_when_sell_in_is_less_than_six() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Backstage passes to a TAFKAL80ETC concert", 5, 30);

        gildedRose.updateQuality();

        assertEquals(33, gildedRose.items[0].quality);
    }

    @Test
    public void
    don_t_increase_the_quality_of_backstage_passes_over_the_maximum_quality_value() {
        GildedRose gildedRose = initializeGildedRoseWithItem("Backstage passes to a TAFKAL80ETC concert", 3, 49);

        gildedRose.updateQuality();

        assertEquals(50, gildedRose.items[0].quality);
    }

    private GildedRose initializeGildedRoseWithItem(String name, int sellIn, int quality) {
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }
}