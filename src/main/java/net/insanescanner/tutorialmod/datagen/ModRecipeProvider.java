package net.insanescanner.tutorialmod.datagen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.insanescanner.tutorialmod.item.ModItems;
import net.insanescanner.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGIC_CHISEL.get())
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.MEMOITE.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .unlockedBy(getHasName(Items.BLAZE_ROD), has(Items.BLAZE_ROD))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_HOE.get())
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .define('A', ModItems.MEMOITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.MEMOITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.MEMOITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_SHOVEL.get())
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItems.MEMOITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_AXE.get())
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .define('A', ModItems.MEMOITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_HAMMER.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern(" B ")
                .define('A', ModItems.MEMOITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_BOW.get())
                .pattern(" AB")
                .pattern("A B")
                .pattern(" AB")
                .define('A', ModItems.MEMOITE.get())
                .define('B', Items.STRING)
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.MEMOITE.get())
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MEMOITE.get())
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_LEGGING.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.MEMOITE.get())
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MEMOITE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.MEMOITE.get())
                .unlockedBy(getHasName(ModItems.MEMOITE.get()), has(ModItems.MEMOITE.get()))
                .save(pRecipeOutput);




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.RAW_ALEXANDRITE.get()), has(ModItems.RAW_ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("BAB")
                .pattern("ABA")
                .pattern("BAB")
                .define('A', Items.EMERALD)
                .define('B', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POLISHED_SAPPHIRE_BLOCK.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_APPLE.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.APPLE)
                .define('B', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENCHANTED_SAPPHIRE_APPLE.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.APPLE)
                .define('B', ModTags.Items.SAPPHIRE_BLOCKS)
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_RING.get())
                .pattern(" AB")
                .pattern("A A")
                .pattern(" A ")
                .define('A', Items.GOLD_INGOT)
                .define('B', ModItems.CUT_SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_RING.get())
                .pattern(" AB")
                .pattern("A A")
                .pattern(" A ")
                .define('A', Items.GOLD_INGOT)
                .define('B', ModItems.CUT_EMERALD.get())
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_RING.get())
                .pattern(" AB")
                .pattern("A A")
                .pattern(" A ")
                .define('A', Items.GOLD_INGOT)
                .define('B', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_LAMP.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('B', Items.REDSTONE)
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CUT_EMERALD.get(), 1)
                .requires(Items.EMERALD)
                .requires(ModTags.Items.SWORDS_ABOVE_STONE)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CUT_SAPPHIRE.get(), 1)
                .requires(ModItems.SAPPHIRE.get())
                .requires(ModTags.Items.SWORDS_ABOVE_STONE)
                .unlockedBy(getHasName(ModItems.RAW_SAPPHIRE.get()), has(ModItems.RAW_SAPPHIRE.get()));


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), 9)
                .requires(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()), has(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get()), has(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get()));

        List<ItemLike> ALEXANDRITE_SMELTABLE = List.of(ModItems.RAW_ALEXANDRITE.get(), ModBlocks.ALEXANDRITE_ORE.get(),
                ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

        oreSmelting(pRecipeOutput, ALEXANDRITE_SMELTABLE, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.5f, 200, "alexandrite");
        oreBlasting(pRecipeOutput, ALEXANDRITE_SMELTABLE, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.5f, 100, "alexandrite");

        List<ItemLike> MEMOITE_SMELTABLE = List.of(ModItems.RAW_MEMOITE.get(), ModBlocks.MEMOITE_ORE.get(),
                ModBlocks.MEMOITE_DEEPSLATE_ORE.get());

        oreSmelting(pRecipeOutput, MEMOITE_SMELTABLE, RecipeCategory.MISC, ModItems.MEMOITE.get(), 0.5f, 200, "memoite");
        oreBlasting(pRecipeOutput, MEMOITE_SMELTABLE, RecipeCategory.MISC, ModItems.MEMOITE.get(), 0.5f, 100, "memoite");

        List<ItemLike> SAPPHIRE_SMELTABLE = List.of(ModItems.RAW_SAPPHIRE.get(), ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.SAPPHIRE_DEEPSLATE_ORE.get());

        oreSmelting(pRecipeOutput, SAPPHIRE_SMELTABLE, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.5f, 200, "sapphire");
        oreBlasting(pRecipeOutput, SAPPHIRE_SMELTABLE, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.5f, 100, "sapphire");


        stairBuilder(ModBlocks.ALEXANDRITE_STAIR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite").unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_SLAB.get(), ModItems.ALEXANDRITE.get());
        buttonBuilder(ModBlocks.ALEXANDRITE_BUTTON.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), ModItems.ALEXANDRITE.get());

        fenceBuilder(ModBlocks.ALEXANDRITE_FENCE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_WALL.get(), ModItems.ALEXANDRITE.get());

        doorBuilder(ModBlocks.ALEXANDRITE_DOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.ALEXANDRITE_TRAPDOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);


        stairBuilder(ModBlocks.UNPOLISHED_SAPPHIRE_STAIR.get(), Ingredient.of(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get())).group("sapphire").unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNPOLISHED_SAPPHIRE_SLAB.get(), ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get());
        stairBuilder(ModBlocks.POLISHED_SAPPHIRE_STAIR.get(), Ingredient.of(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get())).group("sapphire").unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SAPPHIRE_SLAB.get(), ModBlocks.POLISHED_SAPPHIRE_BLOCK.get());

        trimSmithing(pRecipeOutput, ModItems.INSANESCANNER_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "insanescanner"));
    }

    protected static void oreSmelting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pSuffix
    ) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
}
