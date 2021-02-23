package net.mcreator.spoi.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.spoi.SpoiModElements;

import java.util.Map;

@SpoiModElements.ModElement.Tag
public class FlamthrowerBulletHitsPlayerProcedure extends SpoiModElements.ModElement {
	public FlamthrowerBulletHitsPlayerProcedure(SpoiModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FlamthrowerBulletHitsPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 15);
	}
}
