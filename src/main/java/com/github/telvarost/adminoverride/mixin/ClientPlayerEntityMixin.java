package com.github.telvarost.adminoverride.mixin;

import com.github.telvarost.adminoverride.Config;
import com.github.telvarost.adminoverride.ModHelper;
import com.github.telvarost.adminoverride.events.init.KeyBindingListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.Session;
import net.minecraft.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends PlayerEntity {

    public ClientPlayerEntityMixin(Minecraft minecraft, World world, Session session, int dimensionId) {
        super(world);
    }

    @Inject(
            method = "move",
            at = @At("HEAD"),
            cancellable = true
    )
    public void moveFlight(double dx, double dy, double dz, CallbackInfo ci) {
        if (ModHelper.ModHelperFields.IsFlying) {
            ModHelper.ModHelperFields.FlightRelease = true;

            if (Keyboard.isKeyDown(KeyBindingListener.flyUp.code)) {
                super.move(dx, (Config.config.flightSpeed / 3), dz);
                if (Keyboard.isKeyDown(KeyBindingListener.sprintKey.code)) {
                    super.move(dx * Config.config.sprintSpeed, (Config.config.flightSpeed / 3), dz * Config.config.sprintSpeed);
                }
            } else if (Keyboard.isKeyDown(KeyBindingListener.flyDown.code)) {
                super.move(dx, -(Config.config.flightSpeed / 3), dz);
                if (Keyboard.isKeyDown(KeyBindingListener.sprintKey.code)) {
                    super.move(dx * Config.config.sprintSpeed, -(Config.config.flightSpeed / 3), dz * Config.config.sprintSpeed);
                }
            } else if (Keyboard.isKeyDown(KeyBindingListener.sprintKey.code)) {
                super.move(dx * Config.config.flightSpeed, 0, dz * Config.config.flightSpeed);
                super.move(dx * Config.config.sprintSpeed, 0, dz * Config.config.sprintSpeed);
            } else {
                super.move(dx * Config.config.flightSpeed, 0, dz * Config.config.flightSpeed);
            }

            ci.cancel();
        }

        if (true == ModHelper.ModHelperFields.FlightRelease) {
            this.velocityY = 0.0F;
            ModHelper.ModHelperFields.FlightRelease = false;
        }
    }

    @Inject(
            method = "move",
            at = @At("TAIL"),
            cancellable = true
    )
    public void moveSprint(double dx, double dy, double dz, CallbackInfo ci) {
        if (Keyboard.isKeyDown(KeyBindingListener.sprintKey.code)) {
            super.move(dx * Config.config.sprintSpeed, dy, dz * Config.config.sprintSpeed);
        }
    }
}