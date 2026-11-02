package io.github.studiopakuri.divinityengineering.registry;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items REGISTER = DeferredRegister.createItems(DivinityEngineering.MODID);
    public static final DeferredItem<Item> CRYSTALLIZED_ETHER = REGISTER.registerSimpleItem(
        "crystallized_ether"
    );
    public static final DeferredItem<BlockItem> CRYSTALLIZED_ETHER_BLOCK = REGISTER.registerSimpleBlockItem(
        ModBlocks.CRYSTALLIZED_ETHER_BLOCK
    );
    private ModItems(){}
}
