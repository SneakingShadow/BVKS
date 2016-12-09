package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.item.ItemBVKSHoe;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.reference.Tool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemToolDevilHoe extends ItemBVKSHoe
{
    public ItemToolDevilHoe() {
        super(Name.Item.DEVIL_HOE, Tool.ItemToolMaterial.DEVIL_HOE);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4)
    {
        list.add("I think death dropped something..");
        list.add("Also functions like a hoe");
        list.add("Gotta love them hoes");
    }

    @Override
    public boolean isDamageable() { return false; }
}
