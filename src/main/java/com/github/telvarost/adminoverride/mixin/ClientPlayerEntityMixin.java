package com.github.telvarost.adminoverride.mixin;

import com.github.telvarost.adminoverride.ModHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.Session;
import net.minecraft.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
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
        if (1 == ModHelper.ModHelperFields.flightStatus) {
            super.move(dx, 1, dz);
            //this.y += 1;
        } else if (2 == ModHelper.ModHelperFields.flightStatus) {
            //super.move(dx, -1, dz);
            //this.y -= 1;
        }
    }

    @Inject(
            method = "move",
            at = @At("TAIL"),
            cancellable = true
    )
    public void moveSprint(double dx, double dy, double dz, CallbackInfo ci) {
        if (1 == ModHelper.ModHelperFields.flightStatus) {
            super.move(dx, 1, dz);
            //this.y += 1;
        } else if (2 == ModHelper.ModHelperFields.flightStatus) {
            //super.move(dx, -1, dz);
            //this.y -= 1;
        }

        if (1 == ModHelper.ModHelperFields.sprintStatus) {
            super.move(dx * 2, dy, dz * 2);
        }
    }
}