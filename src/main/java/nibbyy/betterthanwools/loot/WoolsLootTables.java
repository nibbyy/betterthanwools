package nibbyy.betterthanwools.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import nibbyy.betterthanwools.items.WoolsItems;

public class WoolsLootTables {
	public static void replaceSheepDeathDrops() {
		LootTableEvents.REPLACE.register((key, original, source, registries) -> {
			if (!source.isBuiltin()) {
				return null;
			}

			for (DyeColor dyeColor : DyeColor.values()) {
				if (BuiltInLootTables.SHEEP_BY_DYE.get(dyeColor) != key) {
					continue;
				}

				WoolsItems.WoolColor woolColor = WoolsItems.WoolColor.valueOf(dyeColor.name());
				Item rawWool = WoolsItems.RAW_WOOLS.get(woolColor);

				return LootTable.lootTable()
						.setParamSet(LootContextParamSets.ENTITY)
						.setRandomSequence(Identifier.withDefaultNamespace("entities/sheep/" + dyeColor.getName()))
						.withPool(LootPool.lootPool()
								.setRolls(UniformGenerator.between(0, 1))
								.add(LootItem.lootTableItem(rawWool)))
						.build();
			}

			return null;
		});
	}

	public static void replaceSheepShearDrops() {
		LootTableEvents.REPLACE.register((key, original, source, registries) -> {
			if (!source.isBuiltin()) {
				return null;
			}

			for (DyeColor dyeColor : DyeColor.values()) {
				if (!BuiltInLootTables.SHEAR_SHEEP_BY_DYE.get(dyeColor).equals(key)) {
					continue;
				}

				WoolsItems.WoolColor woolColor = WoolsItems.WoolColor.valueOf(dyeColor.name());
				Item rawWool = WoolsItems.RAW_WOOLS.get(woolColor);

				return LootTable.lootTable()
						.setParamSet(LootContextParamSets.SHEARING)
						.setRandomSequence(Identifier.withDefaultNamespace("shearing/sheep/" + dyeColor.getName()))
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add(LootItem.lootTableItem(rawWool)))
						.build();
			}

			return null;
		});
	}
}
