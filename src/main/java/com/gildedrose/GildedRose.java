package com.gildedrose;

import com.gildedrose.services.AgedBrieUpdater;
import com.gildedrose.services.BackstagePassesUpdater;
import com.gildedrose.services.LegendaryItemsUpdater;
import com.gildedrose.services.VanillaItemUpdater;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    new AgedBrieUpdater().update(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    new BackstagePassesUpdater().update(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    new LegendaryItemsUpdater().update(item);
                    break;
                default:
                    new VanillaItemUpdater().update(item);
                    break;
            }
        }
    }
}