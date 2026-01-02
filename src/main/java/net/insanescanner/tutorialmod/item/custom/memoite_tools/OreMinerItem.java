package net.insanescanner.tutorialmod.item.custom.memoite_tools;

import net.insanescanner.tutorialmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OreMinerItem extends PickaxeItem {


    public OreMinerItem(Tier p_42961_, Properties p_42964_) {

        super(p_42961_, p_42964_);
    }




    public static HashSet<BlockPos> getBlocksToBeDestroyed(BlockPos initalBlockPos, ServerPlayer player) {
       HashSet<BlockPos> positions = new HashSet<>();
       Queue<BlockPos> nextBlockToAdd = new LinkedList<>();

        ItemStack mainHandItem = player.getMainHandItem();
        int MAX_AMOUNT;
        if(player.getMainHandItem().getItem() instanceof OreMinerItem oreMinerItem){
            MAX_AMOUNT = getMaxAmntForOreMiner(oreMinerItem);
        } else {
            MAX_AMOUNT = 10;
        }

        Level level = player.level();
        nextBlockToAdd.add(initalBlockPos);

        while(positions.size() <= MAX_AMOUNT && !nextBlockToAdd.isEmpty()){
            BlockPos current = nextBlockToAdd.poll();
            if (positions.contains(current)){
                continue;
            }

            if(isOre(level, current)){
                positions.add(current);
                nextBlockToAdd.add(current.north());
                nextBlockToAdd.add(current.south());
                nextBlockToAdd.add(current.east());
                nextBlockToAdd.add(current.west());
                nextBlockToAdd.add(current.above());
                nextBlockToAdd.add(current.below());

            }

        }

        return positions;
    }

    public static boolean isOre(Level world, BlockPos pos) {
        return world.getBlockState(pos).is(Blocks.COAL_ORE) ||
                world.getBlockState(pos).is(Blocks.DEEPSLATE_COAL_ORE)
                || world.getBlockState(pos).is(Blocks.IRON_ORE)
                || world.getBlockState(pos).is(Blocks.DEEPSLATE_IRON_ORE)
                || world.getBlockState(pos).is(Blocks.GOLD_ORE)
                || world.getBlockState(pos).is(Blocks.DEEPSLATE_GOLD_ORE)
                || world.getBlockState(pos).is(Blocks.DIAMOND_ORE)
                || world.getBlockState(pos).is(Blocks.DEEPSLATE_DIAMOND_ORE)
                || world.getBlockState(pos).is(Blocks.REDSTONE_ORE)
                || world.getBlockState(pos).is(Blocks.DEEPSLATE_REDSTONE_ORE)
                || world.getBlockState(pos).is(Blocks.LAPIS_ORE)
                || world.getBlockState(pos).is(Blocks.DEEPSLATE_LAPIS_ORE)
                || world.getBlockState(pos).is(Blocks.EMERALD_ORE)
                || world.getBlockState(pos).is(Blocks.DEEPSLATE_EMERALD_ORE)
                || world.getBlockState(pos).is(Blocks.NETHER_QUARTZ_ORE)
                || world.getBlockState(pos).is(ModBlocks.MEMOITE_ORE.get())
                || world.getBlockState(pos).is(ModBlocks.MEMOITE_DEEPSLATE_ORE.get())
                || world.getBlockState(pos).is(ModBlocks.SAPPHIRE_ORE.get())
                || world.getBlockState(pos).is(ModBlocks.SAPPHIRE_DEEPSLATE_ORE.get());
    }

    private static int getMaxAmntForOreMiner(OreMinerItem oreminer){
        if(oreminer instanceof MemoiteOreMinerItem){
            return 30;
        }
        return 10;
    }

}
