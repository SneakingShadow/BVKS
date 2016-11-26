package com.sneakingshadow.bvks.item.base;

import com.sneakingshadow.bvks.reference.Reference;
import com.sneakingshadow.bvks.util.BlockBreakingHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBVKS extends Item
{
    public ItemBVKS(String unlocalizedName)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.setNoRepair();
    }

    @Override
    public Item setUnlocalizedName(String string) {
        return super.setUnlocalizedName(Reference.RESOURCE_PREFIX + string);
    }

    public String getUnwrappedUnlocalizedName() {
        return this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getIconString()
    {
        return getUnwrappedUnlocalizedName();
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase)
    {
        return !devilTool || devilBreakBlock(itemStack, world, block, x, y, z, entityLivingBase);
    }

    private boolean devilTool = false;

    public ItemBVKS setDevilTool() {
        devilTool = true;
        return this;
    }

    public boolean devilBreakBlock(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) {
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
        {
            itemStack.damageItem(1, entityLivingBase);
            BlockBreakingHelper.breakBlock(itemStack, world, block, x, y, z, entityLivingBase);
        }
        return false;
    }
}

