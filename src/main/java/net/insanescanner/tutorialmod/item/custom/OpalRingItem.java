package net.insanescanner.tutorialmod.item.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class OpalRingItem extends Item implements Equipable {

    public static final ResourceLocation BASE_PLAYER_HEALTH = ResourceLocation.withDefaultNamespace("base_health");
    public static final ResourceLocation BASE_PLAYER_JUMP = ResourceLocation.withDefaultNamespace("base_jump_strength");
    public static final ResourceLocation BASE_PLAYER_SPEED = ResourceLocation.withDefaultNamespace("base_speed");

    public OpalRingItem(Properties pProperties) {
        super(pProperties);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.FLYING_SPEED, new AttributeModifier(BASE_PLAYER_HEALTH, 1.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER, new AttributeModifier(BASE_PLAYER_HEALTH, -0.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
                .add(Attributes.JUMP_STRENGTH, new AttributeModifier(BASE_PLAYER_JUMP, 0.15, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
                .add(Attributes.MOVEMENT_SPEED, new AttributeModifier(BASE_PLAYER_SPEED, 0.1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
                .build();
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }


}
