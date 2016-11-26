package com.sneakingshadow.bvks;

import com.sneakingshadow.bvks.client.handler.KeyInputEventHandler;
import com.sneakingshadow.bvks.handler.ConfigurationHandler;
import com.sneakingshadow.bvks.handler.GuiHandler;
import com.sneakingshadow.bvks.init.*;
import com.sneakingshadow.bvks.proxy.IProxy;
import com.sneakingshadow.bvks.reference.Reference;
import com.sneakingshadow.bvks.structure.modifer.Modifiers;
import com.sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class BVKS
{
    @Mod.Instance(Reference.MOD_ID)
    public static BVKS instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    public static IGuiHandler guiHandler = new GuiHandler();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        proxy.registerKeyBindings();

        ModItems.init();
        ModBlocks.init();
        ModWorldGen.init();
        ModEntities.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        ModRecipes.init();
        ModGuis.init();

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());

        proxy.registerCustomRender();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, guiHandler);

        LogHelper.info("Initialization Complete!");

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Modifiers.init();
        ModMultiBlocks.init();

        LogHelper.info("Post Initialization Complete!");
    }

}