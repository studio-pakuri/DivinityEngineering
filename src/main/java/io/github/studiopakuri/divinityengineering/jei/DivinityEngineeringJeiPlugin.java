package io.github.studiopakuri.divinityengineering.jei;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@JeiPlugin
public class DivinityEngineeringJeiPlugin implements IModPlugin {
    @Override
    public @NonNull Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath(DivinityEngineering.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(@NonNull IRecipeRegistration registration) {
        InformationRegister.register(registration);
    }
}
