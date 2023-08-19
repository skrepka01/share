package com.example.examplemod.pakets;

import com.example.examplemod.ClientProxy;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;

import static com.example.examplemod.ClientProxy.copied;

public class PaketForPlayer00 implements IMessage {
    @Override
    public void fromBytes(ByteBuf buf) {
        PacketBuffer packetBuf = new PacketBuffer(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        PacketBuffer packetBuf = new PacketBuffer(buf);
    }
    public static class Handler implements IMessageHandler<PaketForPlayer00,IMessage> {

        @Override
        public IMessage onMessage(PaketForPlayer00 message, MessageContext ctx) {
            EntityPlayerMP playerMP = ctx.getServerHandler().playerEntity;
            String namePlayer = playerMP.getDisplayName();
            Minecraft minecraft = Minecraft.getMinecraft();
            for(String s : copied) {
                if(namePlayer.equals(s)){
                    for(int i = 0; i< copied.size(); i++) {
                        minecraft.fontRenderer.drawString(copied.get(i),100, 100+(i * 20), 16777215, false);
                    }
                }
            }
            minecraft.getTextureManager().bindTexture(Gui.icons);

            return null;
        }
    }
}
