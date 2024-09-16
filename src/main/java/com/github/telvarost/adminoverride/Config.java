package com.github.telvarost.adminoverride;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.*;

public class Config {

    @GConfig(value = "config", visibleName = "AdminOverride")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigName("Flight Speed")
        @MultiplayerSynced
        public Float flightSpeed = 2.0F;

        @ConfigName("Sprint Speed")
        @MultiplayerSynced
        public Float sprintSpeed = 1.0F;
    }
}
