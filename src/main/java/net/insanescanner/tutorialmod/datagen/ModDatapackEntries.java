package net.insanescanner.tutorialmod.datagen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.enchantments.ModEnchantments;
import net.insanescanner.tutorialmod.trims.ModTrimMaterials;
import net.insanescanner.tutorialmod.trims.ModTrimPatterns;
import net.insanescanner.tutorialmod.worldgen.ModBiomeModifiers;
import net.insanescanner.tutorialmod.worldgen.ModConfiguredFeatures;
import net.insanescanner.tutorialmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
// guessing this only get's called during data gen.
public class ModDatapackEntries extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
            .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap)
            .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap)

            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModDatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER,Set.of(TutorialMod.MOD_ID));
    }


}
