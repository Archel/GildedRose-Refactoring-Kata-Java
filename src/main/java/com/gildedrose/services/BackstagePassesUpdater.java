package com.gildedrose.services;

import com.gildedrose.Item;

public class BackstagePassesUpdater extends VanillaItemUpdater {

    private static final int MAX_ITEM_QUALITY = 50;

    public BackstagePassesUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        updateItemSellIn(item);
        if (item.quality < MAX_ITEM_QUALITY) {
            increaseQuality(item);

            if (item.sellIn < 10 && item.quality < MAX_ITEM_QUALITY) {
                increaseQuality(item);
            }

            if (item.sellIn < 5 && item.quality < MAX_ITEM_QUALITY) {
                increaseQuality(item);
            }
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
