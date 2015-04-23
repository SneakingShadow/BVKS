package com.sneakingshadow.bvks.item.tool.obsidian;

import com.sneakingshadow.bvks.item.base.ItemBVKS;
import com.sneakingshadow.bvks.item.base.ItemBVKSSword;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianSword extends ItemBVKSSword
{
    public ItemObsidianSword()
    {
        super(ItemToolMaterial.Obsidian);
        this.setUnlocalizedName(Names.Items.ObsidianSword);
    }
}