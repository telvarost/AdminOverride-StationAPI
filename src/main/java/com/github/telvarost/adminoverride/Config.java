package com.github.telvarost.adminoverride;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "AdminOverride")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigEntry(
                name = "Flight Speed",
                multiplayerSynced = true
        )
        public Float flightSpeed = 2.0F;

        @ConfigEntry(
                name = "Sprint Speed",
                multiplayerSynced = true
        )
        public Float sprintSpeed = 1.0F;
    }
}
