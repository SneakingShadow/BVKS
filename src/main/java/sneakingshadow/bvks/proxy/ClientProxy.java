package sneakingshadow.bvks.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import sneakingshadow.bvks.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.item.ItemBottomlessVoid;
import sneakingshadow.bvks.render.RenderBottomlessVoid;

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
    }

}
