package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemDebugItem extends ItemBVKSHammer {

    public ItemDebugItem() {
        super(ItemToolMaterial.DevilHammer, 21, 21, 21);
        this.setUnlocalizedName(Names.Items.DebugItem);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Use at own risk!");
    }
}
