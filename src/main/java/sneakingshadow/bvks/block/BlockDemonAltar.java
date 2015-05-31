package sneakingshadow.bvks.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.reference.RenderIds;
import sneakingshadow.bvks.tileentity.TileEntityDemonAltar;

public class BlockDemonAltar extends BlockContainerBVKS{

    public BlockDemonAltar(){
        super();
        this.setBlockName(Names.Blocks.DEMON_ALTAR);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) { return new TileEntityDemonAltar(); }


    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderIds.demonAltar;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}
