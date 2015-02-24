package com.sneakingshadow.bvks.item.armor;

import com.sneakingshadow.bvks.item.ItemBVKS;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianHelmet extends ItemBVKSArmor
{
    public ItemObsidianHelmet()
    {
        super(Names.ArmorTextures.Obsidian, Armor.Material.Obsidian, Armor.Type.HELMET);
        this.setUnlocalizedName(Names.Items.ObsidianHelmet);
    }
}