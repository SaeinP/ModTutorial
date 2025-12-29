package net.insanescanner.tutorialmod.block;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.custom.AlexandriteLampBlock;
import net.insanescanner.tutorialmod.block.custom.MagicBlock;
import net.insanescanner.tutorialmod.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.material.MaterialRuleList;
import net.minecraftforge.client.model.obj.ObjMaterialLibrary;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> UNPOLISHED_SAPPHIRE_BLOCK = registerBlock("unpolished_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).
                    requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> POLISHED_SAPPHIRE_BLOCK = registerBlock("polished_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).
                    requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).
                    requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ALEXANDRITE_DEEPSLATE_ORE = registerBlock("alexandrite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,5),BlockBehaviour.Properties.of().strength(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> MEMOITE_ORE = registerBlock("memoite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel(state -> 5)));

    public static final RegistryObject<Block> MEMOITE_DEEPSLATE_ORE = registerBlock("memoite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,5),BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE).lightLevel(state -> 5)));

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,5),BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> SAPPHIRE_DEEPSLATE_ORE = registerBlock("sapphire_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,6),BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<StairBlock> UNPOLISHED_SAPPHIRE_STAIR = registerBlock("unpolished_sapphire_stair",
            () -> new StairBlock(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()
                    ));

    public static final RegistryObject<StairBlock> POLISHED_SAPPHIRE_STAIR = registerBlock("polished_sapphire_stair",
            () -> new StairBlock(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> UNPOLISHED_SAPPHIRE_SLAB = registerBlock("unpolished_sapphire_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> POLISHED_SAPPHIRE_SLAB = registerBlock("polished_sapphire_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<StairBlock> ALEXANDRITE_STAIR = registerBlock("alexandrite_stair",
            () -> new StairBlock(ModBlocks.ALEXANDRITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> ALEXANDRITE_SLAB = registerBlock("alexandrite_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<PressurePlateBlock> ALEXANDRITE_PRESSURE_PLATE = registerBlock("alexandrite_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<ButtonBlock> ALEXANDRITE_BUTTON = registerBlock("alexandrite_button",
            () -> new ButtonBlock(BlockSetType.IRON, 35,
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noCollission()
            ));

    public static final RegistryObject<FenceBlock> ALEXANDRITE_FENCE = registerBlock("alexandrite_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<FenceGateBlock> ALEXANDRITE_FENCE_GATE = registerBlock("alexandrite_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA,
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<WallBlock> ALEXANDRITE_WALL = registerBlock("alexandrite_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<DoorBlock> ALEXANDRITE_DOOR = registerBlock("alexandrite_door",
            () -> new DoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()
            ));

    public static final RegistryObject<TrapDoorBlock> ALEXANDRITE_TRAPDOOR = registerBlock("alexandrite_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()
            ));

    public static final RegistryObject<Block> ALEXANDRITE_LAMP = registerBlock("alexandrite_lamp",
            () -> new AlexandriteLampBlock(BlockBehaviour.Properties.of().strength(3f).lightLevel(state -> state.getValue(AlexandriteLampBlock.CLICKED) ? 15 : 0))
    );



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }



    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }

}
