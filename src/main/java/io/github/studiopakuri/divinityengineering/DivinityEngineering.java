package io.github.studiopakuri.divinityengineering;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(DivinityEngineering.MODID)
public class DivinityEngineering {
    public static final String MODID = "divinityengineering";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DivinityEngineering(IEventBus modEventBus, ModContainer modContainer) {
    }
}
