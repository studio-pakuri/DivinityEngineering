package io.github.studiopakuri.divinityengineering.block;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.api.loot.DivinityEngineeringLootTableKey;
import io.github.studiopakuri.divinityengineering.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCauldronInteractionEvent;

import java.util.List;

@EventBusSubscriber(modid = DivinityEngineering.MODID)
public final class ModCauldronInteractions {

    private ModCauldronInteractions(){}

    @SubscribeEvent
    public static void interactionRegister(RegisterCauldronInteractionEvent.Interaction event){
        event.register(
            Identifier.withDefaultNamespace("water"),
            ModItems.IMPURE_ETHER_DUST.get(),
            ModCauldronInteractions::createCrystallizedEther
        );
    }

    private static InteractionResult createCrystallizedEther(
        BlockState blockState,
        Level level,
        BlockPos pos,
        Player player,
        InteractionHand interactionHand,
        ItemStack itemStack
    ){
        if (level.isClientSide()) return InteractionResult.SUCCESS;
        ServerLevel serverLevel = (ServerLevel)level;
        Vec3 center = pos.getCenter();

        LootTable lootTable = serverLevel
            .getServer()
            .reloadableRegistries()
            .getLootTable(DivinityEngineeringLootTableKey.ETHER_CLEANING);

        LootParams.Builder builder = new LootParams.Builder(serverLevel);
        builder.withParameter(LootContextParams.ORIGIN, center);
        builder.withParameter(LootContextParams.BLOCK_STATE, blockState);
        builder.withOptionalParameter(LootContextParams.BLOCK_ENTITY, serverLevel.getBlockEntity(pos));
        builder.withOptionalParameter(LootContextParams.INTERACTING_ENTITY, player);
        builder.withOptionalParameter(LootContextParams.TOOL, itemStack);
        LootParams lootParams = builder.create(LootContextParamSets.BLOCK_INTERACT);

        List<ItemStack> itemStacks = lootTable.getRandomItems(lootParams, serverLevel.getRandom());

        for (ItemStack dropItemStack: itemStacks) {
            ItemEntity itemEntity = new ItemEntity(EntityType.ITEM, serverLevel);
            itemEntity.setItem(dropItemStack);
            itemEntity.setPos(center);
            serverLevel.addFreshEntity(itemEntity);
        }

        itemStack.shrink(1);

        int cauldronLevel = blockState.getValue(BlockStateProperties.LEVEL_CAULDRON);

        BlockState newBlockState;

        if (cauldronLevel == 1){
            newBlockState = Blocks.CAULDRON.defaultBlockState();
        }else {
            newBlockState = blockState.setValue(BlockStateProperties.LEVEL_CAULDRON, cauldronLevel - 1);
        }

        serverLevel.setBlock(pos, newBlockState, Block.UPDATE_CLIENTS);
        return InteractionResult.SUCCESS;
    }

    public static Identifier create(String path){
        return Identifier.fromNamespaceAndPath(DivinityEngineering.MODID, path);
    }
}
