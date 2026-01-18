package net.insanescanner.tutorialmod.entity.client.memoite_sword;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.entity.custom.MemoiteSwordProjectileEntity;
import net.insanescanner.tutorialmod.entity.custom.StepsEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class MemoiteSwordProjectileModel extends EntityModel<MemoiteSwordProjectileEntity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "memoite_sword_projectile_entity"), "main");
    private final ModelPart sword_entity;

    public MemoiteSwordProjectileModel(ModelPart root) {
        this.sword_entity = root.getChild("sword_entity");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition sword_entity = partdefinition.addOrReplaceChild("sword_entity", CubeListBuilder.create()
                        .texOffs(0, 18).addBox(-1.0F, 9.0F, -12.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(24, 0).addBox(-1.0F, 8.0F, -10.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 0).addBox(-1.0F, 4.0F, -9.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                        .texOffs(12, 18).addBox(-1.0F, 3.0F, -10.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(4, 24).addBox(-1.0F, 4.0F, -11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(24, 4).addBox(-1.0F, 9.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(18, 0).addBox(-1.0F, 3.0F, -6.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(6, 18).addBox(-1.0F, 2.0F, -5.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 10).addBox(-1.0F, 0.0F, -4.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(10, 0).addBox(-1.0F, -1.0F, -3.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(8, 10).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(16, 8).addBox(-1.0F, -3.0F, -1.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(16, 16).addBox(-1.0F, -4.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 12.0F, 4.0F));

        PartDefinition cube_r1 = sword_entity.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -5.0F, 1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, -1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        sword_entity.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public void setupAnim(MemoiteSwordProjectileEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }
}
