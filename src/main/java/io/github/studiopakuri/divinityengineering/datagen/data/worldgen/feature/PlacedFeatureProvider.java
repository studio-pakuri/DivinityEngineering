package io.github.studiopakuri.divinityengineering.datagen.data.worldgen.feature;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public final class PlacedFeatureProvider {
    public static final ResourceKey<PlacedFeature> ETHER_CONTAINING_STONE_SURFACE = create("ether_containing_stone_surface");
    public static final ResourceKey<PlacedFeature> ETHER_CONTAINING_STONE_DEEP = create("ether_containing_stone_deep");
    public static final ResourceKey<PlacedFeature> ETHER_CONTAINING_STONE = create("ether_containing_stone");
    private PlacedFeatureProvider(){}
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeature = context.lookup(
            Registries.CONFIGURED_FEATURE
        );
        context.register(
            ETHER_CONTAINING_STONE_SURFACE,
            new PlacedFeature(
                configuredFeature.getOrThrow(ConfiguredFeatureProvider.ETHER_CONTAINING_STONE),
                List.of(
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(
                        VerticalAnchor.belowTop(-20),
                        VerticalAnchor.belowTop(0)
                    )
                )
            )
        );
        context.register(
            ETHER_CONTAINING_STONE_DEEP,
            new PlacedFeature(
                configuredFeature.getOrThrow(ConfiguredFeatureProvider.ETHER_CONTAINING_STONE),
                List.of(
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(
                        VerticalAnchor.aboveBottom(5),
                        VerticalAnchor.aboveBottom(20)
                    )
                )
            )
        );
        context.register(
            ETHER_CONTAINING_STONE,
            new PlacedFeature(
                configuredFeature.getOrThrow(ConfiguredFeatureProvider.ETHER_CONTAINING_STONE_RANDOM),
                List.of(
                    CountPlacement.of(5),
                    RarityFilter.onAverageOnceEvery(2)
                )
            )
        );
    }
    public static ResourceKey<PlacedFeature> create(String path) {
        return ResourceKey.create(
            Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(DivinityEngineering.MODID, path)
        );
    }
}
