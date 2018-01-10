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

            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(item);
                    }
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 10) {
                            if (item.quality < 50) {
                                increaseQuality(item);
                            }
                        }

                        if (item.sellIn < 5) {
                            if (item.quality < 50) {
                                increaseQuality(item);
                            }
                        }
                    }
                }
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(item);
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        increaseQuality(item);
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
        item.quality = item.quality + i;
    }

    private void updateItemSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}