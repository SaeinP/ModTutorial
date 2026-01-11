package net.insanescanner.tutorialmod.block;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.custom.*;
import net.insanescanner.tutorialmod.item.ModItems;
import net.insanescanner.tutorialmod.sounds.ModSounds;
import net.insanescanner.tutorialmod.worldgen.tree.ModTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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

    public static final RegistryObject<Block> OPAL_END_ORE = registerBlock("opal_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,6),BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> RUBY_NETHER_ORE = registerBlock("ruby_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,6),BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f)
                    .requiresCorrectToolForDrops().sound(ModSounds.MAGIC_BLOCK_SOUNDS).randomTicks()));

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

    public static final RegistryObject<Block> SPINACH_CROP = BLOCKS.register("spinach_crop", () ->
            new SpinachCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush", () ->
            new BlueberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final RegistryObject<RotatedPillarBlock> MAHOGANY_LOG = registerBlock("mahogany_log", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> MAHOGANY_WOOD = registerBlock("mahogany_wood", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MAHOGANY_LOG = registerBlock("stripped_mahogany_log", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MAHOGANY_WOOD = registerBlock("stripped_mahogany_wood", () ->
            new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> MAHOGANY_PLANKS = registerBlock("mahogany_planks", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> MAHOGANY_LEAVES = registerBlock("mahogany_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            }
    );

    public static final RegistryObject<Block> FLOWERING_MAHOGANY_LEAVES = registerBlock("flowering_mahogany_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            }
    );

    public static final RegistryObject<Block> MAHOGANY_SAPLING = registerBlock("mahogany_sapling", () ->
            new SaplingBlock(ModTreeGrower.MAHOGANY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

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
