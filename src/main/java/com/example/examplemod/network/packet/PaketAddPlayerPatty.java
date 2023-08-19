package com.example.examplemod.network.packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

import static com.example.examplemod.ClientProxy.names;

public class PaketAddPlayerPatty implements IMessage {
    private List<String> table;
    public PaketAddPlayerPatty() {
        this.table = new ArrayList();
    }

    public PaketAddPlayerPatty(List<String> table) {
        this.table = table;
    }
    @Override
    public void fromBytes(ByteBuf buf) {
        int length = buf.readInt();

        for(int i = 0; i < length; ++i) {
            this.table.add(ByteBufUtils.readUTF8String(buf));
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.table.size());

        for(int i = 0; i < this.table.size(); ++i) {
            ByteBufUtils.writeUTF8String(buf, (String)this.table.get(i));
        }
    }
    public static class Handler implements IMessageHandler<PaketAddPlayerPatty,IMessage> {
        public Handler() {
        }
        @Override
        public IMessage onMessage(PaketAddPlayerPatty message, MessageContext ctx) {
            names.clear();
            names.addAll(message.table);
            return null;
        }
    }
}
