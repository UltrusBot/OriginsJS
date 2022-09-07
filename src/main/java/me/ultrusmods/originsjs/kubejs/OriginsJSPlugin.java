package me.ultrusmods.originsjs.kubejs;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeRegistry;
import io.github.apace100.origins.origin.*;

public class OriginsJSPlugin extends KubeJSPlugin {

    @Override
    public void addBindings(BindingsEvent event) {
        event.add("Impact", Impact.class);
        event.add("IMPACT_NONE", Impact.NONE);
        event.add("IMPACT_LOW", Impact.LOW);
        event.add("IMPACT_MEDIUM", Impact.MEDIUM);
        event.add("IMPACT_HIGH", Impact.HIGH);

        event.add("Origin", Origin.class);
        event.add("OriginRegistry", OriginRegistry.class);
        event.add("PowerType", PowerType.class);
        event.add("PowerTypeRegistry", PowerTypeRegistry.class);

        event.add("OriginLayer", OriginLayer.class);
        event.add("OriginLayers", OriginLayers.class);

    }
}
