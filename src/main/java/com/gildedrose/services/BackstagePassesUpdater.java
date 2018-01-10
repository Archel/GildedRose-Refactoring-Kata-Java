package com.gildedrose.services;

import com.gildedrose.Item;

public class BackstagePassesUpdater extends VanillaItemUpdater {

    @Override
    public void update(Item item) {
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
