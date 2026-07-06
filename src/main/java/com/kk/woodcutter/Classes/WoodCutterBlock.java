package com.kk.woodcutter.Classes;

import com.kk.woodcutter.Classes.Entity.ModWoodCutterEntityType;
import com.kk.woodcutter.Classes.Entity.WoodCutterBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WoodCutterBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final MapCodec<WoodCutterBlock> CODEC = createCodec(WoodCutterBlock::new);
//    private final MapCodec<StonecutterBlock> CODEC = createCodec(StonecutterBlock::new);
    private final Text TITLE = Text.translatable("name.wood_cutter");
    private final VoxelShape SHAPE =  Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 9.0, 16.0);

    public WoodCutterBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if(world.isClient){
            return ActionResult.SUCCESS;
        }
        else {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof WoodCutterBlockEntity entity){
                player.openHandledScreen(entity);
            }
            return ActionResult.CONSUME;
        }
    }

    public VoxelShape getSHAPE() {
        return SHAPE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModWoodCutterEntityType.WOOD_CUTTER.instantiate(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

//    @Override
//    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
//        super.onStateReplaced(state, world, pos, newState, moved)
//    }


}
