package nibbyy.betterthanwools.recipes;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryOps;
import nibbyy.betterthanwools.BetterThanWools;
import nibbyy.betterthanwools.config.WoolsConfig;
import org.jspecify.annotations.Nullable;

public class WoolsRegressiveRecipes implements ResourceCondition {
	public static final MapCodec<WoolsRegressiveRecipes> CODEC = MapCodec.unit(WoolsRegressiveRecipes::new);

	public static final ResourceConditionType<WoolsRegressiveRecipes> TYPE = ResourceConditionType.create(
			Identifier.fromNamespaceAndPath(BetterThanWools.MOD_ID, "regressive_recipes_enabled"),
			CODEC
	);

	@Override
	public ResourceConditionType<?> getType() {
		return TYPE;
	}

	@Override
	public boolean test(RegistryOps.@Nullable RegistryInfoLookup registryInfo) {
		return WoolsConfig.get().regressiveRecipes;
	}
}
