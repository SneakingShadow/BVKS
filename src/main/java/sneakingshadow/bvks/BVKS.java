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
        WorldGen.init();
        ModEntities.init();
        ModGuis.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();
        ModGuis.init();

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());

        proxy.registerCustomRender();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, guiHandler);

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }
}

/*

//TODO:

Add custom texture handler for devil tools to make them invisible.

Make an item that will teleport back to the players inventory when dropped, then make it an enchantment.
Make the item store the players name as nbt, then make an item that will in it's class create a reference to the player, sorted by playername.
Check if you can get the player name any other way.

Hammer workbench, tier 1-3
Tier 1: makes wood, turns wood to stone, and stone to iron
Tier 2: turns iron to gold, and gold to diamond
Tier 3: turns diamond to obsidian and obsidian to devil
Can be upgraded with sword, shovel, pickaxe, axe, hoe, (bow?), (shears?), (bucket?), (flint-and-steel), and other tools.
Can only be upgraded as far as the hammer, and has to be upgraded the same way as the hammer along with it.
You can't upgrade a gold hammer with a diamond pickaxe, but you can upgrade it with a stone, wood, iron etc.

Multiple gates that open with redstone
Opens with a sliding animation

Use for demon altar

*/