package com.greymagic27.callback;

import org.bukkit.inventory.ItemStack;

public interface CallbackGetXrayerBelongings {
    void onQueryDone(ItemStack[] belongings);
}