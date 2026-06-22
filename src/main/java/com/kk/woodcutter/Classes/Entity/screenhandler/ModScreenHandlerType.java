package com.kk.woodcutter.Classes.Entity.screenhandler;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlerType extends ScreenHandlerType<WoodCutterBlockEntityScreenHandler> {

    public static final ScreenHandlerType<WoodCutterBlockEntityScreenHandler> WOOD_CUTTER_SCREEN_HANDLER_TYPE = register("woodcutter", WoodCutterBlockEntityScreenHandler::new);

    public ModScreenHandlerType(Factory<WoodCutterBlockEntityScreenHandler> factory, FeatureSet requiredFeatures) {
        super(factory, requiredFeatures);
    }

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier("kk", id), new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }

    public static void init(){}

        
}
