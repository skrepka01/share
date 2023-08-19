package com.example.examplemod.listeners;

import com.example.examplemod.ClientProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import static com.example.examplemod.ClientProxy.names;

public class PrintPlayerName {

    private final int
            width = 100,
            height = 100;

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        Minecraft minecraft = Minecraft.getMinecraft();
        for(int i = 0; i < names.size(); i++) {
                minecraft.fontRenderer.drawString(names.get(i), width, height + (i * 20), 16777215, false);
             minecraft.getTextureManager().bindTexture(Gui.icons);
        }
    }
}