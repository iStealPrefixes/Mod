
package net.mcreator.spoi.entity;

import net.minecraft.block.material.Material;

@SpoiModElements.ModElement.Tag
public class Statue1Entity extends SpoiModElements.ModElement {

	public static EntityType entity = null;

	public Statue1Entity(SpoiModElements instance) {
		super(instance, 6);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(1f, 1.2f)).build("statue_1")
						.setRegistryName("statue_1");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("statue_1_spawn_egg"));

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelstatue(), 0f) {

				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("spoi:textures/statue.png");
				}
			};
		});

	}

	public static class CustomEntity extends CreatureEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.use"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.destroy"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);

		}

	}

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
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
