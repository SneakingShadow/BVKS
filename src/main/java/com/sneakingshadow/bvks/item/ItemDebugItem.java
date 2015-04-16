package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.base.ItemBVKS;
import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.util.EnchantmentHelper;
import com.sneakingshadow.bvks.util.LogHelper;
import com.sneakingshadow.bvks.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLootBonus;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import sun.rmi.runtime.Log;

import java.util.List;

public class ItemDebugItem extends ItemBVKS {

    public ItemDebugItem() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.DebugItem);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){

        EnchantmentHelper.removeAll(itemStack);

        if(!world.isRemote && !world.restoringBlockSnapshots && false) {

            if(EnchantmentHelper.hasEnchant(Enchantment.fortune, itemStack)){
                EnchantmentHelper.remove(Enchantment.fortune, itemStack);
                EnchantmentHelper.setLevel(Enchantment.silkTouch, 1, itemStack);
            }else if(EnchantmentHelper.hasEnchant(Enchantment.silkTouch, itemStack)){
                EnchantmentHelper.remove(Enchantment.silkTouch, itemStack);
                EnchantmentHelper.remove(Enchantment.fortune, itemStack);
            }else{
                EnchantmentHelper.setLevel(Enchantment.fortune, 3, itemStack);
            }

        }
        return itemStack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Use at own risk!");
    }
}
