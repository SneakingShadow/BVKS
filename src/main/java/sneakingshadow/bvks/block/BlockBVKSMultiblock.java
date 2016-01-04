package sneakingshadow.bvks.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by SneakingShadow on 04.01.2016.
 */
public abstract class BlockBVKSMultiblock extends BlockBVKSContainer {

    public BlockBVKSMultiblock() {
        super();
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param world
     * @param metadata
     */
    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return metadata != 0 ? null : getTileEntity(world, metadata);
    }

    abstract public TileEntity getTileEntity(World world, int metadata);
}
