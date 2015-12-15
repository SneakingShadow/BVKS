package sneakingshadow.bvks.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Dir;
import sneakingshadow.bvks.reference.Ref;

public class BlockBVKS extends Block
{

    private IIcon north;
    private IIcon south;
    private IIcon east;
    private IIcon west;
    private IIcon top;
    private IIcon bottom;

    public BlockBVKS(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
    }

    public BlockBVKS() {
        this(Material.rock);
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

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
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
    }
}
