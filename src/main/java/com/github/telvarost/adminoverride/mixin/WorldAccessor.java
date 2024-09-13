package com.github.telvarost.adminoverride.mixin;

import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(World.class)
public interface WorldAccessor {
    @Accessor("properties")
    WorldProperties getProperties();
}
