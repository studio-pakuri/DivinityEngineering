package io.github.studiopakuri.divinityengineering.jei;

import io.github.studiopakuri.divinityengineering.api.lang.ItemInformationTranslationKeys;
import io.github.studiopakuri.divinityengineering.registry.ModItems;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.NonNull;

public final class InformationRegister {
    private InformationRegister(){}
    public static void register(@NonNull IRecipeRegistration registration){
        registration.addItemStackInfo(
            ModItems.IMPURE_ETHER_DUST.toStack(),
            Component.translatable(ItemInformationTranslationKeys.IMPURE_ETHER_DUST)
        );
    }
}
