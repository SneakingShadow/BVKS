package com.sneakingshadow.bvks;

import com.sneakingshadow.bvks.proxy.IProxy;
import com.sneakingshadow.bvks.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class BVKS
{
    @Mod.Instance(Reference.MOD_ID)
    public static BVKS instance;

    @SidedProxy(clientSide = "com.sneakingshadow.bvks.proxy.ClientProxy", serverSide = "com.sneakingshadow.bvks.proxy.ServerProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
