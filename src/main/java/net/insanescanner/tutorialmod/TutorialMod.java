package net.insanescanner.tutorialmod;

import com.mojang.logging.LogUtils;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.insanescanner.tutorialmod.component.ModDataComponentTypes;
import net.insanescanner.tutorialmod.effects.ModEffects;
import net.insanescanner.tutorialmod.enchantments.ModEnchantmentEffects;
import net.insanescanner.tutorialmod.enchantments.ModEnchantments;
import net.insanescanner.tutorialmod.item.ModCreativeModeTabs;
import net.insanescanner.tutorialmod.item.ModItems;
import net.insanescanner.tutorialmod.potion.ModPotions;
import net.insanescanner.tutorialmod.sounds.ModSounds;
import net.insanescanner.tutorialmod.util.ModItemProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tutorialmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();




    public TutorialMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModDataComponentTypes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.SPINACH.get(), 0.4f);
            ComposterBlock.COMPOSTABLES.put(ModItems.SPINACH_SEED.get(), 0.25f);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.RAW_ALEXANDRITE);
            event.accept(ModItems.ALEXANDRITE);
            event.accept(ModItems.RAW_SAPPHIRE);
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.CUT_SAPPHIRE);
            event.accept(ModItems.RAW_MEMOITE);
            event.accept(ModItems.MEMOITE);
            event.accept(ModItems.RAW_OPAL);
            event.accept(ModItems.OPAL);
            event.accept(ModItems.CUT_EMERALD);

            event.accept(ModItems.SAPPHIRE_APPLE);
            event.accept(ModItems.ENCHANTED_SAPPHIRE_APPLE);
            event.accept(ModItems.WRATH_REMNANT);
            event.accept(ModItems.SPINACH);
            event.accept(ModItems.BLUEBERRIES.get());
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK);
            event.accept(ModBlocks.POLISHED_SAPPHIRE_BLOCK);
            event.accept(ModBlocks.ALEXANDRITE_BLOCK);
            event.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK);
            event.accept(ModBlocks.ALEXANDRITE_ORE.get());
            event.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());
            event.accept(ModBlocks.ALEXANDRITE_LAMP);
            event.accept(ModBlocks.MEMOITE_ORE.get());
            event.accept(ModBlocks.MEMOITE_DEEPSLATE_ORE.get());
            event.accept(ModBlocks.MAGIC_BLOCK.get());

            event.accept(ModBlocks.MAHOGANY_LOG);
            event.accept(ModBlocks.MAHOGANY_WOOD);
            event.accept(ModBlocks.STRIPPED_MAHOGANY_LOG);
            event.accept(ModBlocks.STRIPPED_MAHOGANY_WOOD);
            event.accept(ModBlocks.MAHOGANY_PLANKS);

        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.MAGIC_CHISEL.get());
            event.accept(ModItems.OPAL_RING.get());
            event.accept(ModItems.SAPPHIRE_RING.get());
            event.accept(ModItems.EMERALD_RING.get());
            event.accept(ModItems.MEMOITE_PICKAXE.get());
            event.accept(ModItems.MEMOITE_SHOVEL.get());
            event.accept(ModItems.MEMOITE_HOE.get());
            event.accept(ModItems.MEMOITE_AXE.get());
            event.accept(ModItems.MEMOITE_SWORD.get());
            event.accept(ModItems.MEMOITE_HAMMER.get());
            event.accept(ModItems.MEMOITE_BOW.get());
            event.accept(ModItems.MEMOITE_HELMET.get());
            event.accept(ModItems.MEMOITE_CHESTPLATE.get());
            event.accept(ModItems.MEMOITE_LEGGING.get());
            event.accept(ModItems.MEMOITE_BOOTS.get());
            event.accept(ModItems.MEMOITE_HORSE_ARMOR.get());
            event.accept(ModItems.INSANESCANNER_SMITHING_TEMPLATE);
            event.accept(ModItems.BAR_BRAWL_MUSIC_DISC);
            event.accept(ModItems.SPINACH_SEED.get());
            event.accept(ModBlocks.MAHOGANY_SAPLING);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ModItemProperties.addCustomProperties();
        }
    }
}
