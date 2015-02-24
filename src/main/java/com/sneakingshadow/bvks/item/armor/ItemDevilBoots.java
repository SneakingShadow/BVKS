package com.sneakingshadow.bvks.item.armor;

import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.util.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDevilBoots extends ItemBVKSArmor
{
    public ItemDevilBoots()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.BOOTS);
        this.setUnlocalizedName(Names.Items.DevilBoots);
    }
}
