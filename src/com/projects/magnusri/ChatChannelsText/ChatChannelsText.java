package com.projects.magnusri.ChatChannelsText;

import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.command.TabCompleteEvent.Command;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
// Imports for logger
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.projects.magnusri.ChatChannelsText.CommandHandlers.Commands;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMapper;

import org.slf4j.Logger;

@Plugin(id = "chatchannelstext", name = "ChatChannelsText", version = "1.0", description = "Example")
public class ChatChannelsText {

	@Inject 
	@DefaultConfig(sharedRoot = false)
	private ConfigurationLoader<CommentedConfigurationNode> defaultConfigLoader;

	@Inject
	Configs config;
	
    @Inject
    private Logger logger;
	
	@Inject
	private Commands commands;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Successfully running ChatChannelsText!");
        
        loadConfig();
        
        commands.Initialise(this, config, defaultConfigLoader);
    }
    
    @Listener
    public void onServerInit(GameInitializationEvent event) {
        logger.info("Initializing ChatChannelsText");
    }
    
    public void loadConfig(){

    	// Config
    	try {
    		CommentedConfigurationNode source = defaultConfigLoader.load();
	    	
	    	defaultConfigLoader.save(source);
	    	
			ObjectMapper<Configs> mapper = ObjectMapper.forClass(Configs.class);
			mapper.bind(config).populate(source);
			
	    	defaultConfigLoader.save(source);
    	} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
    }
    
}