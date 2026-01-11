package net.insanescanner.tutorialmod.worldgen.tree;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrower {
    public static final TreeGrower MAHOGANY = new TreeGrower(TutorialMod.MOD_ID + ":walnut",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MAHOGANY_KEY), Optional.empty());

}
