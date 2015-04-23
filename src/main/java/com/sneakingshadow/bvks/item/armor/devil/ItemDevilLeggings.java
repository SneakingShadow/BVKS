package com.sneakingshadow.bvks.item.armor.devil;

import com.sneakingshadow.bvks.item.base.ItemBVKSArmor;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemDevilLeggings extends ItemBVKSArmor
{
    public ItemDevilLeggings()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.LEGGINGS);
        this.setUnlocalizedName(Names.Items.DevilLeggings);
        this.setInvisible();
    }
}