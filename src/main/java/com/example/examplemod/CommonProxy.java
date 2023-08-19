package com.example.examplemod;

import com.example.examplemod.network.packet.PaketAddPlayerPatty;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

public class CommonProxy {

    public static final int GUI_CHEST = 0;
    public EntityPlayer getPlayerEntity(MessageContext ctx) {
        return ctx.getServerHandler().playerEntity;
    }
    public void preInit(FMLPreInitializationEvent event){
    }

    public void postInit(FMLPostInitializationEvent event){

    }

    public void init(FMLInitializationEvent event){

    }
}
