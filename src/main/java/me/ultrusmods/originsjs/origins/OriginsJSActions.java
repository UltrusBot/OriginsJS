package me.ultrusmods.originsjs.origins;

import io.github.apace100.apoli.power.factory.action.ActionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import me.ultrusmods.originsjs.kubejs.event.BiEntityActionEvent;
import me.ultrusmods.originsjs.kubejs.event.BlockActionEvent;
import me.ultrusmods.originsjs.kubejs.event.EntityActionEvent;
import me.ultrusmods.originsjs.kubejs.event.ItemActionEvent;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Triple;

import static me.ultrusmods.originsjs.OriginsJsMod.MOD_ID;

public class OriginsJSActions {

    public static void register() {
        register(new ActionFactory<>(new Identifier(MOD_ID, "entity_action"), new SerializableData()
                .add("id", SerializableDataTypes.IDENTIFIER),
                (data, entity) -> {
                    Identifier id = data.getId("id");
                    new EntityActionEvent(entity).post("origins.power." + id.getNamespace() + "." + id.getPath());
                }));

        registerBiEntityAction(new ActionFactory<>(new Identifier(MOD_ID, "bientity_action"), new SerializableData()
                .add("id", SerializableDataTypes.IDENTIFIER),
                (data, entityPair) -> {
                    Identifier id = data.getId("id");
                    new BiEntityActionEvent(entityPair.getRight(), entityPair.getLeft()).post("origins.power." + id.getNamespace() + "." + id.getPath());
                }));

        registerItemAction(new ActionFactory<>(new Identifier(MOD_ID, "item_action"), new SerializableData()
                .add("id", SerializableDataTypes.IDENTIFIER),
                (data, worldAndStack) -> {
                    Identifier id = data.getId("id");
                    new ItemActionEvent(worldAndStack).post("origins.power." + id.getNamespace() + "." + id.getPath());
                }));

        registerBlockAction(new ActionFactory<>(new Identifier(MOD_ID, "block_action"), new SerializableData()
                .add("id", SerializableDataTypes.IDENTIFIER),
                (data, block) -> {
                    Identifier id = data.getId("id");
                    new BlockActionEvent(block).post("origins.power." + id.getNamespace() + "." + id.getPath());

                }));
    }


    private static void register(ActionFactory<Entity> actionFactory) {
        Registry.register(ApoliRegistries.ENTITY_ACTION, actionFactory.getSerializerId(), actionFactory);
    }

    private static void registerBiEntityAction(ActionFactory<Pair<Entity, Entity>> actionFactory) {
        Registry.register(ApoliRegistries.BIENTITY_ACTION, actionFactory.getSerializerId(), actionFactory);
    }

    private static void registerItemAction(ActionFactory<Pair<World, ItemStack>> actionFactory) {
        Registry.register(ApoliRegistries.ITEM_ACTION, actionFactory.getSerializerId(), actionFactory);
    }

    private static void registerBlockAction(ActionFactory<Triple<World, BlockPos, Direction>> actionFactory) {
        Registry.register(ApoliRegistries.BLOCK_ACTION, actionFactory.getSerializerId(), actionFactory);
    }
}
