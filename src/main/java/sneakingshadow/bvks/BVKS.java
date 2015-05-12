package sneakingshadow.bvks;

import sneakingshadow.bvks.client.handler.KeyInputEventHandler;
import sneakingshadow.bvks.handler.ConfigurationHandler;
import sneakingshadow.bvks.init.ModBlocks;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.init.Recipes;
import sneakingshadow.bvks.init.WorldGen;
import sneakingshadow.bvks.proxy.IProxy;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.util.LogHelper;
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
        WorldGen.init();

        //proxy.registerCustomRender();

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

//TODO Add custom texture handler for devil tools to make them invisible..