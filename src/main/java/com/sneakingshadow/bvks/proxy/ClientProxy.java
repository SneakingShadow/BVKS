package com.sneakingshadow.bvks.proxy;

import com.sneakingshadow.bvks.client.renderer.entity.EntityRenderAwesomeCow;
import com.sneakingshadow.bvks.client.renderer.entity.EntityRenderMiniSteve;
import com.sneakingshadow.bvks.client.renderer.item.ItemRenderBottomlessVoid;
import com.sneakingshadow.bvks.client.renderer.tileentity.TileEntityRendererDemonAltar;
import com.sneakingshadow.bvks.client.settings.Keybindings;
import com.sneakingshadow.bvks.entity.EntityAwesomeCow;
import com.sneakingshadow.bvks.entity.EntityMiniSteve;
import com.sneakingshadow.bvks.init.ModItems;
import com.sneakingshadow.bvks.tileentity.TileEntityDemonAltar;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

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
