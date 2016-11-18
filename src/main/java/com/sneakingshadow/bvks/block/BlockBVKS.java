package com.sneakingshadow.bvks.block;

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
import com.sneakingshadow.bvks.reference.Reference;

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

    @Override
    public Block setBlockName(String string) {
        return super.setBlockName(Reference.RESOURCE_PREFIX + string);
    }

    public String getUnwrappedUnlocalizedName() {
        return getUnlocalizedName().substring(getUnlocalizedName().indexOf('.')+1);
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
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        String string = getUnwrappedUnlocalizedName();
        blockIcon = iconRegister.registerIcon(string);
        north = iconRegister.registerIcon(string + "_north");
        south = iconRegister.registerIcon(string + "_south");
        east = iconRegister.registerIcon(string + "_east");
        west = iconRegister.registerIcon(string + "_west");
        top = iconRegister.registerIcon(string + "_top");
        bottom = iconRegister.registerIcon(string + "_bottom");
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
