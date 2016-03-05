package sneakingshadow.bvks.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import sneakingshadow.bvks.client.renderer.entity.EntityRenderAwesomeCow;
import sneakingshadow.bvks.client.renderer.entity.EntityRenderMiniSteve;
import sneakingshadow.bvks.client.renderer.item.ItemRenderBottomlessVoid;
import sneakingshadow.bvks.client.renderer.tileentity.TileEntityRendererDemonAltar;
import sneakingshadow.bvks.client.settings.Keybindings;
import sneakingshadow.bvks.entity.EntityAwesomeCow;
import sneakingshadow.bvks.entity.EntityMiniSteve;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.tileentity.TileEntityDemonAltar;

public class ClientProxy extends CommonProxy
{
    public static int demonAltar;

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

        demonAltar = RenderingRegistry.getNextAvailableRenderId();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDemonAltar.class, new TileEntityRendererDemonAltar());
    }
}
