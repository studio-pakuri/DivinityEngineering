package io.github.studiopakuri.divinityengineering.registry;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items REGISTER = DeferredRegister.createItems(DivinityEngineering.MODID);
    public static final DeferredItem<Item> CRYSTALLIZED_ETHER = REGISTER.registerSimpleItem(
        "crystallized_ether"
    );
    private ModItems(){}
}
