package nibbyy.betterthanwools.items;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;

public class WoolsArmorEffects {
	private static final int FIRE_RESISTANCE_DURATION_TICKS = 40;
	private static final int REFRESH_WHEN_TICKS_REMAINING = 20;

	public static void initialize() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayer player : server.getPlayerList().getPlayers()) {
				applyFullSetEffect(player);
			}
		});
	}

	private static void applyFullSetEffect(ServerPlayer player) {
		if (!isWearingFullSet(player)) {
			return;
		}

		MobEffectInstance existingEffect = player.getEffect(MobEffects.FIRE_RESISTANCE);

		if (existingEffect == null || existingEffect.getDuration() <= REFRESH_WHEN_TICKS_REMAINING) {
			player.addEffect(new MobEffectInstance(
					MobEffects.FIRE_RESISTANCE,
					FIRE_RESISTANCE_DURATION_TICKS,
					0,
					true,
					false,
					true
			));
		}
	}

	private static boolean isWearingFullSet(ServerPlayer player) {
		return player.getItemBySlot(EquipmentSlot.HEAD).getItem() == WoolsItems.WOOL_HELMET &&
				player.getItemBySlot(EquipmentSlot.CHEST).getItem() == WoolsItems.WOOL_CHESTPLATE &&
				player.getItemBySlot(EquipmentSlot.LEGS).getItem() == WoolsItems.WOOL_LEGGINGS &&
				player.getItemBySlot(EquipmentSlot.FEET).getItem() == WoolsItems.WOOL_BOOTS;
	}
}
