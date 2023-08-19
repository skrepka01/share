package com.example.examplemod;


import com.example.examplemod.listeners.PrintPlayerName;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class ClientProxy extends CommonProxy{

    public static List<String> names= new ArrayList<>(); // тут имена у Owner будут выводиться
    public static List<String> copied = new ArrayList<String>(); // копированный лист должны отправить пакетом игроку;

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new PrintPlayerName());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
    @Override
    public EntityPlayer getPlayerEntity(MessageContext ctx) {
        return ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx);
    }
}
