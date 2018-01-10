package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    updateItemSellIn(item);
                    if (item.quality < 50) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 0 && item.quality < 50) {
                        increaseQuality(item);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateItemSellIn(item);
                    if (item.quality < 50) {
                        increaseQuality(item);

                        if (item.sellIn < 10 && item.quality < 50) {
                            increaseQuality(item);
                        }

                        if (item.sellIn < 5 && item.quality < 50) {
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
                    updateItemSellIn(item);
                    if (item.quality > 0) {
                        decreaseQuality(item);
                    }

                    if (item.sellIn < 0 && item.quality > 0) {
                        decreaseQuality(item);
                    }

                    break;
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