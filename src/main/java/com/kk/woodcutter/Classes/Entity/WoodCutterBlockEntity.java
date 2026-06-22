package com.kk.woodcutter.Classes.Entity;

import com.kk.woodcutter.Classes.Entity.screenhandler.ModScreenHandlerType;
//import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
//import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
//import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class WoodCutterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {

    public WoodCutterBlockEntity(BlockPos pos, BlockState state) {
        super(ModWoodCutterEntityType.WOOD_CUTTER, pos, state);
    }

//    @Override
//    public DefaultedList<ItemStack> getItems() {
//        return null;
//    }
//
//    @Override
//    public Object getScreenOpeningData(ServerPlayerEntity player) {
//        return null;
//    }
//
    @Override
    public Text getDisplayName() {
        return Text.translatable("text.woodCutter");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return ModScreenHandlerType.WOOD_CUTTER_SCREEN_HANDLER_TYPE.create(syncId, playerInventory);
    }
}
