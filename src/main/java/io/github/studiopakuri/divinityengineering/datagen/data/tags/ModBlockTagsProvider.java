package io.github.studiopakuri.divinityengineering.datagen.data.tags;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.api.tags.CommonDivinityEngineeringTags;
import io.github.studiopakuri.divinityengineering.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DivinityEngineering.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.CRYSTALLIZED_ETHER_BLOCK.get());
        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
            .add(ModBlocks.CRYSTALLIZED_ETHER_BLOCK.get());
        tag(CommonDivinityEngineeringTags.Blocks.CRYSTALLIZED_ETHER_BLOCK)
            .add(ModBlocks.CRYSTALLIZED_ETHER_BLOCK.get());
    }
}
