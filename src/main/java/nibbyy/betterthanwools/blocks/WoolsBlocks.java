package nibbyy.betterthanwools.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BedItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import nibbyy.betterthanwools.BetterThanWools;
import nibbyy.betterthanwools.items.WoolsItems;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class WoolsBlocks {
	public static void initialize() {}

	private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, BiFunction<Block, Item.Properties, Item> itemFactory) {
		ResourceKey<Block> blockKey = keyOfBlock(name);
		Block block = blockFactory.apply(properties.setId(blockKey));

		if (itemFactory != null) {
			ResourceKey<Item> itemKey = keyOfItem(name);
			Item item = itemFactory.apply(
					block,
					new Item.Properties().setId(itemKey).useBlockDescriptionPrefix()
			);

			Registry.register(BuiltInRegistries.ITEM, itemKey, item);
			WoolsItems.addToCreativeTab(block);
		}

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
		// Create the Registry key
		ResourceKey<Block> blockKey = keyOfBlock(name);
		// Create the block instance
		Block block = blockFactory.apply(properties.setId(blockKey));

		if (shouldRegisterItem) {
			ResourceKey<Item> itemKey = keyOfItem(name);

			BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
			Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

			WoolsItems.addToCreativeTab(block);
		}

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterThanWools.MOD_ID, name));
	}

	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterThanWools.MOD_ID, name));
	}

	// Bedrolls
	public static final Map<WoolsItems.WoolColor, BedrollBlock> BEDROLLS = registerColoredBedrolls();

	private static EnumMap<WoolsItems.WoolColor, BedrollBlock> registerColoredBedrolls() {
		EnumMap<WoolsItems.WoolColor, BedrollBlock> blocks = new EnumMap<>(WoolsItems.WoolColor.class);

		for (WoolsItems.WoolColor color : WoolsItems.WoolColor.values()) {
			DyeColor dyeColor = DyeColor.valueOf(color.name());

			blocks.put(color, (BedrollBlock) register(
					color.id("bedroll"),
					properties -> new BedrollBlock(dyeColor, properties),
					BlockBehaviour.Properties.of()
							.mapColor(dyeColor)
							.sound(SoundType.WOOL)
							.strength(0.1F)
							.noOcclusion()
							.ignitedByLava()
							.pushReaction(PushReaction.DESTROY),
					BedItem::new
			));
		}

		return blocks;
	}
}
