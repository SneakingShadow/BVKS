package com.sneakingshadow.bvks.item.tool;

import com.sneakingshadow.bvks.item.base.ItemBVKS;
import com.sneakingshadow.bvks.item.base.ItemBVKSHoe;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianHoe extends ItemBVKSHoe
{
    public ItemObsidianHoe()
    {
        super(ItemToolMaterial.Obsidian);
        this.setUnlocalizedName(Names.Items.ObsidianHoe);
    }
}