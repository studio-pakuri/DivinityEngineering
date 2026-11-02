package io.github.studiopakuri.divinityengineering.datagen.data.loot;

import io.github.studiopakuri.divinityengineering.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {
    public ModBlockLootSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    protected @NonNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.REGISTER.getEntries()
            .stream()
            .map(e -> (Block)e.get())
            ::iterator;
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CRYSTALLIZED_ETHER_BLOCK.get());
    }
}
