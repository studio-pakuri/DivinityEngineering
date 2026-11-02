package io.github.studiopakuri.divinityengineering.datagen.client.data.recipe;

import io.github.studiopakuri.divinityengineering.DivinityEngineering;
import io.github.studiopakuri.divinityengineering.api.tags.CommonDivinityEngineeringTags;
import io.github.studiopakuri.divinityengineering.registry.ModItems;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        HolderGetter<Item> holderGetter = registries.lookupOrThrow(Registries.ITEM);
        buildPackAndUnpackRecipes(holderGetter);
    }

    private void buildPackAndUnpackRecipes(HolderGetter<Item> holderGetter){
        ShapedRecipeBuilder.shaped(
            holderGetter,
            RecipeCategory.BUILDING_BLOCKS,
            ModItems.CRYSTALLIZED_ETHER_BLOCK
        )
            .pattern("TTT")
            .pattern("TIT")
            .pattern("TTT")
            .define('T', CommonDivinityEngineeringTags.Items.CRYSTALLIZED_ETHER)
            .define('I', ModItems.CRYSTALLIZED_ETHER)
            .unlockedBy(
                "has_crystallized_ether_nine",
                has(MinMaxBounds.Ints.atLeast(9), ModItems.CRYSTALLIZED_ETHER)
            )
            .save(output, createId("crystallized_ether_block_from_crystallized_ether"));
        ShapelessRecipeBuilder.shapeless(
            holderGetter,
            RecipeCategory.MISC,
            ModItems.CRYSTALLIZED_ETHER,
            9
        )
            .requires(ModItems.CRYSTALLIZED_ETHER_BLOCK)
            .unlockedBy("has_crystallized_ether_block", has(ModItems.CRYSTALLIZED_ETHER_BLOCK))
            .save(output, createId("crystallized_ether_from_crystallized_ether_block"));
    }

    private static ResourceKey<Recipe<?>> createId(String path){
        return ResourceKey.create(
            Registries.RECIPE,
            Identifier.fromNamespaceAndPath(DivinityEngineering.MODID, path)
        );
    }

    public static class Runner extends RecipeProvider.Runner{

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider provider, @NonNull RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public @NonNull String getName() {
            return "Divinity Engineering recipes";
        }
    }
}
