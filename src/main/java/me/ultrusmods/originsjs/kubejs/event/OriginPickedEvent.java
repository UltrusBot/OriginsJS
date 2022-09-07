package me.ultrusmods.originsjs.kubejs.event;

import dev.latvian.mods.kubejs.entity.EntityJS;
import dev.latvian.mods.kubejs.player.PlayerEventJS;
import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.origin.OriginLayer;
import net.minecraft.entity.player.PlayerEntity;

public class OriginPickedEvent extends PlayerEventJS {

    private final PlayerEntity player;
    private final OriginLayer layer;
    private final Origin origin;

    public OriginPickedEvent(PlayerEntity player, OriginLayer layer, Origin origin) {
        this.player = player;
        this.layer = layer;
        this.origin = origin;
    }

    @Override
    public EntityJS getEntity() {
        return entityOf(player);
    }

    public OriginLayer getLayer() {
        return layer;
    }

    public Origin getOrigin() {
        return origin;
    }
}
