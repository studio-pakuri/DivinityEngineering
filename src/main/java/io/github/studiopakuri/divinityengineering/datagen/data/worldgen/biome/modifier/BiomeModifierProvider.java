package io.github.studiopakuri.divinityengineering.datagen.data.worldgen.biome.modifier;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.datagen.data.worldgen.feature.PlacedFeatureProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class BiomeModifierProvider {
    public static final ResourceKey<BiomeModifier> ETHER_CONTAINING_STONE = create("ether_containing_stone");
    private BiomeModifierProvider(){}
    public static void bootstrap(BootstrapContext<BiomeModifier> context){
        HolderGetter<Biome> biome = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);
        context.register(
            ETHER_CONTAINING_STONE,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeature.getOrThrow(PlacedFeatureProvider.ETHER_CONTAINING_STONE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        );
    }
    public static ResourceKey<BiomeModifier> create(String path) {
        return ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            Identifier.fromNamespaceAndPath(DivinityEngineering.MODID, path)
        );
    }
}
