package com.sneakingshadow.bvks.item.tool.hammer;

import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;
import net.minecraft.init.Items;

public class ItemGoldHammer extends ItemBVKSHammer
{
    public ItemGoldHammer()
    {
        super(ItemToolMaterial.GoldHammer, 3,3,3, Items.golden_shovel);
        this.setUnlocalizedName(Names.Items.GoldHammer);
    }
}