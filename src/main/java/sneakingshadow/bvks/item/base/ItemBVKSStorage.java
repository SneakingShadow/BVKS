package sneakingshadow.bvks.item.base;

import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.reference.Tags;
import sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import java.util.List;

public class ItemBVKSStorage extends ItemBVKS {
    private static String description;
    private static int iconAmount = 3;
    private static IIcon[] itemIcons;

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (itemStack.stackTagCompound != null && itemStack.stackTagCompound.hasKey(Ref.MOD_ID, 10) && itemStack.stackTagCompound.getCompoundTag(Ref.MOD_ID).hasKey(Tags.Storage.info, 10)) {
            NBTTagCompound storageTag = itemStack.stackTagCompound.getCompoundTag(Ref.MOD_ID).getCompoundTag(Tags.Storage.info);
            if (storageTag.getInteger(Tags.Storage.id) > 0) {
                list.add("Type stored: " + storageTag.getString(Tags.Storage.name));
                list.add("Amount stored: " + storageTag.getLong(Tags.Storage.storedAmount));
                if (storageTag.getLong(Tags.Storage.storedAmount) <= 0)
                    list.add("Place in crafting table to clear this item");
                else
                    list.add("Place in crafting table to get out items");
            } else {
                list.add("Combine with item in crafting table to set type");
            }
        } else {
            list.add("Combine with item in crafting table to set type");
        }
        if (description != null)
            list.add(description);
    }

    public ItemBVKSStorage() {
        super();
        this.setMaxStackSize(1);
    }

    public ItemBVKSStorage setDescription(String str) {
        description = str;
        return this;
    }

    public static void setupTags(ItemStack itemStack) {
        Tags.setTags(itemStack);

        NBTTagCompound bvksTag = itemStack.stackTagCompound.getCompoundTag(Ref.MOD_ID);

        if (!bvksTag.hasKey(Tags.Storage.info, 10))
            bvksTag.setTag(Tags.Storage.info, new NBTTagCompound());

        NBTTagCompound storageTag = bvksTag.getCompoundTag(Tags.Storage.info);

        if (!storageTag.hasKey(Tags.Storage.id, 3))
            storageTag.setInteger(Tags.Storage.id, -1);
        if (!storageTag.hasKey(Tags.Storage.meta, 3))
            storageTag.setInteger(Tags.Storage.meta, 0);
        if (!storageTag.hasKey(Tags.Storage.removingAmount, 3))
            storageTag.setInteger(Tags.Storage.removingAmount, 0);
        if (!storageTag.hasKey(Tags.Storage.storedAmount, 4))
            storageTag.setLong(Tags.Storage.storedAmount, 0);
        if (!storageTag.hasKey(Tags.Storage.name, 8))
            storageTag.setString(Tags.Storage.name, "");
        if (!storageTag.hasKey(Tags.Storage.stackTag, 10))
            storageTag.setTag(Tags.Storage.stackTag, new NBTTagCompound());
        if (!storageTag.hasKey(Tags.Storage.stackTagNull))
            storageTag.setBoolean(Tags.Storage.stackTagNull, true);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iIconRegister) {
        this.itemIcon = iIconRegister.registerIcon(this.getIconString() + "_0");
        this.itemIcons = new IIcon[iconAmount];
        for (int i = 0; i < iconAmount; i++) {
            this.itemIcons[i] = iIconRegister.registerIcon(this.getIconString() + "_" + i);
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote && !world.restoringBlockSnapshots) {
            setupTags(itemStack);
            NBTTagCompound storageTag = itemStack.stackTagCompound.getCompoundTag(Tags.Storage.info);

            if (entityPlayer.isSneaking()) {
                itemStack.setItemDamage(itemStack.getItemDamage() == 2 ? 1 : 2);
            } else {
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
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer) entity;
            setupTags(itemStack);
            NBTTagCompound storageTag = itemStack.stackTagCompound.getCompoundTag(Ref.MOD_ID).getCompoundTag(Tags.Storage.info);

            if (itemStack.getItemDamage() == 2 && storageTag.getInteger(Tags.Storage.id) > 0) {
                InventoryPlayer inventory = entityPlayer.inventory;
                for (int i = 0; i < inventory.mainInventory.length; ++i) {
                    if (inventory.mainInventory[i] != null && (storageTag.getBoolean(Tags.Storage.stackTagNull) ? inventory.mainInventory[i].stackTagCompound == null : inventory.mainInventory[i].stackTagCompound != null)) {
                        boolean flag = true;
                        if (inventory.mainInventory[i].stackTagCompound != null) {
                            storageTag.getCompoundTag(Tags.Storage.stackTag).setByte("Count", inventory.mainInventory[i].stackTagCompound.getByte("Count"));
                            if (!storageTag.getCompoundTag(Tags.Storage.stackTag).equals(inventory.mainInventory[i].stackTagCompound))
                                flag = false;
                        }
                        if (flag && getItemById(storageTag.getInteger(Tags.Storage.id)).equals(inventory.mainInventory[i].getItem())) {
                            storageTag.setLong(Tags.Storage.storedAmount, storageTag.getLong(Tags.Storage.storedAmount) + inventory.mainInventory[i].stackSize);
                            inventory.mainInventory[i] = null;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        if (itemStack.stackTagCompound != null) {
            NBTTagCompound tag = itemStack.stackTagCompound.getCompoundTag(Tags.Storage.info);
            tag.setLong(Tags.Storage.storedAmount, tag.getLong(Tags.Storage.storedAmount) - tag.getInteger(Tags.Storage.removingAmount));
        }
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        return this.itemIcons[meta];
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        switch (itemStack.getItemDamage()) {
            case 2:
                return super.getUnlocalizedName(itemStack) + "_active";
            case 1:
                return super.getUnlocalizedName(itemStack) + "_inactive";
        }
        return super.getUnlocalizedName(itemStack);
    }

    @SubscribeEvent
    public void onPickupItem(EntityItemPickupEvent event) {
        LogHelper.info("Pickup");
    }
}
