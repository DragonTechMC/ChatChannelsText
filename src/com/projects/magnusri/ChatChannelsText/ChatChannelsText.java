package com.projects.magnusri.ChatChannelsText;

import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
// Imports for logger
import com.google.inject.Inject;

import org.slf4j.Logger;

@Plugin(id = "chatchannelstext", name = "ChatChannelsText", version = "1.0", description = "Example")
public class ChatChannelsText {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Successfully running ChatChannelsText!");
    }
    
    @Listener
    public void onServerInit(GameInitializationEvent event) {
        logger.info("Initializing ChatChannelsText");
    }
    
}