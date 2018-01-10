package com.gildedrose.services;

import com.gildedrose.Item;

public class VanillaItemUpdater {
    private Item item;

    public VanillaItemUpdater(Item item) {
        this.item = item;
    }

    public void invoke() {
        updateItemSellIn(item);
        if (item.quality > 0) {
            decreaseQuality(item);
        }

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        updateProductQuality(item, -1);
    }

    private void updateItemSellIn(Item item) {
        item.sellIn -= 1;
    }

    private void updateProductQuality(Item item, int i) {
        item.quality += i;
    }
}