package com.gildedrose.services;

import com.gildedrose.Item;

public class VanillaItemUpdater {
    protected Item item;

    public VanillaItemUpdater(Item item) {
        this.item = item;
    }

    public void update() {
        updateItemSellIn(item);
        if (item.quality > 0) {
            decreaseQuality(item);
        }

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality(item);
        }
    }

    protected void decreaseQuality(Item item) {
        updateProductQuality(item, -1);
    }

    protected void updateItemSellIn(Item item) {
        item.sellIn -= 1;
    }

    protected void updateProductQuality(Item item, int i) {
        item.quality += i;
    }

    protected void increaseQuality(Item item) {
        updateProductQuality(item, 1);
    }
}