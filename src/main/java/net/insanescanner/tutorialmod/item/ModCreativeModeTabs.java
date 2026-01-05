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
                        output.accept(ModItems.RAW_ALEXANDRITE.get());
                        output.accept(ModItems.MEMOITE.get());
                        output.accept(ModItems.RAW_MEMOITE.get());
                        output.accept(ModItems.RAW_SAPPHIRE.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.CUT_SAPPHIRE.get());
                        output.accept(ModItems.SAPPHIRE_APPLE.get());
                        output.accept(ModItems.ENCHANTED_SAPPHIRE_APPLE.get());
                        output.accept(ModItems.MAGIC_CHISEL.get());
                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                        output.accept(ModItems.OPAL_RING.get());
                        output.accept(ModItems.SAPPHIRE_RING.get());
                        output.accept(ModItems.CUT_EMERALD.get());
                        output.accept(ModItems.WRATH_REMNANT.get());

                        output.accept(ModItems.MEMOITE_PICKAXE.get());
                        output.accept(ModItems.MEMOITE_SHOVEL.get());
                        output.accept(ModItems.MEMOITE_HOE.get());
                        output.accept(ModItems.MEMOITE_AXE.get());
                        output.accept(ModItems.MEMOITE_SWORD.get());
                        output.accept(ModItems.MEMOITE_HAMMER.get());
                        output.accept(ModItems.MEMOITE_BOW.get());

                        output.accept(ModItems.MEMOITE_HELMET.get());
                        output.accept(ModItems.MEMOITE_CHESTPLATE.get());
                        output.accept(ModItems.MEMOITE_LEGGING.get());
                        output.accept(ModItems.MEMOITE_BOOTS.get());

                        output.accept(ModItems.MEMOITE_HORSE_ARMOR.get());
                        output.accept(ModItems.INSANESCANNER_SMITHING_TEMPLATE.get());

                        output.accept(ModItems.SPINACH_SEED.get());
                    }).build());


    public static final RegistryObject<CreativeModeTab> TUTORIAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("tutorial_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get()))
                    .withTabsBefore(TUTORIAL_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.tutorial_mod_blocks"))
                    .displayItems((itemDisplayParameters, output)-> {
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

                        output.accept(ModBlocks.ALEXANDRITE_LAMP.get());

                        output.accept(ModBlocks.ALEXANDRITE_DOOR.get());
                        output.accept(ModBlocks.ALEXANDRITE_TRAPDOOR.get());

                        output.accept(ModBlocks.ALEXANDRITE_BUTTON.get());
                        output.accept(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.ALEXANDRITE_FENCE.get());
                        output.accept(ModBlocks.ALEXANDRITE_FENCE_GATE.get());

                        output.accept(ModBlocks.ALEXANDRITE_WALL.get());

                        output.accept(ModBlocks.ALEXANDRITE_STAIR.get());
                        output.accept(ModBlocks.ALEXANDRITE_SLAB.get());


                        output.accept(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.UNPOLISHED_SAPPHIRE_STAIR.get());
                        output.accept(ModBlocks.UNPOLISHED_SAPPHIRE_SLAB.get());

                        output.accept(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_SAPPHIRE_STAIR.get());
                        output.accept(ModBlocks.POLISHED_SAPPHIRE_SLAB.get());

                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.SAPPHIRE_DEEPSLATE_ORE.get());




                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                    }).build());


    public static final RegistryObject<CreativeModeTab> TUTORIAL_ACTIONABLE_TAB =
            CREATIVE_MODE_TABS.register("tutorial_actionables_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MAGIC_CHISEL.get()))
                            .withTabsBefore(TUTORIAL_BLOCKS_TAB.getId())
                            .title(Component.translatable("creativetab.tutorialmod.tutorial_mod_actionables"))
                            .displayItems((itemDisplayParameters, output)-> {
                                output.accept(ModItems.MAGIC_CHISEL.get());
                                output.accept(ModItems.OPAL_RING.get());
                                output.accept(ModItems.SAPPHIRE_RING.get());
                                output.accept(ModItems.EMERALD_RING.get());

                                output.accept(ModItems.MEMOITE_PICKAXE.get());
                                output.accept(ModItems.MEMOITE_SHOVEL.get());
                                output.accept(ModItems.MEMOITE_HOE.get());
                                output.accept(ModItems.MEMOITE_AXE.get());
                                output.accept(ModItems.MEMOITE_SWORD.get());
                                output.accept(ModItems.MEMOITE_BOW.get());
                                output.accept(ModItems.MEMOITE_ORE_MINER.get());
                                output.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());

                                output.accept(ModItems.SPINACH_SEED.get());
                            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
