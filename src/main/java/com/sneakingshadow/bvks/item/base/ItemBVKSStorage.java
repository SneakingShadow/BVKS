package com.sneakingshadow.bvks.item.base;

import com.sneakingshadow.bvks.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.List;

public class ItemBVKSStorage extends ItemBVKS {
    private static String displayName;
    private static String description;

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (itemStack.stackTagCompound != null) {
            NBTTagCompound storageTag = itemStack.stackTagCompound.getCompoundTag(Names.ItemStorage.info);
            if (storageTag.getInteger(Names.ItemStorage.id) > 0){
                list.add("Type stored: "+storageTag.getString(Names.ItemStorage.name));
                list.add("Amount stored: "+storageTag.getLong(Names.ItemStorage.storedAmount));
                if(storageTag.getLong(Names.ItemStorage.storedAmount) <= 0)
                    list.add("Place in crafting table to clear this item");
                else
                    list.add("Place in crafting table to get out items");
            }else{
                list.add("Combine with item in crafting table to set type");
            }
        }else {
            if(description != null)
                list.add(description);
            list.add("Combine with item in crafting table to set type");
        }
    }

    public ItemBVKSStorage(String DisplayName) {
        super();
        this.setMaxStackSize(1);
        this.displayName = DisplayName;
    }

    public ItemBVKSStorage setDescription(String str){
        description = str;
        return this;
    }

    private void setupTags(ItemStack itemStack){
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());
        if (!itemStack.stackTagCompound.hasKey(Names.ItemStorage.info, 10))
            itemStack.stackTagCompound.setTag(Names.ItemStorage.info, new NBTTagCompound());

        NBTTagCompound storageTag = itemStack.stackTagCompound.getCompoundTag(Names.ItemStorage.info);

        if (!storageTag.hasKey(Names.ItemStorage.id, 3))
            storageTag.setInteger(Names.ItemStorage.id, -1);
        if (!storageTag.hasKey(Names.ItemStorage.meta, 3))
            storageTag.setInteger(Names.ItemStorage.meta, 0);
        if (!storageTag.hasKey(Names.ItemStorage.removingAmount, 3))
            storageTag.setInteger(Names.ItemStorage.removingAmount, 0);
        if (!storageTag.hasKey(Names.ItemStorage.storedAmount, 4))
            storageTag.setLong(Names.ItemStorage.storedAmount, 0);
        if (!storageTag.hasKey(Names.ItemStorage.name, 8))
            storageTag.setString(Names.ItemStorage.name, "");
        if (!storageTag.hasKey(Names.ItemStorage.active))
            storageTag.setBoolean(Names.ItemStorage.active, false);
        if(!storageTag.hasKey(Names.ItemStorage.stackTag, 10))
            storageTag.setTag(Names.ItemStorage.stackTag, new NBTTagCompound());
        if(!storageTag.hasKey(Names.ItemStorage.stackTagNull))
            storageTag.setBoolean(Names.ItemStorage.stackTagNull, true);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        if(!world.isRemote && !world.restoringBlockSnapshots) {
            setupTags(itemStack);
            NBTTagCompound storageTag = itemStack.stackTagCompound.getCompoundTag(Names.ItemStorage.info);

            if(entityPlayer.isSneaking()) {
                storageTag.setBoolean(Names.ItemStorage.active, !storageTag.getBoolean(Names.ItemStorage.active));
            }else{
                //Place block (if it is one...)
            }
        }

        return itemStack;
    }

    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean bool) {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            setupTags(itemStack);
            NBTTagCompound storageTag = itemStack.stackTagCompound.getCompoundTag(Names.ItemStorage.info);

            if(storageTag.getBoolean(Names.ItemStorage.active) && storageTag.getInteger(Names.ItemStorage.id) > 0) {
                InventoryPlayer inventory = entityPlayer.inventory;
                for (int i = 0; i < inventory.mainInventory.length; ++i) {
                    if (inventory.mainInventory[i] != null && ( storageTag.getBoolean(Names.ItemStorage.stackTagNull) ? inventory.mainInventory[i].stackTagCompound == null : inventory.mainInventory[i].stackTagCompound != null ) ) {
                        boolean flag = true;
                        if(inventory.mainInventory[i].stackTagCompound != null) {
                            storageTag.getCompoundTag(Names.ItemStorage.stackTag).setByte("Count", inventory.mainInventory[i].stackTagCompound.getByte("Count"));
                            if(!storageTag.getCompoundTag(Names.ItemStorage.stackTag).equals(inventory.mainInventory[i].stackTagCompound))
                                flag = false;
                        }
                        if(flag && Item.getItemById(storageTag.getInteger(Names.ItemStorage.id)).equals(inventory.mainInventory[i].getItem()) ) {
                            storageTag.setLong(Names.ItemStorage.storedAmount, storageTag.getLong(Names.ItemStorage.storedAmount) + inventory.mainInventory[i].stackSize);
                            inventory.mainInventory[i] = null;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        if(itemStack.stackTagCompound != null && itemStack.stackTagCompound.hasKey(Names.ItemStorage.info, 10) && itemStack.stackTagCompound.getCompoundTag(Names.ItemStorage.info) != null && itemStack.stackTagCompound.getCompoundTag(Names.ItemStorage.info).getBoolean(Names.ItemStorage.active))
            return displayName+" (Activated)";
        return displayName+" (Deactivated)";
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        if(itemStack.stackTagCompound != null){
            NBTTagCompound tag = itemStack.stackTagCompound.getCompoundTag(Names.ItemStorage.info);
            tag.setLong(Names.ItemStorage.storedAmount, tag.getLong(Names.ItemStorage.storedAmount) - tag.getInteger(Names.ItemStorage.removingAmount) );
        }
    }
}
