package net.mcreator.spoi.procedures;

@SpoiModElements.ModElement.Tag
public class BlankpotiPotionStartedappliedProcedure extends SpoiModElements.ModElement {

	public BlankpotiPotionStartedappliedProcedure(SpoiModElements instance) {
		super(instance, 8);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BlankpotiPotionStartedapplied!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		String xuwu = "";
		String full = "";
		full = (String) ((entity) + "" + ("is now gay"));
		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new StringTextComponent((full)));
		}

	}

}
