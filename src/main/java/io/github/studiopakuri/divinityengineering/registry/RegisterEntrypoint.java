package io.github.studiopakuri.divinityengineering.registry;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(DivinityEngineering.MODID)
public class RegisterEntrypoint {
    public RegisterEntrypoint(IEventBus modEventBus){
        ModItems.REGISTER.register(modEventBus);
    }
}
