package io.github.studiopakuri.divinityengineering.api.loot;

import io.github.studiopakuri.divinityengineering.api.DivinityEngineeringApi;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public final class DivinityEngineeringLootTableKey {
    public static final ResourceKey<LootTable> ETHER_CLEANING = create("gameplay/ether_cleaning");
    private DivinityEngineeringLootTableKey(){}
    private static ResourceKey<LootTable> create(String path){
        return ResourceKey.create(
            Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(
                DivinityEngineeringApi.MODID,
                path
            )
        );
    }
}
