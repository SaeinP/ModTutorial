package net.insanescanner.tutorialmod.entity.custom;

import net.insanescanner.tutorialmod.entity.WatchingEntityVariant;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.NoteBlockEvent;
import org.jetbrains.annotations.Nullable;

public class WatchingEntity extends Monster {
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(WatchingEntity.class, EntityDataSerializers.INT);

    public static final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimout = 0;
    private int messageTimeout = 0;
    private Player closePlyr = null;
    private int lifetime = 1000;

    private final ServerBossEvent BOSS_EVENT = new ServerBossEvent(Component.literal("Some dude"),
            BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.NOTCHED_10);



    public WatchingEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.9f, true){



            @Override
            public boolean canUse() {

                return WatchingEntity.this.getVariant() == WatchingEntityVariant.ATTACK
                        && super.canUse();

            }
        });

        /*this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.35f, 60f)
        {
            @Override
            public boolean canUse() {
                return WatchingEntity.this.getVariant() == WatchingEntityVariant.ATTACK && super.canUse() && WatchingEntity.this.getTarget() instanceof Player;
            }
        });*/

        this.targetSelector.addGoal(3, new StalkPlayerGoal(this, 0.9f, 30f){

            @Override
            public boolean canUse() {
                return WatchingEntity.this.getVariant() == WatchingEntityVariant.STALK && super.canUse();
            }
        });


        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 140f){
            @Override
            public boolean canUse() {

                if(closePlyr != null && messageTimeout <= 0){
                    closePlyr.displayClientMessage( Component.literal("You feel watched."), true);
                }

                return super.canUse();
            }
        });


    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.MOVEMENT_SPEED, .9f)
                .add(Attributes.FOLLOW_RANGE, 1500D)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 3.2f);
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()){
            this.setupAnimationState();
        }

        Player closestPlayer = this.level().getNearestPlayer(this, 8);

        Player closestPlayer2 = this.level().getNearestPlayer(this, 40);

        if (closestPlayer != null) {

            this.setVariant(WatchingEntityVariant.byId(1));
            //this.remove(RemovalReason.DISCARDED);
            closestPlayer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1));
        }



        if(closestPlayer2 != null && messageTimeout <= 0){
            messageTimeout = 600 + level().getRandom().nextInt(300);
            closePlyr = closestPlayer2;
        } else {
            messageTimeout--;
        }

        if(lifetime <= 0){
            this.discard();
        } else {
            lifetime--;
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

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pState) {
        super.playStepSound(pPos, pState);


            this.playSound(SoundEvents.GRASS_STEP, 0.25F, 0.9F);


    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    // Variant


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(VARIANT, 0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public WatchingEntityVariant getVariant() {
        return WatchingEntityVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(WatchingEntityVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);

        pCompound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(VARIANT, pCompound.getInt("Variant"));
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
        this.setVariant(WatchingEntityVariant.byId(0));

        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENDERMAN_STARE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.PLAYER_HURT;
    }

    @Override
    public void playAmbientSound() {
        if (!this.level().isClientSide && this.random.nextInt(200) == 0) { // random chance
            this.playSound(SoundEvents.ENDERMAN_STARE, 0.2F, 0.9F + this.random.nextFloat() * 0.2F);
        }
    }

    // Boss Event Stuff


    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {

        super.startSeenByPlayer(pServerPlayer);
        //this.BOSS_EVENT.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        //this.BOSS_EVENT.removePlayer(pServerPlayer);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        //this.BOSS_EVENT.setProgress(this.getHealth()/this.getMaxHealth());
    }


}
