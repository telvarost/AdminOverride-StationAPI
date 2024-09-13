package com.github.telvarost.adminoverride.mixin;

import com.github.telvarost.adminoverride.ModHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(World.class)
public abstract class WorldMixin {

    @Shadow public abstract float method_198(float f);

    @Shadow protected WorldProperties properties;

    @Shadow public abstract boolean setBlock(int x, int y, int z, int id);

    @Shadow public abstract int getBlockId(int x, int y, int z);

    @Unique private int counter = 0;

    @Inject(
            method = "method_227",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;isEmpty()Z",
                    ordinal = 0
            )
    )
    public void method_227(CallbackInfo ci) {
        if (0 == counter % 100) {
            ModHelper.ModHelperFields.eventCounter = (ModHelper.ModHelperFields.eventCounter + 1) % 16;
        }

        counter++;
    }
}
