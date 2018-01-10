package com.gildedrose;

import com.gildedrose.services.AgedBrieUpdater;
import com.gildedrose.services.BackstagePassesUpdater;
import com.gildedrose.services.LegendaryItemsUpdater;
import com.gildedrose.services.VanillaItemUpdater;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

class GildedRose {
    private final Map<String, VanillaItemUpdater> updaters;
    private final VanillaItemUpdater vanillaUpdater = new VanillaItemUpdater();
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;

        updaters = Map.ofEntries(
                entry("Aged Brie", new AgedBrieUpdater()),
                entry("Sulfuras, Hand of Ragnaros", new LegendaryItemsUpdater()),
                entry("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesUpdater())
        );
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name == null) {
                throw new NullPointerException();
            }

            this.updaters.getOrDefault(item.name, vanillaUpdater).update(item);
        }
    }
}