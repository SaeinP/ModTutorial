package net.insanescanner.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SAPPHIRE_APPLE = new FoodProperties.Builder().nutrition(4).
            saturationModifier(0.25f).effect(new MobEffectInstance(MobEffects.REGENERATION, 450, 2), 1.0f).
            effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 2), 1.0f).build();

    public static final FoodProperties ENCHANTED_SAPPHIRE_APPLE = new FoodProperties.Builder().nutrition(4).
            saturationModifier(0.25f).effect(new MobEffectInstance(MobEffects.REGENERATION, 4500, 4), 1.0f).
            effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4000, 3), 1.0f).
            effect(new MobEffectInstance(MobEffects.ABSORPTION, 2000, 4), 1.0f).build();

    public static final FoodProperties SPINACH = new FoodProperties.Builder().nutrition(2).
            saturationModifier(0.25f).build();

    public static final FoodProperties BLUEBERRIES = new FoodProperties.Builder().nutrition(4).
            saturationModifier(0.25f).build();

}