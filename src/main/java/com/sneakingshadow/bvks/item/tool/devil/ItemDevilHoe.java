package com.sneakingshadow.bvks.item.tool.devil;

import com.sneakingshadow.bvks.item.base.ItemBVKSHoe;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemDevilHoe extends ItemBVKSHoe
{
    public ItemDevilHoe() {
        super(ItemToolMaterial.DevilHoe);
        this.setUnlocalizedName(Names.Items.DevilHoe);
        this.setInvisible();
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Lets you be the grim reaper!");
        list.add("Also functions like a hoe");
        list.add("Gotta love them hoes");
    }
}
