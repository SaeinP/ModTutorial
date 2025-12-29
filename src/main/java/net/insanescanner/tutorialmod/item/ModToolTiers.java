package net.insanescanner.tutorialmod.item;

import net.insanescanner.tutorialmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {

    public static final Tier MEMOITE = new ForgeTier(2400, 4, 5f,
            20, ModTags.Blocks.NEEDS_MEMOITE_TOOL, () -> Ingredient.of(ModItems.MEMOITE.get()),
            ModTags.Blocks.INCORRECT_FOR_MEMOITE_TOOL);
}
