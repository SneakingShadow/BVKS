package com.sneakingshadow.bvks.item.tool.hammer;

import com.sneakingshadow.bvks.init.ModItems;
import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianHammer extends ItemBVKSHammer
{
    public ItemObsidianHammer()
    {
        super(ItemToolMaterial.ObsidianHammer, 4,4,4, ModItems.ObsidianShovel);
        this.setUnlocalizedName(Names.Items.ObsidianHammer);
    }
}