package sneakingshadow.bvks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import sneakingshadow.bvks.client.handler.KeyInputEventHandler;
import sneakingshadow.bvks.handler.ConfigurationHandler;
import sneakingshadow.bvks.handler.GuiHandler;
import sneakingshadow.bvks.init.*;
import sneakingshadow.bvks.proxy.IProxy;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.structure.modifer.Modifiers;
import sneakingshadow.bvks.util.LogHelper;

@Mod(modid = Ref.MOD_ID, name = Ref.MOD_NAME, version = Ref.VERSION, guiFactory = Ref.GUI_FACTORY_CLASS)
public class BVKS
{
    @Mod.Instance(Ref.MOD_ID)
    public static BVKS instance;

    @SidedProxy(clientSide = Ref.CLIENT_PROXY_CLASS, serverSide = Ref.SERVER_PROXY_CLASS)
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
        ModGuis.init();

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