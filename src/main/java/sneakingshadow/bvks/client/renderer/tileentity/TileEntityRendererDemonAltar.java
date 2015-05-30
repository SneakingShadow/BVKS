package sneakingshadow.bvks.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import sneakingshadow.bvks.client.model.ModelDemonAltar;

@SideOnly(Side.CLIENT)
public class TileEntityRendererDemonAltar extends TileEntitySpecialRenderer {

    private ModelDemonAltar modelDemonAltar = new ModelDemonAltar();

    public TileEntityRendererDemonAltar(){

    }

    @Override
    public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {

    }
}
