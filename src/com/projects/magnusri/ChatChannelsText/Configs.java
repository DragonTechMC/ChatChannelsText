package com.projects.magnusri.ChatChannelsText;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;


@ConfigSerializable
public class Configs {
	
	@Setting(value = "channels", comment = "Channel List")
	public String channels = "";
	
}