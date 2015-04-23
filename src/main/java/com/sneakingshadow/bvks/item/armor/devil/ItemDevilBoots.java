package com.sneakingshadow.bvks.item.armor.devil;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemDevilBoots extends ItemBVKSArmor
{
    public ItemDevilBoots()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.BOOTS);
        this.setUnlocalizedName(Names.Items.DevilBoots);
        this.setInvisible();
    }
}
