package com.sneakingshadow.bvks.item.tool;

import com.sneakingshadow.bvks.item.base.ItemBVKS;
import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;

public class ItemGoldHammer extends ItemBVKSHammer
{
    public ItemGoldHammer()
    {
        super(ItemToolMaterial.GoldHammer, 4,4,4);
        this.setUnlocalizedName(Names.Items.GoldHammer);
    }
}