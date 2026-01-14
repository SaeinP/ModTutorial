package net.insanescanner.tutorialmod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class WatchingEntity extends Monster {
    public static final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimout = 0;


    public WatchingEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 600F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));


        this.targetSelector.addGoal(2, new StalkPlayerGoal(this, 0.6f, 30f));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.MOVEMENT_SPEED, .6f)
                .add(Attributes.FOLLOW_RANGE, 150D);
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()){
            this.setupAnimationState();
        }


        Player closestPlayer = this.level().getNearestPlayer(this, 8);



        if (closestPlayer != null) {

            this.remove(RemovalReason.DISCARDED);
            closestPlayer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1));
        }

    }

    //isfood method is for starting the breeding process

    private void setupAnimationState(){
        if(this.idleAnimationTimout <= 0){
            this.idleAnimationTimout = 160;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimout;
        }
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new GroundPathNavigation(this, world);
    }
}
