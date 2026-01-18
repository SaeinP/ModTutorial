package net.insanescanner.tutorialmod.entity.client.memoite_sword;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.entity.custom.MemoiteSwordProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;


public class MemoiteSwordProjectileEntityRenderer extends EntityRenderer<MemoiteSwordProjectileEntity> {
    private MemoiteSwordProjectileModel model;

    public MemoiteSwordProjectileEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new MemoiteSwordProjectileModel(pContext.bakeLayer(MemoiteSwordProjectileModel.LAYER_LOCATION));
    }

    @Override
    public void render(MemoiteSwordProjectileEntity pEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        System.out.println("RENDERING ENTITY!1");
        poseStack.pushPose();
        System.out.println("RENDERING ENTITY!2");
        if(!pEntity.isGrounded()) {
            poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, pEntity.yRotO, pEntity.getYRot())));
            poseStack.mulPose(Axis.XP.rotationDegrees(pEntity.getRenderingRotation() * 5f));
            poseStack.translate(0, -1.0f, 0);
        } else {
            poseStack.mulPose(Axis.YP.rotationDegrees(pEntity.groundedOffset.y));
            poseStack.mulPose(Axis.XP.rotationDegrees(pEntity.groundedOffset.x));
            poseStack.translate(0, -1.0f, 0);
        }

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(pEntity)),false, false);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(pEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(MemoiteSwordProjectileEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/memoite_sword_projectile_entity/memoite_sword_projectile_entity.png");
    }


}
