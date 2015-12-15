package sneakingshadow.bvks.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import sneakingshadow.bvks.client.renderer.entity.EntityRenderAwesomeCow;
import sneakingshadow.bvks.client.renderer.entity.EntityRenderMiniSteve;
import sneakingshadow.bvks.client.renderer.item.ItemRenderBottomlessVoid;
import sneakingshadow.bvks.client.renderer.tileentity.TileEntityRendererDemonAltar;
import sneakingshadow.bvks.client.settings.Keybindings;
import sneakingshadow.bvks.entity.EntityAwesomeCow;
import sneakingshadow.bvks.entity.EntityMiniSteve;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.reference.RenderIds;
import sneakingshadow.bvks.tileentity.TileEntityDemonAltar;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }

    @Override
    public void registerCustomRender() {
        MinecraftForgeClient.registerItemRenderer(ModItems.BottomlessVoid, new ItemRenderBottomlessVoid());

        RenderingRegistry.registerEntityRenderingHandler(EntityAwesomeCow.class, new EntityRenderAwesomeCow());
        RenderingRegistry.registerEntityRenderingHandler(EntityMiniSteve.class, new EntityRenderMiniSteve());

        RenderIds.demonAltar = RenderingRegistry.getNextAvailableRenderId();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDemonAltar.class, new TileEntityRendererDemonAltar());
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}
