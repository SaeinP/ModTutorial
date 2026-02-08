package net.insanescanner.tutorialmod.block.entity;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.insanescanner.tutorialmod.block.entity.custom.GemCuttingTableBlockEntity;
import net.insanescanner.tutorialmod.block.entity.custom.PedestalBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PedestalBlockEntity>> PEDESTAL_BE =
            BLOCK_ENTITY.register("pedestal_be", () -> BlockEntityType.Builder.of(
                    PedestalBlockEntity::new, ModBlocks.PEDESTAL.get()
            ).build(null));

    public static final RegistryObject<BlockEntityType<GemCuttingTableBlockEntity>> GEM_CUTTING_TABLE_BE =
            BLOCK_ENTITY.register("gem_cutting_table_be", () -> BlockEntityType.Builder.of(
                    GemCuttingTableBlockEntity::new, ModBlocks.GEM_CUTTING_TABLE.get()
            ).build(null));




    public static void register(IEventBus eventBus){
        BLOCK_ENTITY.register(eventBus);
    }


}
