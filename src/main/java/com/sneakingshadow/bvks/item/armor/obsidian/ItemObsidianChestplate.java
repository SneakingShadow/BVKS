package com.sneakingshadow.bvks.item.armor.obsidian;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianChestplate extends ItemBVKSArmor
{
    public ItemObsidianChestplate()
    {
        super(Names.ArmorTextures.Obsidian, Armor.Material.Obsidian, Armor.Type.CHESTPLATE);
        this.setUnlocalizedName(Names.Items.ObsidianChestplate);
    }
}