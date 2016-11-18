package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.base.ItemBVKSSword;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.reference.Tool;

public class ItemToolDevilSword extends ItemBVKSSword
{
    public ItemToolDevilSword()
    {
        super(Name.Item.DEVIL_SWORD, Tool.ItemToolMaterial.DEVIL_SWORD);
    }

    @Override
    public boolean isDamageable() { return false; }
}