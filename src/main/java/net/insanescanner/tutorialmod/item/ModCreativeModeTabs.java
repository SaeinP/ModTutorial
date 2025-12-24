package net.insanescanner.tutorialmod.item;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("tutorial_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.tutorialmod.tutorial_mod_items"))
                    .displayItems((itemDisplayParameters, output)-> {
                        output.accept(ModItems.ALEXANDRITE.get());
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModItems.RAW_ALEXANDRITE.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        output.accept(ModItems.RAW_SAPPHIRE.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.CUT_SAPPHIRE.get());
                        output.accept(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get());

                    }).build());


    public static final RegistryObject<CreativeModeTab> TUTORIAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("tutorial_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get()))
                    .withTabsBefore(TUTORIAL_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.tutorial_mod_blocks"))
                    .displayItems((itemDisplayParameters, output)-> {
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
