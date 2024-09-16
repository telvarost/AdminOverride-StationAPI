package com.github.telvarost.adminoverride.events;

import com.github.telvarost.adminoverride.ModHelper;
import com.github.telvarost.adminoverride.events.init.KeyBindingListener;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent;
import org.lwjgl.input.Keyboard;

public class KeyPressedListener {
    Minecraft minecraft = null;

    @EventListener
    public void keyPress(KeyStateChangedEvent event) {
        if (minecraft == null) {
            minecraft = ((Minecraft) FabricLoader.getInstance().getGameInstance());
        }

        if (Keyboard.getEventKeyState() && minecraft.currentScreen == null) {
            if (minecraft.currentScreen == null) {
                if (Keyboard.isKeyDown(KeyBindingListener.toggleFlight.code)) {
                    ModHelper.ModHelperFields.IsFlying = !ModHelper.ModHelperFields.IsFlying;
                }
            }
        }
    }
}
