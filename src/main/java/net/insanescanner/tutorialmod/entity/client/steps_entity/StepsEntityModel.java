package net.insanescanner.tutorialmod.entity.client.steps_entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.insanescanner.tutorialmod.TutorialMod;
import net.insanescanner.tutorialmod.entity.client.watching_entity.WatchingEntityAnimations;
import net.insanescanner.tutorialmod.entity.custom.StepsEntity;
import net.insanescanner.tutorialmod.entity.custom.WatchingEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class StepsEntityModel<T extends StepsEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "steps_entity"), "main");
    private final ModelPart whole;
   // private final ModelPart left_leg;
    //private final ModelPart right_leg;

    public StepsEntityModel(ModelPart root) {
        this.whole = root.getChild("whole");
        //this.left_leg = this.whole.getChild("left_leg");
        //this.right_leg = this.whole.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition whole = partdefinition.addOrReplaceChild("whole", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        //PartDefinition left_leg = whole.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.9F, 11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, -12.0F, 0.0F));

       // PartDefinition right_leg = whole.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.1F, 11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        whole.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }


    @Override
    public ModelPart root() {
        return whole;
    }


    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        //this.animateWalk(WatchingEntityAnimations.WATCHING_ENTITY_WALK, pLimbSwing, pLimbSwingAmount, 2f, 2.5f);
    }
}
