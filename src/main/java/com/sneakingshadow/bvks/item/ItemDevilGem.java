package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.ItemBVKS;
import com.sneakingshadow.bvks.reference.Names;
import net.minecraft.item.ItemStack;

public class ItemDevilGem extends ItemBVKS
{
    public ItemDevilGem()
    {
        super();
        this.setUnlocalizedName(Names.Items.DevilGem);
        this.maxStackSize = 64;
    }
}
