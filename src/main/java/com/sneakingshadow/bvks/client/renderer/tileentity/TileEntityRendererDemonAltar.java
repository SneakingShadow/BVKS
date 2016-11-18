package com.sneakingshadow.bvks.client.renderer.tileentity;

import com.sneakingshadow.bvks.client.model.ModelDemonAltar;
import com.sneakingshadow.bvks.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererDemonAltar extends TileEntitySpecialRenderer {

    private ModelDemonAltar modelDemonAltar = new ModelDemonAltar();

    public TileEntityRendererDemonAltar(){

    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {

        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);

        bindTexture(Textures.Models.DEMON_ALTAR);
        modelDemonAltar.render();

        GL11.glPopMatrix();
    }
}
