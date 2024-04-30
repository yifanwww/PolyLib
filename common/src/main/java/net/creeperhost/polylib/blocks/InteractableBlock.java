package net.creeperhost.polylib.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Can be implemented by any {@link BlockEntity} whose block extends {@link PolyEntityBlock}.
 * Allows the block entity to receive player interaction events.
 * <p>
 * Created by brandon3055 on 19/02/2024
 */
public interface InteractableBlock {

    /**
     * Called when the host block is used (right clicked)
     */
    default InteractionResult onBlockUse(BlockState blockState, Level level, BlockPos pos, Player player, BlockHitResult blockHitResult) {
        return InteractionResult.PASS;
    }

    /**
     * Called when the host block is attacked (left clicked)
     */
    default void onBlockAttack(Player player) {}
}
