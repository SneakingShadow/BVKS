package sneakingshadow.bvks.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;

public class BlockDebugBlock extends BlockContainerBVKS{

    public BlockDebugBlock(){
        super();
        this.setBlockName(Name.Block.DEBUG_BLOCK);
        TileEntity.addMapping(TileEntityDebugBlock.class, Ref.RESOURCE_PREFIX+ Name.Block.DEBUG_BLOCK);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        TileEntityDebugBlock tileEntity = (TileEntityDebugBlock) world.getTileEntity(x, y, z);
        entityPlayer.addChatMessage(new ChatComponentText(Integer.toString(p_149727_6_)));
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) { return new TileEntityDebugBlock(); }
}
