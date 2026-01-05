package net.insanescanner.tutorialmod.datagen;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.block.ModBlocks;
import net.insanescanner.tutorialmod.block.custom.AlexandriteLampBlock;
import net.insanescanner.tutorialmod.block.custom.SpinachCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        blockWithItem(ModBlocks.MEMOITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.MEMOITE_ORE);

        blockWithItem(ModBlocks.SAPPHIRE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.POLISHED_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK);

        blockWithItem(ModBlocks.MAGIC_BLOCK);


        stairsBlock(ModBlocks.ALEXANDRITE_STAIR.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        blockItem(ModBlocks.ALEXANDRITE_STAIR);

        slabBlock(ModBlocks.ALEXANDRITE_SLAB.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        blockItem(ModBlocks.ALEXANDRITE_SLAB);

        buttonBlock(ModBlocks.ALEXANDRITE_BUTTON.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));


        pressurePlateBlock(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);

        doorBlockWithRenderType(ModBlocks.ALEXANDRITE_DOOR.get(), modLoc("block/alexandrite_door_bottom"), modLoc("block/alexandrite_door_top"), "cutout");


        trapdoorBlockWithRenderType(ModBlocks.ALEXANDRITE_TRAPDOOR.get(), modLoc("block/alexandrite_trapdoor"),true, "cutout");
        blockItem(ModBlocks.ALEXANDRITE_TRAPDOOR, "_bottom");

        wallBlock(ModBlocks.ALEXANDRITE_WALL.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));


        fenceBlock(ModBlocks.ALEXANDRITE_FENCE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));


        fenceGateBlock(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        blockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);

        stairsBlock(ModBlocks.UNPOLISHED_SAPPHIRE_STAIR.get(), blockTexture(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get()));
        blockItem(ModBlocks.UNPOLISHED_SAPPHIRE_STAIR);

        slabBlock(ModBlocks.UNPOLISHED_SAPPHIRE_SLAB.get(), blockTexture(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get()), blockTexture(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get()));
        blockItem(ModBlocks.UNPOLISHED_SAPPHIRE_SLAB);

        stairsBlock(ModBlocks.POLISHED_SAPPHIRE_STAIR.get(), blockTexture(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get()));
        blockItem(ModBlocks.POLISHED_SAPPHIRE_STAIR);

        slabBlock(ModBlocks.POLISHED_SAPPHIRE_SLAB.get(), blockTexture(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get()), blockTexture(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get()));
        blockItem(ModBlocks.POLISHED_SAPPHIRE_SLAB);

        customLamp();

        makeCrop((CropBlock) ModBlocks.SPINACH_CROP.get(), "spinach_crop_stage", "spinach_crop_stage");

    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SpinachCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(((SpinachCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.ALEXANDRITE_LAMP.get()).forAllStates(state -> {
            if(state.getValue(AlexandriteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("alexandrite_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "alexandrite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("alexandrite_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "alexandrite_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.ALEXANDRITE_LAMP.get(), models().cubeAll("alexandrite_lamp_on",
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "alexandrite_lamp_on")));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

}
