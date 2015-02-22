package com.sneakingshadow.bvks;

import com.sneakingshadow.bvks.handler.ConfigurationHandler;
import com.sneakingshadow.bvks.init.ModBlocks;
import com.sneakingshadow.bvks.init.ModItems;
import com.sneakingshadow.bvks.init.Recipes;
import com.sneakingshadow.bvks.proxy.IProxy;
import com.sneakingshadow.bvks.reference.Reference;
import com.sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class BVKS
{
    @Mod.Instance(Reference.MOD_ID)
    public static BVKS instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();
        ModBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {


        LogHelper.info("Post Initialization Complete!");
    }
}
