package io.github.studiopakuri.divinityengineering.datagen.data.loot;

import io.github.studiopakuri.divinityengineering.api.loot.DivinityEngineeringLootTableKey;
import io.github.studiopakuri.divinityengineering.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jspecify.annotations.NonNull;

import java.util.function.BiConsumer;

public class ModGameplayLootTableSubProvider implements LootTableSubProvider {
    public ModGameplayLootTableSubProvider(HolderLookup.Provider lookupProvider){
    }
    @Override
    public void generate(@NonNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(
            DivinityEngineeringLootTableKey.ETHER_CLEANING,
            LootTable.lootTable()
                .withPool(
                    LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.CRYSTALLIZED_ETHER))
                )
                .withPool(
                    LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.GRAVEL))
                )
        );
    }
}
