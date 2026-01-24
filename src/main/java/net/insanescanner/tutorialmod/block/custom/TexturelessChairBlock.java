package net.insanescanner.tutorialmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.insanescanner.tutorialmod.entity.ModEntities;
import net.insanescanner.tutorialmod.entity.custom.TexturelessChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TexturelessChairBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<TexturelessChairBlock> CODEC = simpleCodec(TexturelessChairBlock::new);

    public static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14, 12, 14);
    //public static final VoxelShape BACK = Block.box(2.0, 12.0, 2.0, 14.0, 25.0, 4.0);

    public TexturelessChairBlock(Properties pProperties) {

        super(pProperties);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {

        pBuilder.add(FACING);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            Entity entity = null;
            List<TexturelessChairEntity> entities = level.getEntities(ModEntities.TEXTURELESS_CHAIR_ENTITY.get(), new AABB(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.TEXTURELESS_CHAIR_ENTITY.get().spawn((ServerLevel) level, pos, MobSpawnType.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
    }
}
