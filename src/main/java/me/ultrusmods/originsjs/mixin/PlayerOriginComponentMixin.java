package me.ultrusmods.originsjs.mixin;

import io.github.apace100.origins.component.PlayerOriginComponent;
import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.origin.OriginLayer;
import me.ultrusmods.originsjs.kubejs.event.OriginPickedEvent;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerOriginComponent.class)
public class PlayerOriginComponentMixin {

    @Shadow private PlayerEntity player;

    @Inject(method = "setOrigin", at = @At("TAIL"), remap = false)
    void originSetEvent(OriginLayer layer, Origin origin, CallbackInfo ci) {
        new OriginPickedEvent(this.player, layer, origin).post("origin.picked");
    }

}
