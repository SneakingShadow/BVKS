package sneakingshadow.bvks.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.block.MultiBlock.BlockBVKSMultiBlock;
import sneakingshadow.bvks.block.MultiBlock.MultiBlockStructure;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.tileentity.TileEntityDemonAltar;
import sneakingshadow.bvks.util.LogHelper;

public class BlockDemonAltar extends BlockBVKSMultiBlock {

    MultiBlockStructure multiBlock;

    public BlockDemonAltar(){
        super();
        this.setBlockName(Name.Block.DEMON_ALTAR);
        this.setTileEntity(TileEntityDemonAltar.class, Name.Block.DEMON_ALTAR);
        this.setSubBlocks(3);
        multiBlock = new MultiBlockStructure(3, 1, 4,
                'a', 'a', 'a',
                'a', 'a', 'a',
                'a', 'a', 'a',
                'a', 'a', 'a',
                this, 'a'
        );
    }

    @Override
    public boolean hasSubBlocks(){
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return metadata == 3 ? new TileEntityDemonAltar() : null;
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        LogHelper.info(world.getBlockMetadata(x, y, z));
        if (world.getBlockMetadata(x, y, z) < 3) {
            LogHelper.info(multiBlock.findMultiBlock(world, x,y,z) == null);
        } else {

        }
        return true;
    }

}
