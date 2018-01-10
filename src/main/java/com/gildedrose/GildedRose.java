package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                updateItemSellIn(item);
            }

            if (item.name.equals("Aged Brie") && item.quality < 50) {
                increaseQuality(item);
            }

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.quality < 50) {
                increaseQuality(item);

                if (item.sellIn < 10 && item.quality < 50) {
                    increaseQuality(item);
                }

                if (item.sellIn < 5 && item.quality < 50) {
                    increaseQuality(item);
                }
            }

            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !item.name.equals("Sulfuras, Hand of Ragnaros")
                    && item.quality > 0
            ) {
                decreaseQuality(item);
            }

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    if (item.quality < 50) {
                        increaseQuality(item);
                    }
                } else {
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(item);
                            }
                        }
                    }
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        updateProductQuality(item, -1);
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