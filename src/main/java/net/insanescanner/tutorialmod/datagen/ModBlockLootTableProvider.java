package net.insanescanner.tutorialmod.datagen;

import net.insanescanner.tutorialmod.block.ModBlocks;
import net.insanescanner.tutorialmod.block.custom.AlexandriteLampBlock;
import net.insanescanner.tutorialmod.block.custom.SpinachCropBlock;
import net.insanescanner.tutorialmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public class ModBlockLootTableProvider extends BlockLootSubProvider {


    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.UNPOLISHED_SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.POLISHED_SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());

        dropSelf(ModBlocks.ALEXANDRITE_BUTTON.get());
        dropSelf(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.ALEXANDRITE_TRAPDOOR.get());
        //dropSelf(ModBlocks.ALEXANDRITE_DOOR.get());
        dropSelf(ModBlocks.ALEXANDRITE_SLAB.get());
        dropSelf(ModBlocks.ALEXANDRITE_STAIR.get());
        dropSelf(ModBlocks.ALEXANDRITE_WALL.get());
        dropSelf(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
        dropSelf(ModBlocks.ALEXANDRITE_FENCE.get());

        dropSelf(ModBlocks.UNPOLISHED_SAPPHIRE_STAIR.get());
        dropSelf(ModBlocks.POLISHED_SAPPHIRE_STAIR.get());
        dropSelf(ModBlocks.UNPOLISHED_SAPPHIRE_SLAB.get());
        dropSelf(ModBlocks.POLISHED_SAPPHIRE_SLAB.get());

        dropSelf(ModBlocks.ALEXANDRITE_LAMP.get());

        this.add(ModBlocks.ALEXANDRITE_DOOR.get(),
                block -> createDoorTable(ModBlocks.ALEXANDRITE_DOOR.get()));

        this.add(ModBlocks.MAGIC_BLOCK.get(),
                block -> createMagicBlockDrops(ModBlocks.MAGIC_BLOCK.get(), 1.00F, 1.00F, 1.00F, 1.00F, 1.00F));

        this.add(ModBlocks.ALEXANDRITE_ORE.get(),
        block -> createMultipleOreDrops(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get(), 1, 1));

        this.add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get(), 1, 2));

        this.add(ModBlocks.MEMOITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.MEMOITE_ORE.get(), ModItems.RAW_MEMOITE.get(), 1, 1));

        this.add(ModBlocks.MEMOITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.MEMOITE_ORE.get(), ModItems.RAW_MEMOITE.get(), 1, 2));


        this.add(ModBlocks.SAPPHIRE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SAPPHIRE_DEEPSLATE_ORE.get(), ModItems.SAPPHIRE.get(), 1, 2));

        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get(), 1, 1));

        this.add(ModBlocks.OPAL_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.OPAL_END_ORE.get(), ModItems.RAW_OPAL.get(), 1, 1));

        this.add(ModBlocks.RUBY_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.RUBY_NETHER_ORE.get(), ModItems.RUBY.get(), 1, 1));

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SPINACH_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SpinachCropBlock.AGE, SpinachCropBlock.MAX_AGE));

        this.add(ModBlocks.SPINACH_CROP.get(), this.createCropDrops(ModBlocks.SPINACH_CROP.get(),
            ModItems.SPINACH.get(), ModItems.SPINACH_SEED.get(), lootItemConditionBuilder));

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);


        this.add(ModBlocks.BLUEBERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrop, float maxDrop) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrop, maxDrop)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    protected LootTable.Builder createMagicBlockDrops(Block pMagicBlock, float... pChances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createMagicDrops(pMagicBlock, pChances)
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.doesNotHaveSilkTouch())
                                .add(
                                        ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(pMagicBlock, LootItem.lootTableItem(Items.DIAMOND).apply(SetItemCountFunction.setCount(UniformGenerator.between(0f, 2f)))))
                                                .when(
                                                        BonusLevelTableCondition.bonusLevelFlatChance(
                                                                registrylookup.getOrThrow(Enchantments.FORTUNE), pChances
                                                        )
                                                )
                                )
                );
    }

    protected LootTable.Builder createMagicDrops(Block pMagicBlock, float... pChances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                        pMagicBlock,
                        ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(pMagicBlock, LootItem.lootTableItem(Items.GOLD_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(0f, 2f)))))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), pChances))
                )
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.doesNotHaveSilkTouch())
                                .add(
                                        ((LootPoolSingletonContainer.Builder)this.applyExplosionDecay(
                                                pMagicBlock, LootItem.lootTableItem(Items.EMERALD).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 7.0F)))
                                        ))
                                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), new float[]{0.7F, 0.722222223F, 0.725F, 0.73333335F, 0.9F}))
                                )
                );
    }



}
