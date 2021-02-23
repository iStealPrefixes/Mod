// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelstatue extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public Modelstatue() {
		textureWidth = 128;
		textureHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-8.0F, -22.0F, -7.0F, 15.0F, 15.0F, 13.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-3.0F, -7.0F, -3.0F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		bb_main.setTextureOffset(118, 0).addBox(-2.0F, -17.0F, -9.0F, 3.0F, 5.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 107).addBox(-11.0F, -1.0F, -10.0F, 20.0F, 1.0F, 20.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}