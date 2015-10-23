package sneakingshadow.bvks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import sneakingshadow.bvks.client.handler.KeyInputEventHandler;
import sneakingshadow.bvks.handler.ConfigurationHandler;
import sneakingshadow.bvks.init.*;
import sneakingshadow.bvks.proxy.IProxy;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.util.LogHelper;

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
        ModEntities.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());

        proxy.registerCustomRender();

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }
}

//TODO Add custom texture handler for devil tools to make them invisible.

//TODO Make an item that will teleport back to the players inventory when dropped, then make it an enchantment.
//Make the item store the players name as nbt, then make an item that will in it's class create a reference to the player, sorted by playername.
//Check if you can get the player name any other way.