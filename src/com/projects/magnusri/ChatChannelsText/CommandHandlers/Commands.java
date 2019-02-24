package com.projects.magnusri.ChatChannelsText.CommandHandlers;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

import com.projects.magnusri.ChatChannelsText.ChatChannelsText;
import com.projects.magnusri.ChatChannelsText.Configs;
import com.projects.magnusri.ChatChannelsText.CommandHandlers.CommandExecutors.ChangeChannelExecutor;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

public class Commands {
	public void Initialise (ChatChannelsText plugin, Configs config, ConfigurationLoader<CommentedConfigurationNode> configLoader) {
		ChangeChannelExecutor changeChannelExecutor = new ChangeChannelExecutor(config, configLoader);
		
		CommandSpec channelChangeSpec = CommandSpec.builder()
	    	    .description(Text.of("Change Channel"))
	    	    .permission("dtchannels.changechannel")
	    	    .arguments(GenericArguments.string(Text.of("channelname")))
	    	    .executor(changeChannelExecutor)
	    	    .build();
		
		Sponge.getCommandManager().register(plugin, channelChangeSpec, "cchange", "cc");
	}
}
