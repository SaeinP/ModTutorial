package net.insanescanner.tutorialmod.entity.client.steps_entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.entity.client.watching_entity.WatchingEntityModel;
import net.insanescanner.tutorialmod.entity.custom.StepsEntity;
import net.insanescanner.tutorialmod.entity.custom.WatchingEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StepsEntityRenderer extends MobRenderer<StepsEntity, StepsEntityModel<StepsEntity>> {

    public StepsEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new StepsEntityModel<>(pContext.bakeLayer(StepsEntityModel.LAYER_LOCATION)), 0f);
    }

    @Override
    public void render(StepsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(StepsEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/steps_entity/steps_entity.png");
    }
}
