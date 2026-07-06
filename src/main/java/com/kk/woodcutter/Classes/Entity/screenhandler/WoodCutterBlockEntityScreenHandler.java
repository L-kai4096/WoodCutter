package com.kk.woodcutter.Classes.Entity.screenhandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class WoodCutterBlockEntityScreenHandler extends ScreenHandler {

    public WoodCutterBlockEntityScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(2));
    }

    public WoodCutterBlockEntityScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlerType.WOOD_CUTTER_SCREEN_HANDLER_TYPE, syncId);

        // Input
        // 原料
        this.addSlot(new Slot(inventory, 0, 20, 33));

        // Output
        // 成品
        this.addSlot(new Slot(inventory, 1, 143, 33));

        // Bag
        // 背包
        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        // HotBar
        // 快捷栏
        for(int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    public static void init(){

    }
}
