package com.sneakingshadow.bvks.item.tool.hammer;

import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;
import net.minecraft.init.Items;

public class ItemDiamondHammer extends ItemBVKSHammer
{
    public ItemDiamondHammer()
    {
        super(ItemToolMaterial.DiamondHammer, 5,5,5, Items.diamond_shovel);
        this.setUnlocalizedName(Names.Items.DiamondHammer);
    }
}