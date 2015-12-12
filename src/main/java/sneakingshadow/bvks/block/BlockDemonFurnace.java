package sneakingshadow.bvks.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Dir;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

public class BlockDemonFurnace extends BlockContainerBVKS {

    private IIcon north;
    private IIcon south;
    private IIcon east;
    private IIcon west;
    private IIcon top;
    private IIcon bottom;

    public BlockDemonFurnace() {
        super();
        this.setBlockName(Name.Block.DEMON_FURNACE);
        this.setTileEntity(TileEntityDemonFurnace.class, Name.Block.DEMON_FURNACE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        north = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_north")));
        south = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_south")));
        east = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_east")));
        west = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_west")));
        top = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_top")));
        bottom = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_bottom")));
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param world
     * @param metadata
     */
    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityDemonFurnace();
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == Dir.up ? top :
                side == Dir.down ? bottom :
                        side == Dir.north ? north:
                                side == Dir.south ? south:
                                        side == Dir.east ? east:
                                                west;
    }
}
