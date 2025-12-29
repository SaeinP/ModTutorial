package net.insanescanner.tutorialmod.item.custom;

import net.insanescanner.tutorialmod.component.ModDataComponentTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.unsafe.UnsafeFieldAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemoiteItem extends Item {
    /*private static final String[] MEMOITE_LORE = {
            "A fragment of forgotten memory, something lingers in the shadows",
            "Something watches from within the Crystalline Caves.",
            "Beware the stalker.",
            "Some secrets are best left undisturbed, hidden in the void.",
            "Its cracks pulse as if alive, echoing forgotten cries.",
            "Stalking eyes follow you where light dares not reach.",
            "The air grows colder near places touched by eldritch horrors.",
            "A voice, distant and fractured, murmurs truths long erased.",
            "Even the stones remember those who vanished here.",
            "Touch the entity, and the world may reveal its darker corners.",
            "'Why was it created?' It seemed to whisper."
    };*/


    public MemoiteItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {

        pTooltipComponents.add(Component.literal("'Why was it created?' It seemed to whisper."));

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }



}
