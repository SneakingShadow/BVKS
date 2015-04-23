package com.sneakingshadow.bvks.item.tool.hammer;

import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;

public class ItemWoodHammer extends ItemBVKSHammer
{
    public ItemWoodHammer()
    {
        super(ItemToolMaterial.WoodHammer, 1,1,1);
        this.setUnlocalizedName(Names.Items.WoodHammer);
    }
}