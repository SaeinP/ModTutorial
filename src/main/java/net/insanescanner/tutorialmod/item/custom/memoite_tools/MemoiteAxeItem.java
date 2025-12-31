package net.insanescanner.tutorialmod.item.custom.memoite_tools;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import java.util.List;

public class MemoiteAxeItem extends AxeItem {


    public MemoiteAxeItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
