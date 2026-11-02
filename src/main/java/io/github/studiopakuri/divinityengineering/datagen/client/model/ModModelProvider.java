package io.github.studiopakuri.divinityengineering.datagen.client.model;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.registry.ModBlocks;
import io.github.studiopakuri.divinityengineering.registry.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import org.jspecify.annotations.NonNull;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, DivinityEngineering.MODID);
    }

    @Override
    protected void registerModels(@NonNull BlockModelGenerators blockModels, @NonNull ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.CRYSTALLIZED_ETHER.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(ModBlocks.CRYSTALLIZED_ETHER_BLOCK.get());
    }
}
