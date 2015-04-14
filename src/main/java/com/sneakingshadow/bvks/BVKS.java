package com.sneakingshadow.bvks;

import com.sneakingshadow.bvks.client.handler.KeyInputEventHandler;
import com.sneakingshadow.bvks.handler.ConfigurationHandler;
import com.sneakingshadow.bvks.init.ModBlocks;
import com.sneakingshadow.bvks.init.ModItems;
import com.sneakingshadow.bvks.init.Recipes;
import com.sneakingshadow.bvks.proxy.*;
import com.sneakingshadow.bvks.reference.Ref;
import com.sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Ref.MOD_ID, name = Ref.MOD_NAME, version = Ref.VERSION, guiFactory = Ref.GUI_FACTORY_CLASS)
public class BVKS
{
    @Mod.Instance(Ref.MOD_ID)
    public static BVKS instance;

    @SidedProxy(clientSide = Ref.CLIENT_PROXY_CLASS, serverSide = Ref.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        proxy.registerKeyBindings();

        ModItems.init();
        ModBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }
}
