package net.zhiganov.kfc.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class KFCBlock extends CakeBlock {
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 6);

    public KFCBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, Integer.valueOf(0)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (world.isClientSide) {
            if (this.eat(world, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (player.getItemInHand(hand).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return this.eat(world, pos, state, player);
    }

    private InteractionResult eat(Level world, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.getFoodData().eat(2, 0.1F);
            int i = state.getValue(BITES);
            if (i < 6) {
                world.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState();
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
        return (7 - state.getValue(BITES)) * 2;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return context.getItemInHand().isEmpty() && context.getPlayer().isCrouching() && state.getValue(BITES) < 6 ? true : super.canBeReplaced(state, context);
    }
}
