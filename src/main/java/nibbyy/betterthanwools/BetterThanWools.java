package nibbyy.betterthanwools;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import nibbyy.betterthanwools.blocks.WoolsBlocks;
import nibbyy.betterthanwools.config.WoolsConfig;
import nibbyy.betterthanwools.items.WoolsArmorEffects;
import nibbyy.betterthanwools.items.WoolsItems;
import nibbyy.betterthanwools.loot.WoolsLootTables;
import nibbyy.betterthanwools.recipes.WoolsRegressiveRecipes;
import nibbyy.betterthanwools.recipes.WoolsVanillaRecipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterThanWools implements ModInitializer {
	public static final String MOD_ID = "betterthanwools";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("[Better Than Wools] loaded!");
		WoolsConfig.load();
		WoolsItems.initialize();
		WoolsBlocks.initialize();

		ResourceConditions.register(WoolsVanillaRecipe.TYPE);
		ResourceConditions.register(WoolsRegressiveRecipes.TYPE);

		if (WoolsConfig.get().replaceSheepDeathDrops) {
			WoolsLootTables.replaceSheepDeathDrops();
		}

		if (WoolsConfig.get().replaceSheepShearDrops) {
			WoolsLootTables.replaceSheepShearDrops();
		}

		if (WoolsConfig.get().fullSetEffect) {
			WoolsArmorEffects.initialize();
		}
	}
}