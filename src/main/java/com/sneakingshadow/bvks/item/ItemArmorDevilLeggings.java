package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Name;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class ItemArmorDevilLeggings extends ItemBVKSArmor
{
    public ItemArmorDevilLeggings()
    {
        super(Name.Item.DEVIL_LEGGINGS, Name.Armor.DEVIL, Armor.Material.DEVIL, Armor.Type.LEGGINGS);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 0, 3, true));
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add("Saitama's leggings");
    }
}