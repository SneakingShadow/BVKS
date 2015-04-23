package com.sneakingshadow.bvks.item.armor.devil;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemDevilChestplate extends ItemBVKSArmor
{
    public ItemDevilChestplate()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.CHESTPLATE);
        this.setUnlocalizedName(Names.Items.DevilChestplate);
        this.setInvisible();
    }
}