package sneakingshadow.bvks.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;

public class BlockDebugBlock extends BlockContainerBVKS{

    public BlockDebugBlock(){
        super();
        this.setBlockName(Names.Blocks.DEBUG_BLOCK);
        TileEntity.addMapping(TileEntityDebugBlock.class, Ref.RESOURCE_PREFIX+Names.Blocks.DEBUG_BLOCK);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        TileEntityDebugBlock tileEntity = (TileEntityDebugBlock) world.getTileEntity(x, y, z);
        if (player.isSneaking()) {
            if(tileEntity.players.tagCount() != 0){
                if(!world.isRemote && !world.restoringBlockSnapshots) {
                    player.addChatComponentMessage(new ChatComponentText("All the players who have clicked this block:"));
                    for (int i = 0; i < tileEntity.players.tagCount(); i++) {
                        player.addChatComponentMessage(new ChatComponentText(tileEntity.players.getStringTagAt(i)));
                    }
                }
            }else
                if(!world.isRemote && !world.restoringBlockSnapshots)
                    player.addChatComponentMessage(new ChatComponentText("No'one has clicked this block yet"));
        }else if(!tileEntity.hasPlayer(player.getDisplayName()))
            tileEntity.addPlayer(player.getDisplayName());
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) { return new TileEntityDebugBlock(); }
}
