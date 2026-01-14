package net.insanescanner.tutorialmod.entity;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.entity.custom.WatchingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<WatchingEntity>> WATCHING_ENTITY =
            ENTITY_TYPES.register("watching_entity", () -> EntityType.Builder.of(WatchingEntity::new, MobCategory.MONSTER)
                    .sized(1.5f,2f).build("watching_entity"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
