package com.sneakingshadow.bvks.item.tool.obsidian;

import com.sneakingshadow.bvks.item.base.ItemBVKS;
import com.sneakingshadow.bvks.item.base.ItemBVKSShovel;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianShovel extends ItemBVKSShovel
{
    public ItemObsidianShovel()
    {
        super(ItemToolMaterial.Obsidian);
        this.setUnlocalizedName(Names.Items.ObsidianShovel);
    }
}