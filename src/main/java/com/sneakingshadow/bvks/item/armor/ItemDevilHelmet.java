package com.sneakingshadow.bvks.item.armor;

import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;

public class ItemDevilHelmet extends ItemBVKSArmor
{
    public ItemDevilHelmet()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.HELMET);
        this.setUnlocalizedName(Names.Items.DevilHelmet);
    }
}