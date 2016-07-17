package sneakingshadow.bvks.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.structure.MultiBlock;
import sneakingshadow.bvks.structure.Structure;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;
import sneakingshadow.bvks.util.LogHelper;

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
        MultiBlock multiBlock = new MultiBlock("aaa/a a/aaa", 'a', '!', '*');
        Structure structure = multiBlock.findStructure(world,x,y,z,2,1,2);
        System.out.println(multiBlock.toString());
        LogHelper.info(structure.structureValid(world));
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return null;
    }
}
