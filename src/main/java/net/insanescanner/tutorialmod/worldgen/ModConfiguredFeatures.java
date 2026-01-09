package net.insanescanner.tutorialmod.worldgen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    //Configured feature can think of it of how are we gonna configure a bunch of ores hence how a ore vein is gen'ed

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_MEMOITE_ORE_KEY = registerKey("memoite_ore");

    public static final ResourceKey<ConfiguredFeature<?,?>> END_OPAL_ORE_KEY = registerKey("end_opal_ore");

    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");



    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldSapphireOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.SAPPHIRE_DEEPSLATE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldMemoiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.MEMOITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.MEMOITE_DEEPSLATE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSapphireOres, 4));
        register(context, OVERWORLD_MEMOITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMemoiteOres, 4));
        register(context, OVERWORLD_MEMOITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.RUBY_NETHER_ORE.get().defaultBlockState(), 4));
        register(context, END_OPAL_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.OPAL_END_ORE.get().defaultBlockState(), 4));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
