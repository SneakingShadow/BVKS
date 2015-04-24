package com.sneakingshadow.bvks.item.armor.devil;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDevilLeggings extends ItemBVKSArmor
{
    public ItemDevilLeggings()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.LEGGINGS);
        this.setUnlocalizedName(Names.Items.DevilLeggings);
        this.setInvisible();
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 0, 3, true));
    }
}