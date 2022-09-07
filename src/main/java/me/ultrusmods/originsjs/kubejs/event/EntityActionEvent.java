package me.ultrusmods.originsjs.kubejs.event;

import dev.latvian.mods.kubejs.entity.EntityEventJS;
import dev.latvian.mods.kubejs.entity.EntityJS;
import net.minecraft.entity.Entity;

public class EntityActionEvent extends EntityEventJS {
    private final Entity entity;

    public EntityActionEvent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public EntityJS getEntity() {
        return entityOf(entity);
    }
}
