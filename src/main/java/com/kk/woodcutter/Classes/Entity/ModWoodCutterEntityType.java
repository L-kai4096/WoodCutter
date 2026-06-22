package com.kk.woodcutter.Classes.Entity;

import com.kk.woodcutter.Classes.ClassWoodCutter;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;

public class ModWoodCutterEntityType {

    public static final BlockEntityType<WoodCutterBlockEntity> WOOD_CUTTER = create("woodcutter",
            BlockEntityType.Builder.create(WoodCutterBlockEntity::new, ClassWoodCutter.WOOD_CUTTER)
    );

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {

        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return  Registry.register(Registries.BLOCK_ENTITY_TYPE, id, builder.build(type));
    }

    public static void init(){}
}
