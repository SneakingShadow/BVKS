package com.sneakingshadow.bvks.block;

import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.tileentity.TileEntityDemonAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDemonAltar extends BlockBVKSContainer {

    public BlockDemonAltar(){
        super(Name.Block.DEMON_ALTAR);
        this.setTileEntity(TileEntityDemonAltar.class, Name.Block.DEMON_ALTAR);
        this.setSubBlocks(3);
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
        return true;
    }

}
