package com.iafenvoy.soo.render.entity;

import com.iafenvoy.soo.data.CatEarData;
import com.iafenvoy.soo.render.model.CatEarModel;
import com.iafenvoy.soo.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class CatEarFeatureRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier INNER = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/cat_ear_inner.png");
    private static final Identifier OUTER = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/cat_ear_outer.png");
    private final CatEarModel<T> model;

    public CatEarFeatureRenderer(FeatureRendererContext<T, M> context, CatEarModel<T> model) {
        super(context);
        this.model = model;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        CatEarData data = CatEarData.byPlayer(entity);
        if (!data.isEnabled()) return;
        matrices.push();
        translateToFace(matrices, this.getContextModel(), entity, headYaw, headPitch);
        matrices.translate(0, -1.25, 0.1);
        matrices.scale(0.75f, 0.75f, 0.75f);
        Color4i inner = new Color4i(data.getInnerColor()), outer = new Color4i(data.getOuterColor());
        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(INNER)), light, LivingEntityRenderer.getOverlay(entity, 0), inner.getR(), inner.getG(), inner.getB(), 1);
        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(OUTER)), light, LivingEntityRenderer.getOverlay(entity, 0), outer.getR(), outer.getG(), outer.getB(), 1);
        matrices.pop();
    }

    public static <T extends PlayerEntity, M extends PlayerEntityModel<T>> void translateToFace(MatrixStack matrices, M model, T player, float headYaw, float headPitch) {
        if (player.isInSwimmingPose() || player.isFallFlying()) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(model.head.roll));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-45.0F));
        } else {
            if (player.isInSneakingPose() && !model.riding) matrices.translate(0.0F, 0.25F, 0.0F);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(headPitch));
        }
        matrices.translate(0.0F, -0.25F, -0.3F);
    }
}
