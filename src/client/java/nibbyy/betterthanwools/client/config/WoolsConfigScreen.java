package nibbyy.betterthanwools.client.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import nibbyy.betterthanwools.config.WoolsConfig;

public final class WoolsConfigScreen {
	private WoolsConfigScreen() {}

	public static Screen create(Screen parent) {
		WoolsConfig config = WoolsConfig.get();

		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(Component.translatable("title.betterthanwools.config"));

		builder.setSavingRunnable(WoolsConfig::save);

		ConfigCategory general = builder.getOrCreateCategory(
				Component.translatable("category.betterthanwools.general")
		);

		ConfigCategory recipes = builder.getOrCreateCategory(
				Component.translatable("category.betterthanwools.recipes")
		);

		ConfigCategory armor = builder.getOrCreateCategory(
				Component.translatable("category.betterthanwools.armor")
		);

		ConfigEntryBuilder entryBuilder = builder.entryBuilder();

		general.addEntry(entryBuilder.startIntField(
				Component.translatable("option.betterthanwools.knitting_time"),
				config.knittingTime
			)
				.setDefaultValue(WoolsConfig.DEFAULT_KNITTING_TIME)
				.setMin(WoolsConfig.MIN_KNITTING_TIME)
				.setMax(WoolsConfig.MAX_KNITTING_TIME)
				.setTooltip(Component.translatable("option.betterthanwools.knitting_time.tooltip"))
				.setSaveConsumer(newValue -> config.knittingTime = newValue)
				.requireRestart()
				.build());

		general.addEntry(entryBuilder.startBooleanToggle(
				Component.translatable("option.betterthanwools.replaceSheepDeathDrops"),
				config.replaceSheepDeathDrops
		)
				.setDefaultValue(true)
				.setTooltip(Component.translatable("option.betterthanwools.replaceSheepDeathDrops.tooltip"))
				.setSaveConsumer(newValue -> config.replaceSheepDeathDrops = newValue)
				.requireRestart()
				.build());

		general.addEntry(entryBuilder.startBooleanToggle(
				Component.translatable("option.betterthanwools.replaceSheepShearDrops"),
				config.replaceSheepShearDrops
		)
				.setDefaultValue(true)
				.setTooltip(Component.translatable("option.betterthanwools.replaceSheepShearDrops.tooltip"))
				.setSaveConsumer(newValue -> config.replaceSheepShearDrops = newValue)
				.requireRestart()
				.build());

		general.addEntry(entryBuilder.startBooleanToggle(
				Component.translatable("option.betterthanwools.bedrollSetsSpawn"),
				config.bedrollSetsSpawn
		)
				.setDefaultValue(false)
				.setTooltip(Component.translatable("option.betterthanwools.bedrollSetsSpawn.tooltip"))
				.setSaveConsumer(newValue -> config.bedrollSetsSpawn = newValue)
				.requireRestart()
				.build());

		recipes.addEntry(entryBuilder.startBooleanToggle(
				Component.translatable("option.betterthanwools.removeWoolRecipe"),
				config.removeWoolRecipe
		)
				.setDefaultValue(true)
				.setTooltip(Component.translatable("option.betterthanwools.removeWoolRecipe.tooltip"))
				.setSaveConsumer(newValue -> config.removeWoolRecipe = newValue)
				.requireRestart()
				.build());

		recipes.addEntry(entryBuilder.startBooleanToggle(
				Component.translatable("option.betterthanwools.regressiveRecipes"),
				config.regressiveRecipes
		)
				.setDefaultValue(false)
				.setTooltip(Component.translatable("option.betterthanwools.regressiveRecipes.tooltip"))
				.setSaveConsumer(newValue -> config.regressiveRecipes = newValue)
				.requireRestart()
				.build());

		armor.addEntry(entryBuilder.startBooleanToggle(
				Component.translatable("option.betterthanwools.armor_knockback"),
				config.armorKnockback
		)
				.setDefaultValue(false)
				.setTooltip(Component.translatable("option.betterthanwools.armor_knockback.tooltip"))
				.setSaveConsumer(newValue -> config.armorKnockback = newValue)
				.requireRestart()
				.build());

		armor.addEntry(entryBuilder.startBooleanToggle(
				Component.translatable("option.betterthanwools.fullSetEffect"),
				config.fullSetEffect
		)
				.setDefaultValue(false)
				.setTooltip(Component.translatable("option.betterthanwools.fullSetEffect.tooltip"))
				.setSaveConsumer(newValue -> config.fullSetEffect = newValue)
				.requireRestart()
				.build());

		return builder.build();
	}
}
