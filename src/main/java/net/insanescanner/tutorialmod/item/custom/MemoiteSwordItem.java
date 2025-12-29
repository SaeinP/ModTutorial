package net.insanescanner.tutorialmod.item.custom;

import net.insanescanner.tutorialmod.component.ModDataComponentTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class MemoiteSwordItem extends SwordItem {


    public MemoiteSwordItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
