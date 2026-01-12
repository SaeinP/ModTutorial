package net.insanescanner.tutorialmod.worldgen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    //where will this be placed
    public static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORE = registerKey("add_sapphire_ore");
    public static final ResourceKey<BiomeModifier> ADD_MEMOITE_ORE = registerKey("add_memoite_ore");

    public static final ResourceKey<BiomeModifier> ADD_NETHER_RUBY_ORE = registerKey("add_nether_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_OPAL_ORE = registerKey("add_end_opal_ore");

    public static final ResourceKey<BiomeModifier> ADD_MAHOGANY_TREE = registerKey("add_mahogany_tree");

    public static final ResourceKey<BiomeModifier> ADD_COMMON_BLUEBERRY_BUSH = registerKey("add_common_blueberry_bush");
    public static final ResourceKey<BiomeModifier> ADD_UNCOMMON_BLUEBERRY_BUSH = registerKey("add_uncommon_blueberry_bush");
    public static final ResourceKey<BiomeModifier> ADD_RARE_BLUEBERRY_BUSH = registerKey("add_rare_blueberry_bush");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_SAPPHIRE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
           HolderSet.direct(biomes.getOrThrow(Biomes.BEACH), biomes.getOrThrow(Biomes.OCEAN),
                   biomes.getOrThrow(Biomes.BEACH),
                   biomes.getOrThrow(Biomes.DEEP_COLD_OCEAN),
                   biomes.getOrThrow(Biomes.FROZEN_OCEAN),
                   biomes.getOrThrow(Biomes.COLD_OCEAN),
                   biomes.getOrThrow(Biomes.DEEP_OCEAN),
                   biomes.getOrThrow(Biomes.DEEP_FROZEN_OCEAN),
                   biomes.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN),
                   biomes.getOrThrow(Biomes.LUKEWARM_OCEAN),
                   biomes.getOrThrow(Biomes.WARM_OCEAN),
                   biomes.getOrThrow(Biomes.RIVER)
                   ),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.SAPPHIRE_ORE_PLACE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_MEMOITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.MEMOITE_ORE_PLACE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_NETHER_RUBY_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.NETHER_RUBY_ORE_PLACE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_END_OPAL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.END_OPAL_ORE_PLACE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_MAHOGANY_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA)), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.MAHOGANY_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_COMMON_BLUEBERRY_BUSH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.TAIGA)), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.COMMON_BLUEBERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_UNCOMMON_BLUEBERRY_BUSH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BIRCH_FOREST), biomes.getOrThrow(Biomes.FOREST)), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.UNCOMMON_BLUEBERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_RARE_BLUEBERRY_BUSH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.MEADOW)), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.RARE_BLUEBERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

}
