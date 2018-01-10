package com.gildedrose.services;

import com.gildedrose.Item;

public class AgedBrieUpdater extends VanillaItemUpdater {
    private static final int MAX_ITEM_QUALITY = 50;

    public AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        updateItemSellIn(item);

        if (item.quality < MAX_ITEM_QUALITY) {
            increaseQuality(item);
        }

        if (item.sellIn < 0 && item.quality < MAX_ITEM_QUALITY) {
            increaseQuality(item);
        }
    }
}
