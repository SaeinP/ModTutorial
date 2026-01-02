package net.insanescanner.tutorialmod.effects;

import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SlimeyEffect extends MobEffect {
    public SlimeyEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {


        if(pLivingEntity.horizontalCollision){
            Vec3 initVector = pLivingEntity.getDeltaMovement();
            double yMotion;
            if (pLivingEntity.isShiftKeyDown()) {
                yMotion = 0;
            } else if (pLivingEntity.zza > 0 || pLivingEntity.xxa != 0) {
                yMotion = 0.2D;

            } else {
                yMotion = -0.2D;
            }
            Vec3 climbVector = new Vec3(initVector.x, yMotion, initVector.z);
            pLivingEntity.setDeltaMovement(climbVector.scale(0.96));

            return true;
        }

        return super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}