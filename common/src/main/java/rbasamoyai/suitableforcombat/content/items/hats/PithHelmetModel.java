package rbasamoyai.suitableforcombat.content.items.hats;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class PithHelmetModel extends HumanoidModel<LivingEntity> {

	public PithHelmetModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f);
		PartDefinition part = mesh.getRoot();
		PartDefinition head = part.getChild("head");
		head.addOrReplaceChild("helmet", CubeListBuilder.create()
				.texOffs(32, 44).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 5.0F, 8.0F, CubeDeformation.NONE)
				.texOffs(0, 32).addBox(-4.5F, -4.0F, -5.0F, 9.0F, 2.0F, 10.0F, CubeDeformation.NONE)
				.texOffs(0, 44).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 3.0F, 8.0F, CubeDeformation.NONE)
				.texOffs(0, 55).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 2.0F, 6.0F, CubeDeformation.NONE)
				.texOffs(0, 32).addBox(-1.0F, -9.5F, -1.0F, 2.0F, 1.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0f, 0.0f, -0.25f, -0.0873f, 0.0f, 0.0f));
		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		poseStack.pushPose();
		if (this.young) {
			poseStack.translate(0.0f, -0.1875f, 0.0f);
		}
		poseStack.translate(this.head.x / 16.0f, this.head.y / 16.0f, this.head.z / 16.0f);
		poseStack.scale(1.25f, 1.25f, 1.25f);
		poseStack.translate(-this.head.x / 16.0f, -this.head.y / 16.0f, -this.head.z / 16.0f);
		super.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		poseStack.popPose();
	}

}
