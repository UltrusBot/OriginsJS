package me.ultrusmods.originsjs.kubejs.event;

import dev.latvian.mods.kubejs.entity.EntityEventJS;
import dev.latvian.mods.kubejs.entity.EntityJS;
import net.minecraft.entity.Entity;

public class BiEntityActionEvent extends EntityEventJS {
    private final Entity actor;
    private final Entity target;

    public BiEntityActionEvent(Entity target, Entity actor) {
        this.actor = actor;
        this.target = target;
    }

    public Entity getActor() {
        return actor;
    }

    public Entity getTarget() {
        return target;
    }

    @Override
    public EntityJS getEntity() {
        return entityOf(actor);
    }
}
