package com.example.examplemod;

import com.example.examplemod.cmd.AddPlayerToParty;
import com.example.examplemod.network.PacketDispatcher;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    @SidedProxy(
            clientSide = "com.example.examplemod.ClientProxy",
            serverSide = "com.example.examplemod.CommonProxy"
    )
    public static CommonProxy proxy;
    @EventHandler
    public  void serverStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new AddPlayerToParty());
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
        PacketDispatcher.registerPackets();
    }
}
