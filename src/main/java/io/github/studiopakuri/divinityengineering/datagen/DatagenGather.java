package io.github.studiopakuri.divinityengineering.datagen;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.datagen.client.lang.EnglishProvider;
import io.github.studiopakuri.divinityengineering.datagen.client.lang.JapaneseProvider;
import io.github.studiopakuri.divinityengineering.datagen.client.model.ModModelProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.loot.ModBlockLootSubProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.recipe.ModRecipeProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.tags.ModBlockTagsProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.tags.ModItemTagsProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.worldgen.biome.modifier.BiomeModifierProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.worldgen.feature.ConfiguredFeatureProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.worldgen.feature.PlacedFeatureProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = DivinityEngineering.MODID)
public final class DatagenGather {
    private DatagenGather(){}
    @SubscribeEvent
    public static void handler(GatherDataEvent.Client event){
        event.createProvider(ModModelProvider::new);
        event.createProvider(EnglishProvider::new);
        event.createProvider(JapaneseProvider::new);

        event.createProvider(ModRecipeProvider.Runner::new);
        event.createProvider(ModItemTagsProvider::new);
        event.createProvider(ModBlockTagsProvider::new);
        event.createProvider((output, lookupProvider) -> new LootTableProvider(
            output,
            Set.of(),
            List.of(
                new LootTableProvider.SubProviderEntry(
                    ModBlockLootSubProvider::new,
                    LootContextParamSets.BLOCK
                )
            ),
            lookupProvider
        ));
        event.createDatapackRegistryObjects(
            new RegistrySetBuilder()
                .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatureProvider::bootstrap)
                .add(Registries.PLACED_FEATURE, PlacedFeatureProvider::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifierProvider::bootstrap)
        );
    }
}
