package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.base.ItemBVKSPickaxe;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.reference.Tool;

public class ItemToolDevilPickaxe extends ItemBVKSPickaxe
{
    public ItemToolDevilPickaxe()
    {
        super(Name.Item.DEVIL_PICKAXE, Tool.ItemToolMaterial.DEVIL_PICKAXE);
    }

    @Override
    public boolean isDamageable() { return false; }
}