package net.insanescanner.tutorialmod.entity;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.entity.client.steps_entity.StepsEntityRenderer;
import net.insanescanner.tutorialmod.entity.custom.MemoiteSwordProjectileEntity;
import net.insanescanner.tutorialmod.entity.custom.StepsEntity;
import net.insanescanner.tutorialmod.entity.custom.TexturelessChairEntity;
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

    public static final RegistryObject<EntityType<StepsEntity>> STEPS_ENTITY =
            ENTITY_TYPES.register("steps_entity", () -> EntityType.Builder.of(StepsEntity::new, MobCategory.MONSTER)
                    .sized(0.4f,0.3f).build("steps_entity"));

    public static final RegistryObject<EntityType<MemoiteSwordProjectileEntity>> MEMOITE_SWORD_PROJECTILE_ENTITY =
            ENTITY_TYPES.register("memoite_sword_projectile_entity", () -> EntityType.Builder.<MemoiteSwordProjectileEntity>of((entityType, level) -> new MemoiteSwordProjectileEntity(entityType, level), MobCategory.MISC)
                    .sized(0.5f,0.9f).build("memoite_sword_projectile_entity"));


    public static final RegistryObject<EntityType<TexturelessChairEntity>>TEXTURELESS_CHAIR_ENTITY =
            ENTITY_TYPES.register("textureless_chair_entity", () -> EntityType.Builder.<TexturelessChairEntity>of(TexturelessChairEntity::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("textureless_chair_entity"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
