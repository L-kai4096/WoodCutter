package com.kk.woodcutter.Classes.Entity;

import com.kk.woodcutter.Classes.Entity.screenhandler.ModScreenHandlerType;
//import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import com.kk.woodcutter.Classes.Entity.screenhandler.WoodCutterBlockEntityScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
//import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
//import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class WoodCutterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, Inventory {


    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

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
        return Text.translatable("name.wood_cutter");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new WoodCutterBlockEntityScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public int size() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : inventory) {
            if (!itemStack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack itemStack = Inventories.splitStack(this.inventory, slot, amount);
        if (!itemStack.isEmpty()) {
            this.markDirty();
        }
        return itemStack;

    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.inventory, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        this.inventory.set(slot, stack);
        stack.setCount(this.getStack(slot).getCount());
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return Inventory.canPlayerUse(this, player);
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }
}
