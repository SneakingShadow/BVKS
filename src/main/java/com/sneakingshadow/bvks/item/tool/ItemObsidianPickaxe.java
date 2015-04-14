package com.sneakingshadow.bvks.item.tool;

import com.sneakingshadow.bvks.item.base.ItemBVKS;
import com.sneakingshadow.bvks.item.base.ItemBVKSPickaxe;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianPickaxe extends ItemBVKSPickaxe
{
    public ItemObsidianPickaxe()
    {
        super(ItemToolMaterial.Obsidian);
        this.setUnlocalizedName(Names.Items.ObsidianPickaxe);
    }
}