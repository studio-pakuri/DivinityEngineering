package io.github.studiopakuri.divinityengineering.registry;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {
    public static final DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(
        DivinityEngineering.MODID
    );
    public static final DeferredBlock<Block> CRYSTALLIZED_ETHER_BLOCK = REGISTER.registerSimpleBlock(
        "crystallized_ether_block",
        properties -> properties
            .strength(2)
            .requiresCorrectToolForDrops()
            .sound(SoundType.METAL)
    );
    private ModBlocks(){}
}
