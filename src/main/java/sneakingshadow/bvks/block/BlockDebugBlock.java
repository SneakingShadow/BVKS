package sneakingshadow.bvks.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;

public class BlockDebugBlock extends BlockBVKSContainer {

    public BlockDebugBlock(){
        super(Name.Block.DEBUG_BLOCK);
        this.setTileEntity(TileEntityDebugBlock.class, Name.Block.DEBUG_BLOCK);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        /*
        MultiBlock multiBlock = new MultiBlock(
                "ccccce/ccccce/ccccce/ccccce\\cccce/cccce/cccce/cccce\\/ mm/ mm",
                'c', Blocks.cobblestone,
                //'C', MultiBlockUtil.arrayList('!', Blocks.cobblestone),
                'e', new StairComparator(Blocks.stone_stairs).addDirections(StairComparator.NORTH),
                'm', ModBlocks.DebugBlock
        ).setFullRotation();

        LogHelper.info(multiBlock.multiBlockToString());

        LogHelper.info( multiBlock.findStructure(world,x,y,z).structureValid(world) );
        */

        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return null;
    }
}
