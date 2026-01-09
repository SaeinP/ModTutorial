package net.insanescanner.tutorialmod.datagen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.insanescanner.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get())
                .add(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.SAPPHIRE_DEEPSLATE_ORE.get())
                .add(ModBlocks.UNPOLISHED_SAPPHIRE_STAIR.get())
                .add(ModBlocks.POLISHED_SAPPHIRE_STAIR.get())
                .add(ModBlocks.UNPOLISHED_SAPPHIRE_STAIR.get())
                .add(ModBlocks.POLISHED_SAPPHIRE_SLAB.get())
                .add(ModBlocks.UNPOLISHED_SAPPHIRE_SLAB.get())
                .add(ModBlocks.ALEXANDRITE_STAIR.get())
                .add(ModBlocks.ALEXANDRITE_FENCE.get())
                .add(ModBlocks.ALEXANDRITE_FENCE_GATE.get())
                .add(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get())
                .add(ModBlocks.ALEXANDRITE_BUTTON.get())
                .add(ModBlocks.ALEXANDRITE_SLAB.get())
                .add(ModBlocks.ALEXANDRITE_WALL.get())
                .add(ModBlocks.ALEXANDRITE_DOOR.get())
                .add(ModBlocks.ALEXANDRITE_TRAPDOOR.get())
                .add(ModBlocks.MEMOITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.MEMOITE_ORE.get())
                .add(ModBlocks.RUBY_NETHER_ORE.get())
                .add(ModBlocks.OPAL_END_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_FENCE.get())
                .add(ModBlocks.ALEXANDRITE_FENCE_GATE.get())
                .add(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get())
                .add(ModBlocks.ALEXANDRITE_BUTTON.get())
                .add(ModBlocks.ALEXANDRITE_SLAB.get())
                .add(ModBlocks.ALEXANDRITE_STAIR.get())
                .add(ModBlocks.ALEXANDRITE_WALL.get())
                .add(ModBlocks.ALEXANDRITE_DOOR.get())
                .add(ModBlocks.ALEXANDRITE_TRAPDOOR.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get())
                .add(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.SAPPHIRE_DEEPSLATE_ORE.get())
                .add(ModBlocks.UNPOLISHED_SAPPHIRE_STAIR.get())
                .add(ModBlocks.POLISHED_SAPPHIRE_STAIR.get())
                .add(ModBlocks.UNPOLISHED_SAPPHIRE_SLAB.get())
                .add(ModBlocks.POLISHED_SAPPHIRE_SLAB.get())
                .add(ModBlocks.MEMOITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.MEMOITE_ORE.get())
                .add(ModBlocks.RUBY_NETHER_ORE.get())
                .add(ModBlocks.OPAL_END_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.MAGIC_BLOCK.get());


        tag(BlockTags.FENCES).add(ModBlocks.ALEXANDRITE_FENCE.get());

        tag(BlockTags.FENCE_GATES).add(ModBlocks.ALEXANDRITE_FENCE_GATE.get());

        tag(BlockTags.WALLS).add(ModBlocks.ALEXANDRITE_WALL.get());

        tag(ModTags.Blocks.NEEDS_MEMOITE_TOOL).add(ModBlocks.MEMOITE_ORE.get())
                .add(ModBlocks.MEMOITE_DEEPSLATE_ORE.get()).addTags(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_MEMOITE_TOOL).addTags(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_MEMOITE_TOOL);
    }
}
