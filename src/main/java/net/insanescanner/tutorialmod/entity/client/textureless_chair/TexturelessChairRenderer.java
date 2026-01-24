package net.insanescanner.tutorialmod.entity.client.textureless_chair;

import net.insanescanner.tutorialmod.entity.custom.TexturelessChairEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class TexturelessChairRenderer extends EntityRenderer<TexturelessChairEntity> {
    public TexturelessChairRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(TexturelessChairEntity pEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(TexturelessChairEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return true;
    }
}
