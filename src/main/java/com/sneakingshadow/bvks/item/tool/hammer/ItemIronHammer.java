package com.sneakingshadow.bvks.item.tool.hammer;

import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;

public class ItemIronHammer extends ItemBVKSHammer
{
    public ItemIronHammer()
    {
        super(ItemToolMaterial.IronHammer, 3,3,3);
        this.setUnlocalizedName(Names.Items.IronHammer);
    }
}