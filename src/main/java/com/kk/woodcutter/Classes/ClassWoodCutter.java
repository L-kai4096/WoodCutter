package com.kk.woodcutter.Classes;


import com.kk.woodcutter.Classes.Entity.ModWoodCutterEntityType;
//import com.kk.woodcutter.Classes.Entity.WoodCutterBlockEntity;
import com.kk.woodcutter.Classes.Entity.screenhandler.ModScreenHandlerType;
//import com.kk.woodcutter.Classes.Entity.screenhandler.WoodCutterBlockEntityScreenHandler;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.minecraft.block.AbstractBlock;
//import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
//import net.minecraft.registry.RegistryKey;
//import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

//import java.util.function.Function;

public class ClassWoodCutter {

    public static final WoodCutterBlock WOOD_CUTTER = new WoodCutterBlock(FabricBlockSettings.create().strength(3.0f));

    public ClassWoodCutter(){
        // 初始化
        Initialization();


    }
    /// WoodCutter方块初始化
    ///
    /// WoodCutter物品初始化
    private void Initialization(){
        // 注册
        regedit();

        // 放入物品组-->切石机的后面

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Items.STONECUTTER, WOOD_CUTTER);
        });
    }

    /// 注册物品/方块
    private void regedit(){
        // 注册方块
        Registry.register(Registries.BLOCK, new Identifier("kk", "woodcutter"), WOOD_CUTTER);
        // 注册物品
        Registry.register(Registries.ITEM, new Identifier("kk", "woodcutter"), new BlockItem(WOOD_CUTTER, new Item.Settings()));
        // 注册方块实体
        ModWoodCutterEntityType.init();
        ModScreenHandlerType.init();

    }


}
