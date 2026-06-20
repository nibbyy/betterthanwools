package nibbyy.betterthanwools.items;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import nibbyy.betterthanwools.BetterThanWools;
import nibbyy.betterthanwools.config.WoolsConfig;

import java.util.Map;

public class WoolsArmorMaterial {
	public static final int BASE_DURABILITY = 4;
	public static final ResourceKey<EquipmentAsset> WOOL_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(BetterThanWools.MOD_ID, "wool"));
	public static final TagKey<Item> REPAIRS_WOOL_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(BetterThanWools.MOD_ID, "repairs_wool_armor"));

	public static final ArmorMaterial INSTANCE = new ArmorMaterial(
			BASE_DURABILITY,
			Map.of(
					ArmorType.HELMET, 1,
					ArmorType.CHESTPLATE, 2,
					ArmorType.LEGGINGS, 1,
					ArmorType.BOOTS, 1
			),
			20,
			SoundEvents.ARMOR_EQUIP_LEATHER,
			0.0F,
			WoolsConfig.get().armorKnockback ? 0.1F : 0.0F,
			REPAIRS_WOOL_ARMOR,
			WOOL_ARMOR_MATERIAL_KEY
	);
}
