package com.sneakingshadow.bvks.item.armor;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;

public class ItemDevilChestplate extends ItemBVKSArmor
{
    public ItemDevilChestplate()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.CHESTPLATE);
        this.setUnlocalizedName(Names.Items.DevilChestplate);
    }
}