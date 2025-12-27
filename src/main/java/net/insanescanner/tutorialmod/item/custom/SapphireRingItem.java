package net.insanescanner.tutorialmod.item.custom;

import net.insanescanner.tutorialmod.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import java.util.List;

public class SapphireRingItem extends Item implements Equipable {
    public static final ResourceLocation BASE_PLAYER_HEALTH = ResourceLocation.withDefaultNamespace("base_health");
    public static final ResourceLocation BASE_PLAYER_JUMP = ResourceLocation.withDefaultNamespace("base_jump_strength");

    public SapphireRingItem(Properties pProperties) {
        super(pProperties);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.MAX_HEALTH, new AttributeModifier(BASE_PLAYER_HEALTH, 6.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
                .build();
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pEntity instanceof LivingEntity entity){
            if(entity.getItemInHand(InteractionHand.OFF_HAND).getItem() == ModItems.SAPPHIRE_RING.get()){
                if(!entity.hasEffect(MobEffects.REGENERATION)) {
                    entity.addEffect(new MobEffectInstance(
                            MobEffects.REGENERATION,
                            100,
                            1,
                            true,
                            false
                    ));
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.sapphire_ring.shifted"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.sapphire_ring.non_shifted"));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
