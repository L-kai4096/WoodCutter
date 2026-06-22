package com.kk.woodcutter.client;

import com.kk.woodcutter.Classes.Entity.screenhandler.ModScreenHandlerType;
import com.kk.woodcutter.client.block.screen.WoodCutterScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class WoodCutterClient implements ClientModInitializer {



    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlerType.WOOD_CUTTER_SCREEN_HANDLER_TYPE, WoodCutterScreen::new);
    }
}
