package com.sneakingshadow.bvks.item.tool;

import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.util.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemDevilHammer extends ItemBVKSHammer
{
    public ItemDevilHammer()
    {
        super(ItemToolMaterial.DevilHammer, 7, 7, 7);
        this.setUnlocalizedName(Names.Items.DevilHammer);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("The devil has a taste for worlds");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        LogHelper.all(itemStack.getEnchantmentTagList());
        return itemStack;
    }
}