package com.sneakingshadow.bvks.item.tool.devil;

import com.sneakingshadow.bvks.item.base.ItemBVKSAxe;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ItemDevilAxe extends ItemBVKSAxe
{
    public ItemDevilAxe()
    {
        super(ItemToolMaterial.DevilAxe);
        this.setUnlocalizedName(Names.Items.DevilAxe);
        this.setInvisible();
    }
}