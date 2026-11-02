package io.github.studiopakuri.divinityengineering.datagen.data.tags;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.api.tags.CommonDivinityEngineeringTags;
import io.github.studiopakuri.divinityengineering.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DivinityEngineering.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        tag(CommonDivinityEngineeringTags.Items.CRYSTALLIZED_ETHER)
            .add(ModItems.CRYSTALLIZED_ETHER.get());
        tag(CommonDivinityEngineeringTags.Items.CRYSTALLIZED_ETHER_BLOCK)
            .add(ModItems.CRYSTALLIZED_ETHER_BLOCK.get());
    }
}
