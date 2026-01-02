package net.insanescanner.tutorialmod.item;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.item.custom.*;
import net.insanescanner.tutorialmod.item.custom.memoite_tools.*;
import net.insanescanner.tutorialmod.sounds.ModSounds;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

import static net.minecraft.world.item.Items.registerItem;

public class ModItems {

    private static final UUID ALEXANDRITE_RING_HEALTH_UUID =
            UUID.fromString("d3b1c5a7-8c90-4c73-bb9e-3d1d3c2f8c11");

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

    public static final RegistryObject<Item> RAW_MEMOITE = ITEMS.register("raw_memoite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MEMOITE = ITEMS.register("memoite",
            () -> new MemoiteItem(new Item.Properties()));

    public static final RegistryObject<Item> CUT_EMERALD = ITEMS.register("cut_emerald",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGIC_CHISEL = ITEMS.register("magic_chisel",
            () -> new MagicChiselItem(new Item.Properties().durability(32).stacksTo(1)));

    public static final RegistryObject<Item> OPAL_RING = ITEMS.register("opal_ring",
            () -> new OpalRingItem(new Item.Properties().stacksTo(1)
                    .attributes(OpalRingItem.createAttributes())));

    public static final RegistryObject<Item> SAPPHIRE_RING = ITEMS.register("sapphire_ring",
            () -> new SapphireRingItem(new Item.Properties().stacksTo(1)
                    .attributes(SapphireRingItem.createAttributes())));

    public static final RegistryObject<Item> EMERALD_RING = ITEMS.register("emerald_ring",
            () -> new EmeraldRingItem(new Item.Properties().stacksTo(1)
                    .attributes(EmeraldRingItem.createAttributes())));

    public static final RegistryObject<Item> SAPPHIRE_APPLE =
            ITEMS.register("sapphire_apple", () -> new Item(new Item.Properties().food(ModFoodProperties.SAPPHIRE_APPLE)));

    public static final RegistryObject<Item> ENCHANTED_SAPPHIRE_APPLE =
            ITEMS.register("enchanted_sapphire_apple", () -> new Item(new Item.Properties().food(ModFoodProperties.ENCHANTED_SAPPHIRE_APPLE)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> WRATH_REMNANT = ITEMS.register("wrath_remnant", () -> new WrathRemnantItem(new Item.Properties(), 1500));

    public static final RegistryObject<Item> MEMOITE_SWORD = ITEMS.register("memoite_sword", () -> new MemoiteSwordItem(ModToolTiers.MEMOITE, new Item.Properties().attributes(SwordItem.createAttributes(
            ModToolTiers.MEMOITE, 3, -2.4f
    ))));

    public static final RegistryObject<Item> MEMOITE_PICKAXE = ITEMS.register("memoite_pickaxe", () -> new MemoitePickaxeItem(ModToolTiers.MEMOITE, new Item.Properties().attributes(PickaxeItem.createAttributes(
            ModToolTiers.MEMOITE, 1, -2.8f
    ))));

    public static final RegistryObject<Item> MEMOITE_SHOVEL = ITEMS.register("memoite_shovel", () -> new MemoiteShovelItem(ModToolTiers.MEMOITE, new Item.Properties().attributes(ShovelItem.createAttributes(
            ModToolTiers.MEMOITE, 1.5f, -3.0f
    ))));


    public static final RegistryObject<Item> MEMOITE_AXE = ITEMS.register("memoite_axe", () -> new MemoiteAxeItem(ModToolTiers.MEMOITE, new Item.Properties().attributes(AxeItem.createAttributes(
            ModToolTiers.MEMOITE, 6, -3.2f
    ))));

    public static final RegistryObject<Item> MEMOITE_HOE = ITEMS.register("memoite_hoe", () -> new MemoiteHoeItem(ModToolTiers.MEMOITE, new Item.Properties().attributes(HoeItem.createAttributes(
            ModToolTiers.MEMOITE, 0, -3.0f
    ))));

    public static final RegistryObject<Item> MEMOITE_HAMMER = ITEMS.register("memoite_hammer", () -> new MemoiteHammerItem(ModToolTiers.MEMOITE, new Item.Properties().attributes(PickaxeItem.createAttributes(
            ModToolTiers.MEMOITE, 7, -3.5f
    ))));

    public static final RegistryObject<Item> MEMOITE_ORE_MINER = ITEMS.register("memoite_ore_miner", () -> new MemoiteOreMinerItem(ModToolTiers.MEMOITE, new Item.Properties().attributes(PickaxeItem.createAttributes(
            ModToolTiers.MEMOITE, 7, -3.5f
    ))));

    public static final RegistryObject<Item> MEMOITE_HELMET = ITEMS.register("memoite_helmet", () -> new ModArmorItem(ModArmorMaterials.MEMOITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
            new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(32))));

    public static final RegistryObject<Item> MEMOITE_CHESTPLATE = ITEMS.register("memoite_chestplate", () -> new ArmorItem(ModArmorMaterials.MEMOITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
            new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(32))));

    public static final RegistryObject<Item> MEMOITE_LEGGING = ITEMS.register("memoite_legging", () -> new ArmorItem(ModArmorMaterials.MEMOITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
            new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(32))));

    public static final RegistryObject<Item> MEMOITE_BOOTS = ITEMS.register("memoite_boots", () -> new ArmorItem(ModArmorMaterials.MEMOITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
            new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(32))));

    public static final RegistryObject<Item> MEMOITE_HORSE_ARMOR = ITEMS.register("memoite_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.MEMOITE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
            false, new Item.Properties().stacksTo(1))
            );

    public static final RegistryObject<Item> INSANESCANNER_SMITHING_TEMPLATE = ITEMS.register("insanescanner_armor_trim_smithing_template", () ->
            SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "insanescanner"))
            );

    public static final RegistryObject<Item> MEMOITE_BOW = ITEMS.register("memoite_bow", () -> new BowItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).stacksTo(1)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
