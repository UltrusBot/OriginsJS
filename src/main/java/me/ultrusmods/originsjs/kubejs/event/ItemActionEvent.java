package me.ultrusmods.originsjs.kubejs.event;

import dev.latvian.mods.kubejs.item.ItemStackJS;
import dev.latvian.mods.kubejs.level.LevelEventJS;
import dev.latvian.mods.kubejs.level.LevelJS;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.world.World;

public class ItemActionEvent extends LevelEventJS {

    private final World world;
    private final ItemStack itemStack;

    public ItemActionEvent(Pair<World, ItemStack> worldItemStackPair) {
        this.world = worldItemStackPair.getLeft();
        this.itemStack = worldItemStackPair.getRight();
    }

    public ItemStackJS getStack() {
        return ItemStackJS.of(itemStack);
    }

    @Override
    public LevelJS getLevel() {
        return levelOf(world);
    }
}
