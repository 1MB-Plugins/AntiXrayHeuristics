package com.greymagic27.event;

import java.util.Locale;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class EventItemDrag implements Listener {

    @EventHandler
    public void dragEv(@NonNull InventoryDragEvent e) {
        String title = PlainTextComponentSerializer.plainText().serialize(e.getView().title());
        if (title.toLowerCase(Locale.ROOT).startsWith("Xrayer".toLowerCase(Locale.ROOT))) {
            e.setCancelled(true);
        }
    }
}
