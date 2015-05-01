package sneakingshadow.bvks.block;

import sneakingshadow.bvks.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockDebugBlock extends BlockBVKS{

    private int textures = 11;  //Amount of textures block will add, starting from 0 to amount of textures minus 1
    private IIcon icon[] = new IIcon[textures];
    private int iduration = -1;

    public BlockDebugBlock(){
        super();
        this.setBlockName(Names.Blocks.DebugBlock);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int i=0; i<textures; i++){
            icon[i] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()))+"_"+i);
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        iduration++;
        if(iduration >= 11000) iduration=-1;
        return this.icon[iduration/1000];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon func_149735_b(int p_149735_1_, int p_149735_2_)
    {
        return this.getIcon(p_149735_1_, p_149735_2_);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        return this.getIcon(p_149673_5_, world.getBlockMetadata(p_149673_2_, p_149673_3_, p_149673_4_));
    }
}
