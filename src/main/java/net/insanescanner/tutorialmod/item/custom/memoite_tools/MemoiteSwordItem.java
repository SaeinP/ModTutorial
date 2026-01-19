package net.insanescanner.tutorialmod.item.custom.memoite_tools;

import net.insanescanner.tutorialmod.component.ModDataComponentTypes;
import net.insanescanner.tutorialmod.entity.custom.MemoiteSwordProjectileEntity;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.event.level.BlockEvent;

import java.util.List;

public class MemoiteSwordItem extends SwordItem { ;


    public MemoiteSwordItem(Tier pTier, Properties pProperties) {

        super(pTier, pProperties);

    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {

        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.memoite_sword.shifted"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.memoite_sword.non_shifted"));
        }
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);



        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            if(pPlayer.getOffhandItem().is(Items.SHIELD)){
                return new InteractionResultHolder<>(InteractionResult.FAIL, itemstack);
            }
            System.out.println("CREATING ENTITY");
            MemoiteSwordProjectileEntity MemoiteSwordProjectile = new MemoiteSwordProjectileEntity((LivingEntity) pPlayer, pLevel);
            System.out.println("CREATING ENTITY2");
            MemoiteSwordProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0F);

            System.out.println("CREATING ENTITY3");
            pLevel.addFreshEntity(MemoiteSwordProjectile);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {

            pPlayer.hurt(pPlayer.damageSources().thrown(pPlayer, pPlayer), 5);
            itemstack.hurtAndBreak(10, pPlayer, EquipmentSlot.MAINHAND);
            pPlayer.getCooldowns().addCooldown(this, 300);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }


    private static boolean playerHasShieldUseIntent(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        return pContext.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

}
