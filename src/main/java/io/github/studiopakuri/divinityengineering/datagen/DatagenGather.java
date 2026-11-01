package io.github.studiopakuri.divinityengineering.datagen;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.datagen.client.lang.EnglishProvider;
import io.github.studiopakuri.divinityengineering.datagen.client.lang.JapaneseProvider;
import io.github.studiopakuri.divinityengineering.datagen.client.model.ModModelProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = DivinityEngineering.MODID)
public final class DatagenGather {
    private DatagenGather(){}
    @SubscribeEvent
    public static void handler(GatherDataEvent.Client event){
        event.createProvider(ModModelProvider::new);
        event.createProvider(EnglishProvider::new);
        event.createProvider(JapaneseProvider::new);
    }
}
