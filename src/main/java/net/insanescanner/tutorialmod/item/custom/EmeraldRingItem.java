package net.insanescanner.tutorialmod.item.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class EmeraldRingItem extends Item implements Equipable {
    public static final ResourceLocation BASE_PLAYER_DEFENSE = ResourceLocation.withDefaultNamespace("base_defense");
    public static final ResourceLocation BASE_PLAYER_TOUGHNESS = ResourceLocation.withDefaultNamespace("base_toughness");
    public static final ResourceLocation BASE_PLAYER_KNOCKBACK_RES = ResourceLocation.withDefaultNamespace("base_knockback_resistance");

    public EmeraldRingItem(Properties pProperties) {
        super(pProperties);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ARMOR, new AttributeModifier(BASE_PLAYER_DEFENSE, 6.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
                .add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(BASE_PLAYER_TOUGHNESS, 2.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
                .add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(BASE_PLAYER_KNOCKBACK_RES, 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
                .build();
    }

    

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }

}
