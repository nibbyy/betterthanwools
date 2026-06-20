package nibbyy.betterthanwools.items;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.ItemLike;
import nibbyy.betterthanwools.BetterThanWools;
import nibbyy.betterthanwools.config.WoolsConfig;
import nibbyy.slowcraft.items.SlowTool;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class WoolsItems {
	private static final List<ItemLike> CREATIVE_TAB_ITEMS = new ArrayList<>();

	public static void addToCreativeTab(ItemLike itemLike) {
		CREATIVE_TAB_ITEMS.add(itemLike);
	}

	// Default behavior: Item gets added to Creative Tab
	public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
		return register(name, itemFactory, settings, true);
	}

	// Overload to catch items not added to creative tab
	public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings, boolean addToCreativeTab) {
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterThanWools.MOD_ID, name));
		T item = itemFactory.apply(settings.setId(itemKey));
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		if (addToCreativeTab) {
			addToCreativeTab(item);
		}

		return item;
	}

	// Creative Tab
	public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
			BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(BetterThanWools.MOD_ID, "creative_tab")
	);
	public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
			.icon(() -> new ItemStack(WoolsItems.KNITTINGS.get(WoolColor.WHITE)))
			.title(Component.translatable("creativeTab.betterthanwools"))
			.displayItems((params, output) -> {
				for (ItemLike itemLike : CREATIVE_TAB_ITEMS) {
					output.accept(itemLike);
				}
			})
			.build();

	public static void initialize() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
	}

	public enum WoolColor {
		WHITE(""),
		LIGHT_GRAY("light_gray"),
		GRAY("gray"),
		BLACK("black"),
		BROWN("brown"),
		RED("red"),
		ORANGE("orange"),
		YELLOW("yellow"),
		LIME("lime"),
		CYAN("cyan"),
		LIGHT_BLUE("light_blue"),
		BLUE("blue"),
		PURPLE("purple"),
		MAGENTA("magenta"),
		GREEN("green"),
		PINK("pink");

		private final String prefix;

		WoolColor(String prefix) {
			this.prefix = prefix;
		}

		public String id(String baseName) {
			if (this.prefix.isEmpty()) {
				return baseName;
			}

			return this.prefix + "_" + baseName;
		}
	}

	private static Item registerItem(String name) {
		return register(name, Item::new, new Item.Properties());
	}

	private static EnumMap<WoolColor, Item> registerColoredItems(String baseName) {
		EnumMap<WoolColor, Item> items = new EnumMap<>(WoolColor.class);

		for (WoolColor color : WoolColor.values()) {
			items.put(color, registerItem(color.id(baseName)));
		}

		return items;
	}

	private static SlowTool registerKnitting(String name, Item woolKnitOutput) {
		return register(
				name,
				properties -> new SlowTool(
						SlowTool.config()
								.itemOutput(woolKnitOutput)
								.usageSound(SoundEvents.COBWEB_HIT)
								.finishSound(SoundEvents.UI_LOOM_TAKE_RESULT)
								.itemOutput(WoolsItems.KNITTING_NEEDLES)
								.useTime(WoolsConfig.get().knittingTime),
						properties
				), new Item.Properties()
		);
	}
	private static EnumMap<WoolColor, SlowTool> registerKnittings(Map<WoolColor, Item> woolKnits) {
		EnumMap<WoolColor, SlowTool> knittings = new EnumMap<>(WoolColor.class);

		for (WoolColor color : WoolColor.values()) {
			knittings.put(color, registerKnitting(color.id("knitting"), woolKnits.get(color)));
		}

		return knittings;
	}

	// Items
	public static final Item KNITTING_NEEDLES = registerItem("knitting_needles");

	// Raw Wools
	public static final Map<WoolColor, Item> RAW_WOOLS = registerColoredItems("raw_wool");
	// Wool Knits
	public static final Map<WoolColor, Item> WOOL_KNITS = registerColoredItems("wool_knit");
	// Knittings
	public static final Map<WoolColor, SlowTool> KNITTINGS = registerKnittings(WOOL_KNITS);

	// Armors
	public static final Item WOOL_HELMET = register(
			"wool_helmet",
			Item::new,
			new Item.Properties().humanoidArmor(WoolsArmorMaterial.INSTANCE, ArmorType.HELMET)
					.durability(ArmorType.HELMET.getDurability(WoolsArmorMaterial.BASE_DURABILITY))
	);
	public static final Item WOOL_CHESTPLATE = register(
			"wool_chestplate",
			Item::new,
			new Item.Properties().humanoidArmor(WoolsArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
					.durability(ArmorType.CHESTPLATE.getDurability(WoolsArmorMaterial.BASE_DURABILITY))
	);
	public static final Item WOOL_LEGGINGS = register(
			"wool_leggings",
			Item::new,
			new Item.Properties().humanoidArmor(WoolsArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
					.durability(ArmorType.LEGGINGS.getDurability(WoolsArmorMaterial.BASE_DURABILITY))
	);
	public static final Item WOOL_BOOTS = register(
			"wool_boots",
			Item::new,
			new Item.Properties().humanoidArmor(WoolsArmorMaterial.INSTANCE, ArmorType.BOOTS)
					.durability(ArmorType.BOOTS.getDurability(WoolsArmorMaterial.BASE_DURABILITY))
	);
}