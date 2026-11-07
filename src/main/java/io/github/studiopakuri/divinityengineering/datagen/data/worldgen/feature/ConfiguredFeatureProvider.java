package io.github.studiopakuri.divinityengineering.datagen.data.worldgen.feature;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.registry.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public final class ConfiguredFeatureProvider {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_CONTAINING_STONE_RANDOM = create("ether_containing_stone_random");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_CONTAINING_STONE = create("ether_containing_stone");

    private ConfiguredFeatureProvider() {
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeature = context.lookup(
            Registries.PLACED_FEATURE
        );
        context.register(
            ETHER_CONTAINING_STONE,
            new ConfiguredFeature<>(
                Feature.ORE,
                new OreConfiguration(
                    List.of(
                        OreConfiguration.target(
                            new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                            ModBlocks.ETHER_CONTAINING_STONE.get().defaultBlockState()
                        ),
                        OreConfiguration.target(
                            new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            ModBlocks.ETHER_CONTAINING_STONE.get().defaultBlockState()
                        )
                    ),
                    12
                )
            )
        );
        context.register(
            ETHER_CONTAINING_STONE_RANDOM,
            new ConfiguredFeature<>(
                Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfiguration(
                    HolderSet.direct(
                        placedFeature.getOrThrow(PlacedFeatureProvider.ETHER_CONTAINING_STONE_SURFACE),
                        placedFeature.getOrThrow(PlacedFeatureProvider.ETHER_CONTAINING_STONE_DEEP)
                    )
                )
            )
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> create(String path) {
        return ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            Identifier.fromNamespaceAndPath(DivinityEngineering.MODID, path)
        );
    }
}
