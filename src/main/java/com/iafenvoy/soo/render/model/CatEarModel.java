package com.iafenvoy.soo.render.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class CatEarModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart bone;
    private final ModelPart bone2;

    public CatEarModel(ModelPart root) {
        this.bone = root.getChild("bone");
        this.bone2 = root.getChild("bone2");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(0, 10).cuboid(-5.2F, -9.1F, 6.0F, 1.1F, 7.3F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(9.6F, 24.0F, -6.9F));
        bone.addChild("cube_r1", ModelPartBuilder.create().uv(20, 8).cuboid(-2.0F, -6.2F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-6.1F, 0.4F, 6.1F, 0.0F, 0.3927F, 0.0F));
        bone.addChild("cube_r2", ModelPartBuilder.create().uv(16, 19).cuboid(-2.0F, -9.3F, 0.0F, 2.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-4.6F, 0.6F, 6.2F, 0.0F, -0.0262F, 0.0F));
        bone.addChild("cube_r3", ModelPartBuilder.create().uv(6, 10).cuboid(-2.0F, -8.3F, 0.0F, 1.6F, 7.0F, 1.6F, new Dilation(0.0F)), ModelTransform.of(-4.9F, -0.2F, 6.4F, 0.0F, 0.3927F, 0.0F));
        bone.addChild("cube_r4", ModelPartBuilder.create().uv(0, 19).cuboid(-2.0F, -6.2F, 0.0F, 1.6F, 4.0F, 1.6F, new Dilation(0.0F)), ModelTransform.of(-6.1F, 0.4F, 6.4F, 0.0F, 0.3927F, 0.0F));
        bone.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -9.8F, -0.4F, 1.6F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.2F, 0.0F, 6.4F, 0.0F, 0.0F, 0.3927F));
        ModelPartData bone2 = modelPartData.addChild("bone2", ModelPartBuilder.create().uv(0, 10).mirrored().cuboid(4.1F, -9.1F, 6.0F, 1.1F, 7.3F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-9.6F, 24.0F, -6.9F));
        bone2.addChild("cube_r6", ModelPartBuilder.create().uv(20, 8).mirrored().cuboid(0.0F, -6.2F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(6.1F, 0.4F, 6.1F, 0.0F, -0.3927F, 0.0F));
        bone2.addChild("cube_r7", ModelPartBuilder.create().uv(16, 19).mirrored().cuboid(0.0F, -9.3F, 0.0F, 2.0F, 7.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(4.6F, 0.6F, 6.2F, 0.0F, 0.0262F, 0.0F));
        bone2.addChild("cube_r8", ModelPartBuilder.create().uv(6, 10).mirrored().cuboid(0.4F, -8.3F, 0.0F, 1.6F, 7.0F, 1.6F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(4.9F, -0.2F, 6.4F, 0.0F, -0.3927F, 0.0F));
        bone2.addChild("cube_r9", ModelPartBuilder.create().uv(0, 19).mirrored().cuboid(0.4F, -6.2F, 0.0F, 1.6F, 4.0F, 1.6F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(6.1F, 0.4F, 6.4F, 0.0F, -0.3927F, 0.0F));
        bone2.addChild("cube_r10", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.4F, -9.8F, -0.4F, 1.6F, 8.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(8.2F, 0.0F, 6.4F, 0.0F, 0.0F, -0.3927F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        bone2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

}