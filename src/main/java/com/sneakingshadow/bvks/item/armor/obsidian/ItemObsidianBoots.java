package com.sneakingshadow.bvks.item.armor.obsidian;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianBoots extends ItemBVKSArmor
{
    public ItemObsidianBoots()
    {
        super(Names.ArmorTextures.Obsidian, Armor.Material.Obsidian, Armor.Type.BOOTS);
        this.setUnlocalizedName(Names.Items.ObsidianBoots);
    }
}