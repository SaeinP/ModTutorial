package net.insanescanner.tutorialmod.datagen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_ALEXANDRITE.get());
        basicItem(ModItems.ALEXANDRITE.get());

        basicItem(ModItems.RAW_SAPPHIRE.get());
        basicItem(ModItems.SAPPHIRE.get());
        basicItem(ModItems.CUT_SAPPHIRE.get());
        basicItem(ModItems.SAPPHIRE_RING.get());

        basicItem(ModItems.CUT_EMERALD.get());
        basicItem(ModItems.EMERALD_RING.get());

        basicItem(ModItems.OPAL_RING.get());

        basicItem(ModItems.WRATH_REMNANT.get());

        basicItem(ModItems.MAGIC_CHISEL.get());

        basicItem(ModItems.SAPPHIRE_APPLE.get());
        basicItem(ModItems.ENCHANTED_SAPPHIRE_APPLE.get());
    }
}
