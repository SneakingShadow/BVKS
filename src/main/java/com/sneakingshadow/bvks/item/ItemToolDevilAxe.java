package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.item.ItemBVKSAxe;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.reference.Tool;

public class ItemToolDevilAxe extends ItemBVKSAxe
{
    public ItemToolDevilAxe()
    {
        super(Name.Item.DEVIL_AXE, Tool.ItemToolMaterial.DEVIL_AXE);
    }

    @Override
    public boolean isDamageable() { return false; }
}