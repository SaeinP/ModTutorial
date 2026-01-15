package net.insanescanner.tutorialmod.event;

import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.entity.ModEntities;
import net.insanescanner.tutorialmod.entity.client.steps_entity.StepsEntityModel;
import net.insanescanner.tutorialmod.entity.client.watching_entity.WatchingEntityModel;
import net.insanescanner.tutorialmod.entity.custom.StepsEntity;
import net.insanescanner.tutorialmod.entity.custom.WatchingEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(WatchingEntityModel.LAYER_LOCATION, WatchingEntityModel::createBodyLayer);
        event.registerLayerDefinition(StepsEntityModel.LAYER_LOCATION, StepsEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.WATCHING_ENTITY.get(), WatchingEntity.createAttributes().build());
        event.put(ModEntities.STEPS_ENTITY.get(), StepsEntity.createAttributes().build());
    }

}
