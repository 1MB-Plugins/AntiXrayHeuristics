//--------------------------------------------------------------------
// Copyright © Dylan Calaf Latham 2019-2021 AntiXrayHeuristics
//--------------------------------------------------------------------

package com.greymagic27.event;

import com.greymagic27.AntiXrayHeuristics;
import com.greymagic27.util.MiningSession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class EventPlayerChangedWorld implements Listener {

    private final AntiXrayHeuristics mainClassAccess;

    public EventPlayerChangedWorld(AntiXrayHeuristics main) {
        this.mainClassAccess = main;
    }

    @EventHandler
    public void PlayerChangedWorldEvent(@NonNull PlayerChangedWorldEvent e) //This event cleans the mining trail, and previous mined ore data, when switching worlds (avoids errors)
    {
        MiningSession session = mainClassAccess.sessions.get(e.getPlayer().getName());
        if (session != null) { //Checking the player who switched worlds actually has a mining session.
            session.SetLastMinedOreData(null, null);
            session.ResetBlocksTrailArray();
            session.ResetBlockCoordsStoreCounter();
        }
    }
}
