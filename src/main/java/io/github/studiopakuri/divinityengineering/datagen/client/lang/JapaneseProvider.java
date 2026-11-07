package io.github.studiopakuri.divinityengineering.datagen.client.lang;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.registry.ModBlocks;
import io.github.studiopakuri.divinityengineering.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class JapaneseProvider extends LanguageProvider {
    public JapaneseProvider(PackOutput output) {
        super(output, DivinityEngineering.MODID, "ja_jp");
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.CRYSTALLIZED_ETHER, "結晶化エーテル");
        addItem(ModItems.IMPURE_ETHER_DUST, "不純なエーテルダスト");
        addBlock(ModBlocks.CRYSTALLIZED_ETHER_BLOCK, "結晶化エーテルブロック");
        addBlock(ModBlocks.ETHER_CONTAINING_STONE, "エーテル含有石");
    }
}
