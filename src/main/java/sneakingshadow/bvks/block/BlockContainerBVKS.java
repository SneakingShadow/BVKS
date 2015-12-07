package sneakingshadow.bvks.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockContainerBVKS extends BlockBVKS implements ITileEntityProvider{

    public BlockContainerBVKS(Material material){
        super(material);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.isBlockContainer = true;
    }

    public BlockContainerBVKS(){
        this(Material.rock);
    }

    public boolean onBlockEventReceived(World world, int x, int y, int z, int EventID, int EventParameter)
    {
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null && tileentity.receiveClientEvent(EventID, EventParameter);
    }
}
