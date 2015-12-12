package sneakingshadow.bvks.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockDemonFurnace extends BlockBVKS {

    private IIcon side;
    //private IIcon side;
    //private IIcon side;

    public BlockDemonFurnace() {
        super();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {

    }
}
