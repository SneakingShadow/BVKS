package com.sneakingshadow.bvks.item.tool;

import com.sneakingshadow.bvks.item.base.ItemBVKS;
import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianHammer extends ItemBVKSHammer
{
    public ItemObsidianHammer()
    {
        super(ItemToolMaterial.ObsidianHammer, 6,6,6);
        this.setUnlocalizedName(Names.Items.ObsidianHammer);
    }
}