package nibbyy.betterthanwools.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import net.fabricmc.loader.api.FabricLoader;
import nibbyy.betterthanwools.BetterThanWools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WoolsConfig {
	public static final int DEFAULT_KNITTING_TIME = 60;
	public static final int MIN_KNITTING_TIME = 1;
	public static final int MAX_KNITTING_TIME = 1200;

	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final Path CONFIG_PATH = FabricLoader.getInstance()
			.getConfigDir()
			.resolve(BetterThanWools.MOD_ID + ".json");

	private static WoolsConfig INSTANCE = new WoolsConfig();

	public static WoolsConfig get() {
		return INSTANCE;
	}

	public static void load() {
		if (!Files.exists(CONFIG_PATH)) {
			save();
			return;
		}

		try {
			String json = Files.readString(CONFIG_PATH);
			INSTANCE = GSON.fromJson(json, WoolsConfig.class);

			if (INSTANCE == null) {
				BetterThanWools.LOGGER.warn("Better Than Wools config contained no data; restoring defaults");
				INSTANCE = new WoolsConfig();
				save();
				return;
			}

			if (INSTANCE.normalize()) {
				save();
			}
		} catch (IOException | JsonParseException exception) {
			BetterThanWools.LOGGER.error("Failed to load Better Than Wools config; using defaults", exception);
			INSTANCE = new WoolsConfig();
		}
	}

	private boolean normalize() {
		int normalizedKnittingTime = Math.max(MIN_KNITTING_TIME, Math.min(MAX_KNITTING_TIME, knittingTime));

		if (knittingTime == normalizedKnittingTime) {
			return false;
		}

		BetterThanWools.LOGGER.warn(
				"Invalid knittingTime {} in Better Than Wools config; using {} instead",
				knittingTime,
				normalizedKnittingTime
		);
		knittingTime = normalizedKnittingTime;
		return true;
	}

	public static void save() {
		try {
			String json = GSON.toJson(INSTANCE);
			Files.writeString(CONFIG_PATH, json);
		} catch (IOException exception) {
			BetterThanWools.LOGGER.error("Failed to save Better Than Wools config", exception);
		}
	}

	public int knittingTime = DEFAULT_KNITTING_TIME;
	public boolean armorKnockback = false;
	public boolean replaceSheepDeathDrops = true;
	public boolean replaceSheepShearDrops = true;
	public boolean removeWoolRecipe = true;
	public boolean regressiveRecipes = false;
	public boolean bedrollSetsSpawn = false;
	public boolean fullSetEffect = false;
}
