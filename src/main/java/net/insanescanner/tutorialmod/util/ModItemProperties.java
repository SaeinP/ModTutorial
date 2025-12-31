package net.insanescanner.tutorialmod.util;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.component.ModDataComponentTypes;
import net.insanescanner.tutorialmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ModItemProperties {

    public static void addCustomProperties(){
        ItemProperties.register(ModItems.MAGIC_CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "used"), (itemStack, clientLevel, livingentity, i)
                -> itemStack.get(ModDataComponentTypes.COORDINATE.get()) != null ? 1f : 0f);

    }
}
