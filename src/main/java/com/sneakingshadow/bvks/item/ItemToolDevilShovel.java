package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.reference.Tool;
import com.sneakingshadow.bvks.item.base.ItemBVKSShovel;
import com.sneakingshadow.bvks.reference.Name;

public class ItemToolDevilShovel extends ItemBVKSShovel
{
    public ItemToolDevilShovel()
    {
        super(Name.Item.DEVIL_SHOVEL, Tool.ItemToolMaterial.DEVIL_SHOVEL);
    }

    @Override
    public boolean isDamageable() { return false; }
}