package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.reference.Armor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Name;

public class ItemArmorDevilBoots extends ItemBVKSArmor
{
    public ItemArmorDevilBoots()
    {
        super(Name.Item.DEVIL_BOOTS, Name.Armor.DEVIL, Armor.Material.DEVIL, Armor.Type.BOOTS);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.fallDistance = 0F;
        player.addPotionEffect(new PotionEffect(Potion.jump.getId(),0,3,true));
    }
}
