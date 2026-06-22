package com.kk.woodcutter.Classes.Entity.screenhandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;

public class WoodCutterBlockEntityScreenHandler extends ScreenHandler {

    protected WoodCutterBlockEntityScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlerType.WOOD_CUTTER_SCREEN_HANDLER_TYPE, syncId);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    public static void init(){

    }
}
