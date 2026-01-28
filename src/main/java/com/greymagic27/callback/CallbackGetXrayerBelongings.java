package com.greymagic27.callback;

import org.bukkit.inventory.ItemStack;

interface CallbackGetXrayerBelongings {
    void onQueryDone(ItemStack[] belongings);
}