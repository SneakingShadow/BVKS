package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.base.ItemBVKS;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import java.util.List;

public class ItemDebugItem extends ItemBVKS {

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Use at own risk!");
    }

    public ItemDebugItem() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.DebugItem);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        if(!world.isRemote && !world.restoringBlockSnapshots) {
            //if (itemStack.stackTagCompound == null)
            //{
            //    itemStack.setTagCompound(new NBTTagCompound());
            //}

            //if (!itemStack.stackTagCompound.hasKey("ench", 9))
            //{
            //   itemStack.stackTagCompound.setTag("ench", new NBTTagList());
            //}

            if(entityPlayer.isSneaking()){
                LogHelper.info("sneaking");
            }else{
                LogHelper.info("standing");
            }
        }
        return itemStack;
    }

    @SubscribeEvent
    public void onItemPickUp(EntityItemPickupEvent evt) {

    }
}
