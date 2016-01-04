package sneakingshadow.bvks.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.RenderIds;
import sneakingshadow.bvks.tileentity.TileEntityDemonAltar;

public class BlockDemonAltar extends BlockBVKSContainer {

    public BlockDemonAltar(){
        super();
        this.setBlockName(Name.Block.DEMON_ALTAR);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) { return new TileEntityDemonAltar(); }


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
