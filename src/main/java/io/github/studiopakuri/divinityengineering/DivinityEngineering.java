package io.github.studiopakuri.divinityengineering;

import com.mojang.logging.LogUtils;
import io.github.studiopakuri.divinityengineering.api.DivinityEngineeringApi;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(DivinityEngineering.MODID)
public class DivinityEngineering {
    public static final String MODID = DivinityEngineeringApi.MODID;
    public static final Logger LOGGER = LogUtils.getLogger();

    public DivinityEngineering(IEventBus modEventBus, ModContainer modContainer) {
    }
}
