package sneakingshadow.bvks.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;

public class BlockDebugBlock extends BlockBVKSContainer {

    public BlockDebugBlock(){
        super();
        this.setBlockName(Name.Block.DEBUG_BLOCK);
        this.setTileEntity(TileEntityDebugBlock.class, Name.Block.DEBUG_BLOCK);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        TileEntityDebugBlock tileEntity = (TileEntityDebugBlock) world.getTileEntity(x, y, z);
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) { return null; }
}
