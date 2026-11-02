package io.github.studiopakuri.divinityengineering.datagen;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.datagen.data.loot.ModBlockLootSubProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.recipe.ModRecipeProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.tags.ModBlockTagsProvider;
import io.github.studiopakuri.divinityengineering.datagen.data.tags.ModItemTagsProvider;
import io.github.studiopakuri.divinityengineering.datagen.client.lang.EnglishProvider;
import io.github.studiopakuri.divinityengineering.datagen.client.lang.JapaneseProvider;
import io.github.studiopakuri.divinityengineering.datagen.client.model.ModModelProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

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
    }
}
