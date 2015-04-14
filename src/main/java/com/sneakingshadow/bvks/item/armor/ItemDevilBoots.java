package com.sneakingshadow.bvks.item.armor;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;

public class ItemDevilBoots extends ItemBVKSArmor
{
    public ItemDevilBoots()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.BOOTS);
        this.setUnlocalizedName(Names.Items.DevilBoots);
    }
}
