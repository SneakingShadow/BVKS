package sneakingshadow.bvks.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Ref;

public abstract class BlockBVKSContainer extends BlockBVKS implements ITileEntityProvider{

    public BlockBVKSContainer(Material material){
        super(material);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.isBlockContainer = true;
    }

    public BlockBVKSContainer(){
        this(Material.rock);
    }

    public BlockBVKSContainer setTileEntity(Class tileEntity, String name){
        TileEntity.addMapping(tileEntity, Ref.RESOURCE_PREFIX + name);
        return this;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param world
     * @param metadata
     */
    @Override
    abstract public TileEntity createNewTileEntity(World world, int metadata);
}
