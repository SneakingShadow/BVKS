package sneakingshadow.bvks.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.MinecraftForgeClient;
import sneakingshadow.bvks.client.model.ModelAwesomeCow;
import sneakingshadow.bvks.client.renderer.Entity.RenderAwesomeCow;
import sneakingshadow.bvks.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import sneakingshadow.bvks.entity.EntityAwesomeCow;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.client.renderer.RenderBottomlessVoid;

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
        MinecraftForgeClient.registerItemRenderer(ModItems.BottomlessVoid, new RenderBottomlessVoid());
        RenderingRegistry.registerEntityRenderingHandler(EntityAwesomeCow.class, new RenderAwesomeCow());
    }
}
