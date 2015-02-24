package com.sneakingshadow.bvks.item.armor;

import com.sneakingshadow.bvks.item.ItemBVKS;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;

public class ItemDevilLeggings extends ItemBVKSArmor
{
    public ItemDevilLeggings()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.LEGGINGS);
        this.setUnlocalizedName(Names.Items.DevilLeggings);
    }
}