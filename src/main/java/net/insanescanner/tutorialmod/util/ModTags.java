package net.insanescanner.tutorialmod.util;

import net.insanescanner.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> NEEDS_MEMOITE_TOOL = createTag("needs_memoite_tool");
        public static final TagKey<Block> INCORRECT_FOR_MEMOITE_TOOL = createTag("incorrect_for_memoite_tool");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> TURNS_INTO_MAHOGANY_PLANK = createTag("turns_into_mahogany_plank");

        public static final TagKey<Item> TRANSFORMABLE_TO_EMERALD = createTag("transformable_to_emerald");

        public static final TagKey<Item> SWORDS_ABOVE_STONE = createTag("swords_above_stone");

        public static final TagKey<Item> SAPPHIRE_BLOCKS = createTag("sapphire_blocks");

        public static final TagKey<Item> MEMOITE_WEAPONS = createTag("memoite_weapons");



        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
        }

    }

}
