package com.gildedrose.services;

import com.gildedrose.Item;

public class AgedBrieUpdater extends VanillaItemUpdater {
    @Override
    public void update(Item item) {
        updateItemSellIn(item);

        if (item.quality < MAX_ITEM_QUALITY) {
            increaseQuality(item);
        }

        if (item.sellIn < 0 && item.quality < MAX_ITEM_QUALITY) {
            increaseQuality(item);
        }
    }
}
