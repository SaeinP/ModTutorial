package net.insanescanner.tutorialmod.entity.client.watching_entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.entity.custom.WatchingEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WatchingEntityRenderer extends MobRenderer<WatchingEntity, WatchingEntityModel<WatchingEntity>> {

    public WatchingEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WatchingEntityModel<>(pContext.bakeLayer(WatchingEntityModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(WatchingEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/watching_entity/watching_entity.png");
    }

    @Override
    public void render(WatchingEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
