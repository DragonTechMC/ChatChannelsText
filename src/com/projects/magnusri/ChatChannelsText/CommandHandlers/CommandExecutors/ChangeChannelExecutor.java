package com.projects.magnusri.ChatChannelsText.CommandHandlers.CommandExecutors;

import java.io.IOException;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;

import com.projects.magnusri.ChatChannelsText.Configs;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMapper;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

public class ChangeChannelExecutor implements CommandExecutor {
	Configs config;
	ConfigurationLoader<CommentedConfigurationNode> configLoader;
	
	public ChangeChannelExecutor(Configs config, ConfigurationLoader<CommentedConfigurationNode> configLoader) {
		this.config = config;
		this.configLoader = configLoader;
	}
	
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		src.sendMessage(Text.of("Hello World!"));
		
		
		try {
			CommentedConfigurationNode source = configLoader.load();

			source. = args.getOne("channelname").toString();
			
			configLoader.save(source);
		} catch (IOException | ObjectMappingException e) {
			src.sendMessage(Text.of(e.getStackTrace().toString()));
			e.printStackTrace();
		}
		
		return CommandResult.success();
	}
}
