package net.insanescanner.tutorialmod.event;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.item.ModItems;
import net.insanescanner.tutorialmod.item.custom.ModArmorMaterials;
import net.insanescanner.tutorialmod.item.custom.memoite_tools.MemoiteHammerItem;
import net.insanescanner.tutorialmod.item.custom.memoite_tools.MemoiteOreMinerItem;
import net.insanescanner.tutorialmod.item.custom.memoite_tools.OreMinerItem;
import net.insanescanner.tutorialmod.potion.ModPotions;
import net.insanescanner.tutorialmod.villagers.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    private static final Set<BlockPos> ORE_MINER_HARVESTED_BLOCKS = new HashSet<>();
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof MemoiteHammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : MemoiteHammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }

        }
    }
    @SubscribeEvent
    public static void onLivingDamagEvent(LivingDamageEvent event){
        if(event.getEntity() instanceof Player player){
            boolean memoite = true;
            for(ItemStack item : player.getArmorSlots()){
                if(!(item.getItem() instanceof ArmorItem armorItem)){
                    memoite = false;
                    break;
                }

                if(armorItem.getMaterial() != ModArmorMaterials.MEMOITE_ARMOR_MATERIAL){
                    memoite = false;
                    break;
                }
            }

            if(memoite){
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 1, true, false));
                player.sendSystemMessage(Component.literal("Bro stop taking damage"));
            }
        }

    }


    @SubscribeEvent
    public static void onOreMinerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();



        if(mainHandItem.getItem() instanceof OreMinerItem oreminer && player instanceof ServerPlayer serverPlayer) {


            BlockPos initialBlockPos = event.getPos();
            if(ORE_MINER_HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : MemoiteOreMinerItem.getBlocksToBeDestroyed(initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !oreminer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                ORE_MINER_HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                ORE_MINER_HARVESTED_BLOCKS.remove(pos);
            }

        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(BrewingRecipeRegisterEvent event){
        PotionBrewing.Builder builder = event.getBuilder();
        builder.addMix(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION.getHolder().get());


    }


    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType() == VillagerProfession.FARMER){
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemCost(Items.EMERALD, 5),
                    new ItemStack(ModItems.SPINACH.get(), 9), 6, 4, 0.85f) );

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ModItems.SPINACH_SEED.get(), 2), 5, 4, 0.85f) );

        }

        if(event.getType() == ModVillagers.ESTEEMED_VILLAGER.get()){
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemCost(ModItems.SAPPHIRE.get(), 1),
                    new ItemStack(ModItems.WRATH_REMNANT.get(), 1), 6, 4, 0.85f) );



        }
    }
}
