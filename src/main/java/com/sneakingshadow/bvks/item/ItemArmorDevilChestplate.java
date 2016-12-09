package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.item.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Name;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemArmorDevilChestplate extends ItemBVKSArmor
{
    public ItemArmorDevilChestplate()
    {
        super(Name.Item.DEVIL_CHESTPLATE, Name.Armor.DEVIL, Armor.Material.DEVIL, Armor.Type.CHESTPLATE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add("The heart of a devil");
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.fallDistance = 0F;
        player.capabilities.allowFlying = true;
    }
}