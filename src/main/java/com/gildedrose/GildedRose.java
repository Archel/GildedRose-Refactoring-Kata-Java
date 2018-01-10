package com.gildedrose;

import com.gildedrose.services.VanillaItemUpdater;

class GildedRose {
    public static final int MAX_ITEM_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    updateItemSellIn(item);

                    if (item.quality < MAX_ITEM_QUALITY) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 0 && item.quality < MAX_ITEM_QUALITY) {
                        increaseQuality(item);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
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
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    new VanillaItemUpdater(item).invoke();
                    break;
            }
        }
    }

    private void increaseQuality(Item item) {
        updateProductQuality(item, 1);
    }

    private void updateProductQuality(Item item, int i) {
        item.quality += i;
    }

    private void updateItemSellIn(Item item) {
        item.sellIn -= 1;
    }
}