package io.github.studiopakuri.divinityengineering.api.tags;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class CommonDivinityEngineeringTags {
    private CommonDivinityEngineeringTags(){}
    private static <T> TagKey<T> create(ResourceKey<Registry<T>> registry, String path){
        return TagKey.create(
            registry,
            Identifier.fromNamespaceAndPath("c", path)
        );
    }
    public static final class Blocks {
        public static final TagKey<Block> CRYSTALLIZED_ETHER_BLOCK = create("crystallized_ether_block");
        private Blocks(){}
        private static TagKey<Block> create(String path){
            return CommonDivinityEngineeringTags.create(Registries.BLOCK, path);
        }
    }
    public static final class Items{
        public static final TagKey<Item> CRYSTALLIZED_ETHER = create("crystallized_ether");
        public static final TagKey<Item> CRYSTALLIZED_ETHER_BLOCK = create("crystallized_ether_block");
        private Items(){}
        private static TagKey<Item> create(String path){
            return CommonDivinityEngineeringTags.create(Registries.ITEM, path);
        }
    }
}
