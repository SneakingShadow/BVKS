package sneakingshadow.bvks.block.MultiBlock;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import sneakingshadow.bvks.block.BlockBVKSContainer;

abstract public class BlockBVKSMultiBlock extends BlockBVKSContainer {

    public BlockBVKSMultiBlock(Material material){
        super(material);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.isBlockContainer = true;
    }
    public BlockBVKSMultiBlock(){
        this(Material.rock);
    }

}
