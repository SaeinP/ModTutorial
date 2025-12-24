package net.insanescanner.tutorialmod.item;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.item.custom.MagicChiselItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CUT_SAPPHIRE = ITEMS.register("cut_sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGIC_CHISEL = ITEMS.register("magic_chisel",
            () -> new MagicChiselItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
