package sneakingshadow.bvks.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;

public abstract class BlockContainerBVKS extends BlockBVKS implements ITileEntityProvider{

    public BlockContainerBVKS(Material material){
        super(material);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.isBlockContainer = true;
    }

    public BlockContainerBVKS(){
        this(Material.rock);
    }

    public BlockContainerBVKS setTileEntity(Class tileEntity, String name){
        TileEntity.addMapping(tileEntity, Ref.RESOURCE_PREFIX + name);
        return this;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityDebugBlock();
    }
}
