package com.github.telvarost.adminoverride;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.*;

public class Config {

    @GConfig(value = "config", visibleName = "AdminOverride")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigName("Test Config")
        @Comment("Does nothing.")
        @MultiplayerSynced
        @ValueOnVanillaServer(booleanValue = TriBoolean.FALSE)
        public Boolean testConfig = true;
    }
}
