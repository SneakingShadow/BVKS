package sneakingshadow.bvks.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.init.ModBlocks;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.structure.MultiBlock;
import sneakingshadow.bvks.structure.comparator.StairComparatorUtil;
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

        MultiBlock multiBlock = new MultiBlock();

        String[][] strings = {
                {
                        "'stair_nw''stair_n''stair_n''stair_n''stair_n''stair_n''stair_ne'",
                        "'stair_w'     'stair_e'",
                        "'stair_sw''stair_s''stair_s''stair_s''stair_s''stair_s''stair_se'",
                },
                {
                        " 'stair_nw''stair_n''stair_n''stair_n''stair_ne'",
                        " 'stair_w'   'stair_e'",
                        " 'stair_sw''stair_s''stair_s''stair_s''stair_se'",
                },
                {
                        "  'stair_nw''stair_n''stair_ne'",
                        "  'stair_w''debug''stair_e'",
                        "  'stair_sw''stair_s''stair_se'",
                },
        };
        String string = "";
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < i; j++) {
                string += "/";
            }
            string += strings[i][0] + "/";
            for (int j = i; j < 5-i; j++) {
                string += strings[i][1] + "/";
            }
            string += strings[i][2] + (i+1 == strings.length ? "" : "\\");
        }

        StairComparatorUtil.addStructuresWithAllStairsShortString(multiBlock, "stair", string, "#debug", ModBlocks.DebugBlock);

        LogHelper.info( multiBlock.findStructure(world,x,y,z).structureValid(world) );

        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return null;
    }
}
