package com.sneakingshadow.bvks.item.armor;

import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;

public class ItemObsidianLeggings extends ItemBVKSArmor
{
    public ItemObsidianLeggings()
    {
        super(Names.ArmorTextures.Obsidian, Armor.Material.Obsidian, Armor.Type.LEGGINGS);
        this.setUnlocalizedName(Names.Items.ObsidianLeggings);
    }
}