package com.kk.woodcutter.client.block.screen;

import com.kk.woodcutter.Classes.Entity.screenhandler.WoodCutterBlockEntityScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WoodCutterScreen extends HandledScreen<WoodCutterBlockEntityScreenHandler> {

    private static final Identifier TEXTURE = new Identifier("textures/gui/woodcutter.png");

    public WoodCutterScreen(WoodCutterBlockEntityScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawGuiTexture(TEXTURE, 0, 0, backgroundWidth, backgroundHeight);
    }
}
