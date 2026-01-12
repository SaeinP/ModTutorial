package net.insanescanner.tutorialmod.worldgen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    //how will this be placed
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACE_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> MEMOITE_ORE_PLACE_KEY = registerKey("memoite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_RUBY_ORE_PLACE_KEY = registerKey("nether_ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> END_OPAL_ORE_PLACE_KEY = registerKey("end_opal_ore_placed");

    public static final ResourceKey<PlacedFeature> MAHOGANY_PLACED_KEY = registerKey("walnut_placed");

    public static final ResourceKey<PlacedFeature> COMMON_BLUEBERRY_BUSH_PLACED_KEY = registerKey("common_blueberry_bush_placed");
    public static final ResourceKey<PlacedFeature> UNCOMMON_BLUEBERRY_BUSH_PLACED_KEY = registerKey("uncommon_blueberry_bush_placed");
    public static final ResourceKey<PlacedFeature> RARE_BLUEBERRY_BUSH_PLACED_KEY = registerKey("rare_blueberry_bush_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SAPPHIRE_ORE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SAPPHIRE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(70))));

        register(context, MEMOITE_ORE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MEMOITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(20))));

        register(context, NETHER_RUBY_ORE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(70))));

        register(context, END_OPAL_ORE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_OPAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(70))));


        register(context, MAHOGANY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAHOGANY_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.MAHOGANY_SAPLING.get()));

        register(context, COMMON_BLUEBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUEBERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(26), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, UNCOMMON_BLUEBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUEBERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(120), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, RARE_BLUEBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUEBERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(190), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
