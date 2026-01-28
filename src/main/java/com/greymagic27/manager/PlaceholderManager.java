package com.greymagic27.manager;

import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.jetbrains.annotations.Contract;

@SuppressWarnings("unused")
public class PlaceholderManager {

    private static final LegacyComponentSerializer legacySerializer = LegacyComponentSerializer.legacyAmpersand();

    public static @NonNull String SubstitutePlayerNameAndColorCodePlaceholders(String toReplace, String player) {
        toReplace = toReplace.replace("{PlayerName}", player);
        Component component = legacySerializer.deserialize(toReplace);
        return legacySerializer.serialize(component);
    }

    public static @NonNull String SubstitutePlayerNameAndHandleTimesPlaceholders(String toReplace, String player, String handleTimes) {
        toReplace = toReplace.replace("{PlayerName}", player);
        toReplace = toReplace.replace("{TimesDetected}", handleTimes);
        Component component = legacySerializer.deserialize(toReplace);
        return legacySerializer.serialize(component);
    }

    public static @NonNull String SubstituteColorCodePlaceholders(String toReplace) {
        Component component = legacySerializer.deserialize(toReplace);
        return legacySerializer.serialize(component);
    }

    @Contract("_ -> param1")
    public static @NonNull List<String> SubstituteColorCodePlaceholders(@NonNull List<String> toReplace) {
        toReplace.replaceAll(text -> {
            Component component = legacySerializer.deserialize(text);
            return legacySerializer.serialize(component);
        });
        return toReplace;
    }

    public static @NonNull String SubstituteXrayerSlotAndColorCodePlaceholders(String toReplace, int slot) {
        toReplace = toReplace.replace("{Slot}", Integer.toString(slot));
        Component component = legacySerializer.deserialize(toReplace);
        return legacySerializer.serialize(component);
    }

    public static List<String> SubstituteXrayerDataAndColorCodePlaceholders(@NonNull List<String> toReplace, String handledTimesAmount, String firstHandleTime, String lastSeenTime) {
        for (int i = 0; i < toReplace.size(); i++) {
            String line = toReplace.get(i);
            line = line.replace("{HandledTimesAmount}", handledTimesAmount);
            line = line.replace("{FirstTimeDetected}", firstHandleTime);
            line = line.replace("{LastSeenTime}", lastSeenTime);
            Component component = legacySerializer.deserialize(line);
            toReplace.set(i, legacySerializer.serialize(component));
        }
        return toReplace;
    }
}