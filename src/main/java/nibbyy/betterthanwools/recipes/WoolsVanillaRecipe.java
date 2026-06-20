package nibbyy.betterthanwools.recipes;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryOps;
import nibbyy.betterthanwools.BetterThanWools;
import nibbyy.betterthanwools.config.WoolsConfig;

public class WoolsVanillaRecipe implements ResourceCondition {
	public static final MapCodec<WoolsVanillaRecipe> CODEC = MapCodec.unit(WoolsVanillaRecipe::new);

	public static final ResourceConditionType<WoolsVanillaRecipe> TYPE = ResourceConditionType.create(
			Identifier.fromNamespaceAndPath(BetterThanWools.MOD_ID, "vanilla_wool_recipe_disabled"),
			CODEC
	);

	@Override
	public ResourceConditionType<?> getType() {
		return TYPE;
	}

	@Override
	public boolean test(RegistryOps.RegistryInfoLookup registryInfoLookup) {
		return WoolsConfig.get().removeWoolRecipe;
	}
}