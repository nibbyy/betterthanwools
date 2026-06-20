package nibbyy.betterthanwools.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import nibbyy.betterthanwools.blocks.BedrollBlock;
import nibbyy.betterthanwools.config.WoolsConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayer.class)
public class BedrollSpawnMixin {
	@Redirect(
			method = "startSleepInBed",
			at = @At (
					value = "INVOKE",
					target = "Lnet/minecraft/server/level/ServerPlayer;setRespawnPosition(Lnet/minecraft/server/level/ServerPlayer$RespawnConfig;Z)V"
			)
	)
	private void betterthanwools$skipBedrollSpawn(
			ServerPlayer player,
			ServerPlayer.RespawnConfig respawnConfig,
			boolean showMessage,
			BlockPos pos
	) {
		if (!WoolsConfig.get().bedrollSetsSpawn) {
			if (player.level().getBlockState(pos).getBlock() instanceof BedrollBlock) {
				return;
			}
		}

		player.setRespawnPosition(respawnConfig, showMessage);
	}
}
