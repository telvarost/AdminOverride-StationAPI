package com.github.telvarost.adminoverride.mixin;

import com.github.telvarost.adminoverride.ModHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(World.class)
public abstract class WorldMixin {

    @Unique private int counter = 0;

    @Inject(
            method = "tickEntities",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;isEmpty()Z",
                    ordinal = 0
            )
    )
    public void tick(CallbackInfo ci) {
        if (0 == counter % 100) {
            ModHelper.ModHelperFields.eventCounter = (ModHelper.ModHelperFields.eventCounter + 1) % 16;
        }

        counter++;
    }
}
