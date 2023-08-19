package com.example.examplemod.network;

import com.example.examplemod.network.packet.PaketAddPlayerPatty;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.Iterator;
import java.util.Set;

public class PacketDispatcher {
    private static byte packetId = 0;
    private static final SimpleNetworkWrapper dispatcher;

    public static void registerPackets() {
        registerMessage(PaketAddPlayerPatty.Handler.class,PaketAddPlayerPatty.class,Side.CLIENT);
    }

    private static final void registerMessage(Class handlerClass, Class messageClass, Side side) {
        packetId = ++packetId;
        dispatcher.registerMessage(handlerClass, messageClass, packetId, side);
    }

    private static final void registerMessage(Class clazz) {
        if (AbstractMessage.AbstractClientMessage.class.isAssignableFrom(clazz)) {
            packetId = ++packetId;
            dispatcher.registerMessage(clazz, clazz, packetId, Side.CLIENT);
        } else if (AbstractMessage.AbstractServerMessage.class.isAssignableFrom(clazz)) {
            packetId = ++packetId;
            dispatcher.registerMessage(clazz, clazz, packetId, Side.SERVER);
        } else {
            packetId = ++packetId;
            dispatcher.registerMessage(clazz, clazz, packetId, Side.CLIENT);
            dispatcher.registerMessage(clazz, clazz, packetId, Side.SERVER);
        }
    }

    public static final void sendTo(IMessage message, EntityPlayerMP player) {
        dispatcher.sendTo(message, player);
    }

    public static void sendToAll(IMessage message) {
        dispatcher.sendToAll(message);
    }

    public static final void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) {
        dispatcher.sendToAllAround(message, point);
    }

    public static final void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range) {
        sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
    }

    public static final void sendToAllAround(IMessage message, EntityPlayer player, double range) {
        sendToAllAround(message, player.worldObj.provider.dimensionId, player.posX, player.posY, player.posZ, range);
    }

    public static final void sendToDimension(IMessage message, int dimensionId) {
        dispatcher.sendToDimension(message, dimensionId);
    }

    public static final void sendToServer(IMessage message) {
        dispatcher.sendToServer(message);
    }

    public static final void sendToPlayers(IMessage message, Set players) {
        Iterator<EntityPlayer> var2 = players.iterator();
        while (var2.hasNext()) {
            EntityPlayer player = var2.next();
            dispatcher.sendTo(message, (EntityPlayerMP)player);
        }
    }
    static {
        dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel("NarutoUniverse");
    }
}
