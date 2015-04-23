package com.sneakingshadow.bvks.item.armor.devil;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemDevilHelmet extends ItemBVKSArmor
{
    public ItemDevilHelmet()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.HELMET);
        this.setUnlocalizedName(Names.Items.DevilHelmet);
        this.setInvisible();
    }
}