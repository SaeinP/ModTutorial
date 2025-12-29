package net.insanescanner.tutorialmod.component;

import net.insanescanner.tutorialmod.TutorialMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemLore;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, TutorialMod.MOD_ID);

    public static final RegistryObject<DataComponentType<BlockPos>> COORDINATE = register("coordinates", builder -> builder.persistent(BlockPos.CODEC));

    public static final RegistryObject<DataComponentType<Integer>> MOD_LORE = register("mod_lore", builder -> builder.persistent(ExtraCodecs.NON_NEGATIVE_INT));

    private static <T>RegistryObject<DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator){
        return DATA_COMPONENT_TYPE.register(name, () -> builderOperator.apply(DataComponentType.
                builder()).build());
    }


    public static void register(IEventBus eventBus){
        DATA_COMPONENT_TYPE.register(eventBus);
    }
}
