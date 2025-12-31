package net.insanescanner.tutorialmod.trims;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

import static net.insanescanner.tutorialmod.item.ModItems.MEMOITE;

public class ModTrimPatterns {

    public static final ResourceKey<TrimPattern> INSANESCANNER = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "insanescanner"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, ModItems.INSANESCANNER_SMITHING_TEMPLATE.get(), INSANESCANNER);
    }

    private static void register(BootstrapContext<TrimPattern> context, Item item, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), ForgeRegistries.ITEMS.getHolder(item).get(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())), false);
        context.register(key, trimPattern);
    }
}
