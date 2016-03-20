package sneakingshadow.bvks.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.tileentity.TileEntityBottomlessVoidAccessor;

/**
 * Created by SneakingShadow on 20.03.2016.
 */
public class BlockBottomlessVoidAccessor extends BlockBVKSContainer{

    public BlockBottomlessVoidAccessor(String unlocalizedName) {
        super(unlocalizedName, Material.wood);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param world
     * @param metadata
     */
    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        TileEntityBottomlessVoidAccessor tileEntity = new TileEntityBottomlessVoidAccessor();
        tileEntity.setWorldObj(world);
        return tileEntity;
    }
}
