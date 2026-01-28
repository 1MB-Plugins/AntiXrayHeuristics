//--------------------------------------------------------------------
// Copyright © Dylan Calaf Latham 2019-2021 AntiXrayHeuristics
//--------------------------------------------------------------------

package com.greymagic27.api;

public interface APIAntiXrayHeuristics {

    //Declares specified player as an Xrayer and does configured handling
    @SuppressWarnings("unused")
    void Xrayer(String xrayername);

    //Purges the specified player from vault
    @SuppressWarnings("unused")
    void PurgePlayer(String playerName);

    //Absolves a player with absolution handling and removes from the player's vault registry
    @SuppressWarnings("unused")
    void AbsolvePlayer(String playerName);
}