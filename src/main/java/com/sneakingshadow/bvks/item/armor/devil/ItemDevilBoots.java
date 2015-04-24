package com.sneakingshadow.bvks.item.armor.devil;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDevilBoots extends ItemBVKSArmor
{
    public ItemDevilBoots()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.BOOTS);
        this.setUnlocalizedName(Names.Items.DevilBoots);
        this.setInvisible();
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.fallDistance = 0F;
        player.addPotionEffect(new PotionEffect(Potion.jump.getId(),0,3,true));
    }
}
