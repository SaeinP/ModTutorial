package net.insanescanner.tutorialmod.entity.custom;
import net.insanescanner.tutorialmod.entity.ModEntities;
import net.insanescanner.tutorialmod.item.ModItems;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;

public class MemoiteSwordProjectileEntity extends AbstractArrow {
    private float rotation;
    public Vec2 groundedOffset;
    private ItemStack thrownStack = ItemStack.EMPTY;


    private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK =
            SynchedEntityData.defineId(MemoiteSwordProjectileEntity.class, EntityDataSerializers.ITEM_STACK);

    public MemoiteSwordProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    public MemoiteSwordProjectileEntity(LivingEntity shooter, Level level,ItemStack itemStack) {
        super(ModEntities.MEMOITE_SWORD_PROJECTILE_ENTITY.get(), shooter, level, new ItemStack(ModItems.MEMOITE_SWORD.get()), null);

        this.entityData.set(DATA_ITEM_STACK, itemStack.copy());

    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(DATA_ITEM_STACK, new ItemStack(ModItems.MEMOITE_SWORD.get()));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        // FIX 3: Save the stack from the DataTracker, not the field
        ItemStack stack = this.entityData.get(DATA_ITEM_STACK);
        if (!stack.isEmpty()) {
            pCompound.put("ThrownStack", stack.save(this.level().registryAccess(), new CompoundTag()));
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("ThrownStack", 10)) {
            ItemStack stack = ItemStack.parse(this.level().registryAccess(), pCompound.getCompound("ThrownStack")).orElse(ItemStack.EMPTY);
            // FIX 4: Update the DataTracker when loading from disk
            this.entityData.set(DATA_ITEM_STACK, stack);
        }
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        // This is now the source of truth
        return this.entityData.get(DATA_ITEM_STACK);
    }


    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        //super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 9);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            //this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {


        super.onHitBlock(result);

        if(result.getDirection() == Direction.SOUTH) {
            groundedOffset = new Vec2(215f,180f);
        }
        if(result.getDirection() == Direction.NORTH) {
            groundedOffset = new Vec2(215f, 0f);
        }
        if(result.getDirection() == Direction.EAST) {
            groundedOffset = new Vec2(215f,-90f);
        }
        if(result.getDirection() == Direction.WEST) {
            groundedOffset = new Vec2(215f,90f);
        }

        if(result.getDirection() == Direction.DOWN) {
            groundedOffset = new Vec2(115f,180f);
        }
        if(result.getDirection() == Direction.UP) {
            groundedOffset = new Vec2(285f,180f);
        }
    }
}
