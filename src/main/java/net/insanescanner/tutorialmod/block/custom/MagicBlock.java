package net.insanescanner.tutorialmod.block.custom;

import net.insanescanner.tutorialmod.item.ModItems;
import net.insanescanner.tutorialmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fml.common.Mod;

public class MagicBlock extends Block {

    private static boolean clickedBefore = false;

    public MagicBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        MobEffectInstance RESISTANCE = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 1);
        MobEffectInstance BLINDNESS = new MobEffectInstance(MobEffects.BLINDNESS, 200, 1);

        if(pEntity instanceof Player && !pLevel.isClientSide()){
            ((Player) pEntity).giveExperienceLevels(10);
            ((Player) pEntity).addEffect(RESISTANCE, pEntity);
            ((Player) pEntity).addEffect(BLINDNESS, pEntity);
        }
        if(pEntity instanceof ItemEntity itemEntity){
            if(isValidItem(itemEntity.getItem())){
                itemEntity.setItem(new ItemStack(Items.EMERALD, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == ModItems.CUT_SAPPHIRE.get()){
                itemEntity.setItem(new ItemStack(ModItems.SAPPHIRE.get(), itemEntity.getItem().getCount()));
            }
        }

        if(pEntity instanceof LivingEntity livingEntity && !(pEntity instanceof Player)){
            livingEntity.setInvisible(true);

        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_TO_EMERALD);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if(!pLevel.isClientSide()){

            pPlayer.hurt(pLevel.damageSources().playerAttack(pPlayer), 1.0f);
            if(!clickedBefore){
                clickedBefore = true;
                pPlayer.sendSystemMessage(Component.literal("The mod heard you."));
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {

        if(!pLevel.isClientSide()){

            if(pStack.getItem() == ModItems.CUT_EMERALD.get()){
                if(pPlayer instanceof Player){
                    pPlayer.setItemInHand(pHand, new ItemStack(ModItems.CUT_SAPPHIRE.get(), pStack.getCount()));

                }
            }
            if(!clickedBefore){
                clickedBefore = true;
                pPlayer.sendSystemMessage(Component.literal("The mod heard you."));
            }

        }

        return ItemInteractionResult.SUCCESS;
    }


}
