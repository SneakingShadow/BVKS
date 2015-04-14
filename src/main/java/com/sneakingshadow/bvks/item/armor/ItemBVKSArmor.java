package com.sneakingshadow.bvks.item.armor;

import com.sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import com.sneakingshadow.bvks.reference.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemBVKSArmor extends ItemArmor
{
    private String texture;
    private int armor;

    public ItemBVKSArmor(String textureName, ArmorMaterial material, int armorType)
    {
        super(material, 0, armorType);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.setCreativeTab(CreativeTabBVKS.tabItem);
        texture = textureName;
        armor = armorType;
    }

    public ItemBVKSArmor(String textureName, ArmorMaterial material, int armorType, int renderIndex)
    {
        super(material, renderIndex, armorType);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.setCreativeTab(CreativeTabBVKS.tabItem);
        texture = textureName;
        armor = armorType;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Ref.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Ref.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Ref.RESOURCE_PREFIX+"textures/armor/" + this.texture + "_" + (this.armor == 2 ? "2" : "1") + ".png";
    }

}
