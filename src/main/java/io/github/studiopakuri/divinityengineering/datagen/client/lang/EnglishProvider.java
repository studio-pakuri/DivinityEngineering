package io.github.studiopakuri.divinityengineering.datagen.client.lang;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.registry.ModBlocks;
import io.github.studiopakuri.divinityengineering.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnglishProvider extends LanguageProvider {
    public EnglishProvider(PackOutput output) {
        super(output, DivinityEngineering.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.CRYSTALLIZED_ETHER, "Crystallized Ether");
        addItem(ModItems.IMPURE_ETHER_DUST, "Impure Ether Dust");
        addBlock(ModBlocks.CRYSTALLIZED_ETHER_BLOCK, "Crystallized Ether Block");
        addBlock(ModBlocks.ETHER_CONTAINING_STONE, "Ether Containing Stone");
    }
}
