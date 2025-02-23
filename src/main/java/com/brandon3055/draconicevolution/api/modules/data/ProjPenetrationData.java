package com.brandon3055.draconicevolution.api.modules.data;

import com.brandon3055.draconicevolution.api.modules.lib.ModuleContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.Map;

/**
 * Created by brandon3055 on 3/5/20.
 */
@Deprecated
public class ProjPenetrationData implements ModuleData<ProjPenetrationData> {
    private final float penetration;

    public ProjPenetrationData(float penetration) {
        this.penetration = penetration;
    }

    public float getPenetration() {
        return penetration;
    }

    @Override
    public ProjPenetrationData combine(ProjPenetrationData other) {
        return new ProjPenetrationData(penetration + other.penetration);
    }

    @Override
    public void addInformation(Map<Component, Component> map, ModuleContext context, boolean stack) {
        map.put(new TranslatableComponent("module.draconicevolution.proj_penetration.name"), new TranslatableComponent("module.draconicevolution.proj_penetration.value", (int)(getPenetration() * 100)));
        if (stack) {
            map.put(new TranslatableComponent("module.draconicevolution.proj_penetration.name"), null);
        }
    }
}
