package net.insanescanner.tutorialmod.datagen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.insanescanner.tutorialmod.item.ModItems;
import net.insanescanner.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_TO_EMERALD).add(ModItems.CUT_EMERALD.get());

        tag(ModTags.Items.SWORDS_ABOVE_STONE).add(Items.IRON_SWORD).add(Items.DIAMOND_SWORD).add(Items.NETHERITE_SWORD).add(Items.GOLDEN_SWORD).add(Items.STONE_SWORD);

        tag(ModTags.Items.SAPPHIRE_BLOCKS).add(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get().asItem()).add(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get().asItem());
    }
}
