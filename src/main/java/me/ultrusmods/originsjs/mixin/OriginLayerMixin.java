package me.ultrusmods.originsjs.mixin;

import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.origin.OriginLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(OriginLayer.class)
public class OriginLayerMixin {

    @Shadow private List<OriginLayer.ConditionedOrigin> conditionedOrigins;

    public void addUnconditionedOrigin(Origin origin) {
        this.conditionedOrigins.add(new OriginLayer.ConditionedOrigin(null, List.of(origin.getIdentifier())));
    }
}
