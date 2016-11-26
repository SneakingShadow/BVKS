package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.base.ItemBVKSShovel;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.reference.Tool;

public class ItemToolDevilShovel extends ItemBVKSShovel
{
    public ItemToolDevilShovel()
    {
        super(Name.Item.DEVIL_SHOVEL, Tool.ItemToolMaterial.DEVIL_SHOVEL);
    }

    @Override
    public boolean isDamageable() { return false; }
}