package com.github.telvarost.adminoverride.events.init;

import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.option.KeyBinding;
import net.modificationstation.stationapi.api.client.event.option.KeyBindingRegisterEvent;
import org.lwjgl.input.Keyboard;

public class KeyBindingListener {
    public static KeyBinding toggleFlight;
    public static KeyBinding flyUp;
    public static KeyBinding flyDown;
    public static KeyBinding sprintKey;

    @EventListener
    public void registerKeyBindings(KeyBindingRegisterEvent event) {
        event.keyBindings.add(toggleFlight = new KeyBinding("Toggle Flight", Keyboard.KEY_R));
        event.keyBindings.add(flyUp        = new KeyBinding("Fly Up"    , Keyboard.KEY_SPACE));
        event.keyBindings.add(flyDown      = new KeyBinding("Fly Down"  , Keyboard.KEY_LSHIFT));
        event.keyBindings.add(sprintKey    = new KeyBinding("Sprint"    , Keyboard.KEY_LCONTROL));
    }
}
