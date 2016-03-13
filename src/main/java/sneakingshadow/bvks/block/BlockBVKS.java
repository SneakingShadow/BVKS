package sneakingshadow.bvks.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Ref;

import java.util.List;

public class BlockBVKS extends Block
{

    private IIcon north;
    private IIcon south;
    private IIcon east;
    private IIcon west;
    private IIcon top;
    private IIcon bottom;

    public BlockBVKS(String unlocalizedName, Material material)
    {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
    }

    public BlockBVKS(String unlocalizedName) {
        this(unlocalizedName, Material.rock);
    }

    private int amount = 0;
    /**
     * sets how many sub-blocks the block has
     */
    public void setSubBlocks(int amount) {
        this.amount = amount;
    }
    public boolean hasSubBlocks() {
        return this.amount != 0;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        if (!hasSubBlocks())
            list.add(new ItemStack(item, 1,0));
        for (int i = 0; i < this.amount; ++i)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Ref.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
        north = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_north")));
        south = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_south")));
        east = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_east")));
        west = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_west")));
        top = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_top")));
        bottom = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName() + "_bottom")));
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        return false;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    /*@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == Dir.up ? top :
                side == Dir.down ? bottom :
                        side == Dir.north ? north:
                                side == Dir.south ? south:
                                        side == Dir.east ? east:
                                                west;
    }*/

    /**
     * Called when the block is placed in the world.
     */
    /*public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
    {
        int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
        if (l == 4)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
        if (l == 5)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }*/
}
