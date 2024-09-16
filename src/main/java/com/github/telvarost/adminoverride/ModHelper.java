package com.github.telvarost.adminoverride;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Null;
import net.modificationstation.stationapi.api.util.Namespace;

public class ModHelper {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static class ModHelperFields {
        public static Boolean IsFlying = false;
    }
}
