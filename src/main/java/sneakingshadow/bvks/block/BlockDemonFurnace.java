package sneakingshadow.bvks.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import sneakingshadow.bvks.BVKS;
import sneakingshadow.bvks.init.ModGuis;
import sneakingshadow.bvks.reference.Dir;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

public class BlockDemonFurnace extends BlockBVKSContainer {

    private IIcon north;
    private IIcon south;
    private IIcon east;
    private IIcon west;
    private IIcon top;
    private IIcon bottom;
    public IIcon[] sides = new IIcon[4];

    public BlockDemonFurnace() {
        super();
        this.setBlockName(Name.Block.DEMON_FURNACE);
        this.setTileEntity(TileEntityDemonFurnace.class, Name.Block.DEMON_FURNACE);
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
        sides = new IIcon[]{north, east, south, west};
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
    {
        int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, l==3 ? 1:l==1 ? 3:l, 2);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (side == Dir.down)
            return bottom;
        if (side == Dir.up)
            return top;
        side = side == Dir.north ? 0 :
                side == Dir.east ? 1 :
                        side == Dir.south ? 2 : 3;
        return sides[(side+meta)>3 ? side+meta-4 : side+meta];
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote) {
            entityPlayer.openGui(BVKS.instance, ModGuis.guiDemonFurnace.getID(), world, x,y,z);
        }
        return true;
    }
}
