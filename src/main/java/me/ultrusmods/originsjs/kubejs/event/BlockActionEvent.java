package me.ultrusmods.originsjs.kubejs.event;

import dev.latvian.mods.kubejs.level.BlockContainerJS;
import dev.latvian.mods.kubejs.level.LevelEventJS;
import dev.latvian.mods.kubejs.level.LevelJS;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Triple;

public class BlockActionEvent extends LevelEventJS {


    private final Direction direction;
    private final BlockContainerJS block;

    public BlockActionEvent(Triple<World, BlockPos, Direction> block) {
        this.block = new BlockContainerJS(block.getLeft(), block.getMiddle());
        this.direction = block.getRight();
    }

    public BlockContainerJS getBlock() {
        return block;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public LevelJS getLevel() {
        return block.getLevel();
    }
}
