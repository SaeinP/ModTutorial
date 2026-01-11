package net.insanescanner.tutorialmod.worldgen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    //how will this be placed
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACE_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> MEMOITE_ORE_PLACE_KEY = registerKey("memoite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_RUBY_ORE_PLACE_KEY = registerKey("nether_ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> END_OPAL_ORE_PLACE_KEY = registerKey("end_opal_ore_placed");

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
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
