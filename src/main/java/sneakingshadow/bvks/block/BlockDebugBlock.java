package sneakingshadow.bvks.block;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;

import java.util.List;

public class BlockDebugBlock extends BlockContainerBVKS{

    public BlockDebugBlock(){
        super();
        this.setBlockName(Names.Blocks.DebugBlock);
    }

    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) { }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityDebugBlock();
    }
}
