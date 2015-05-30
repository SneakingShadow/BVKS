package sneakingshadow.bvks.item;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.reference.Tags;
import sneakingshadow.bvks.util.LogHelper;

import java.util.List;

public class ItemBottomlessVoid extends ItemBVKS {
    private static int iconAmount = 3;
    private static IIcon[] itemIcons;
    public static IIcon[] itemTransparentIcons;

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        super.addDescription(list);
        if (itemStack.getItemDamage() != 0) {
            NBTTagCompound storageTag = itemStack.stackTagCompound.getCompoundTag(Ref.MOD_ID);
            list.add("Type stored: " + storageTag.getString(Tags.Storage.NAME));
            list.add("Amount stored: " + storageTag.getLong(Tags.Storage.STORED_AMOUNT));
            if (storageTag.getLong(Tags.Storage.STORED_AMOUNT) <= 0)
                list.add("Place in crafting table to clear this item");
            else
                list.add("Place in crafting table to get out items");
        } else {
            list.add("Combine with item in crafting table to set type");
        }
    }

    public ItemBottomlessVoid() {
        super();
        this.setMaxStackSize(1);
        this.setBaseName(Names.Items.BOTTOMLESS_VOID);
    }

    public static void setupTags(ItemStack itemStack) {
        Tags.setTags(itemStack);

        NBTTagCompound storageTag = itemStack.stackTagCompound.getCompoundTag(Ref.MOD_ID);

        if (!storageTag.hasKey(Tags.Storage.ID, 3))
            storageTag.setInteger(Tags.Storage.ID, -1);
        if (!storageTag.hasKey(Tags.Storage.META, 3))
            storageTag.setInteger(Tags.Storage.META, 0);
        if (!storageTag.hasKey(Tags.Storage.STORED_AMOUNT, 4))
            storageTag.setLong(Tags.Storage.STORED_AMOUNT, 0);
        if (!storageTag.hasKey(Tags.Storage.NAME, 8))
            storageTag.setString(Tags.Storage.NAME, "");
        if (!storageTag.hasKey(Tags.Storage.STACK_TAG, 10))
            storageTag.setTag(Tags.Storage.STACK_TAG, new NBTTagCompound());
        if (!storageTag.hasKey(Tags.Storage.STACK_TAG_NULL))
            storageTag.setBoolean(Tags.Storage.STACK_TAG_NULL, true);
        if (!storageTag.hasKey(Tags.Storage.MAX_STACK_SIZE, 1))
            storageTag.setByte(Tags.Storage.STACK_TAG_NULL, (byte)1);
    }

    private static NBTTagCompound get(ItemStack itemStack){
        setupTags(itemStack);
        return itemStack.stackTagCompound.getCompoundTag(Ref.MOD_ID);
    }
    public static int getID(ItemStack itemStack){ return get(itemStack).getInteger(Tags.Storage.ID); }
    public static int getMeta(ItemStack itemStack){ return get(itemStack).getInteger(Tags.Storage.META); }
    public static long getStored(ItemStack itemStack){ return get(itemStack).getLong(Tags.Storage.STORED_AMOUNT); }
    public static String getName(ItemStack itemStack){ return get(itemStack).getString(Tags.Storage.NAME); }
    public static NBTTagCompound getStackTag(ItemStack itemStack){ return get(itemStack).getCompoundTag(Tags.Storage.STACK_TAG); }
    public static boolean getStackTagNull(ItemStack itemStack){ return get(itemStack).getBoolean(Tags.Storage.STACK_TAG_NULL); }
    public static int getMaxStackSize(ItemStack itemStack){ return get(itemStack).getByte(Tags.Storage.MAX_STACK_SIZE); }

    public static boolean storesBlock(ItemStack itemStack){ return getItem(itemStack) instanceof ItemBlock; }
    public static Item getItem(ItemStack itemStack){ return Item.getItemById(getID(itemStack)); }
    public static boolean hasItems(ItemStack itemStack){ return getStored(itemStack)>0; }

    public static void setID(ItemStack itemStack, int id){ get(itemStack).setInteger(Tags.Storage.ID, id); }
    public static void setMeta(ItemStack itemStack, int meta){ get(itemStack).setInteger(Tags.Storage.META, meta); }
    public static void setStored(ItemStack itemStack, long stored){ get(itemStack).setLong(Tags.Storage.STORED_AMOUNT, stored); }
    public static void setName(ItemStack itemStack, String name){ get(itemStack).setString(Tags.Storage.NAME, name); }
    public static void setStackTag(ItemStack itemStack, NBTTagCompound tag){ get(itemStack).setTag(Tags.Storage.STACK_TAG, tag); }
    public static void setStackTagNull(ItemStack itemStack, boolean bool){ get(itemStack).setBoolean(Tags.Storage.STACK_TAG_NULL, bool); }
    public static void setMaxStackSize(ItemStack itemStack, int size){ get(itemStack).setByte(Tags.Storage.MAX_STACK_SIZE, (byte) size); }

    public static boolean remove(ItemStack itemStack, long remove){
        Long stored = getStored(itemStack);
        if(stored >= remove) {
            setStored(itemStack, stored - remove);
            return true;
        }
        return false;
    }

    public static void add(ItemStack itemStack, long add){
        setStored(itemStack, getStored(itemStack) + add);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iIconRegister) {
        this.itemIcon = iIconRegister.registerIcon(this.getIconString() + "_0");
        itemIcons = new IIcon[iconAmount];
        for (int i = 0; i < iconAmount; i++) {
            itemIcons[i] = iIconRegister.registerIcon(this.getIconString() + "_" + i);
        }
        itemTransparentIcons = new IIcon[iconAmount];
        for (int i = 0; i < iconAmount; i++) {
            itemTransparentIcons[i] = iIconRegister.registerIcon(this.getIconString() + "_transparent_" + i);
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote && !world.restoringBlockSnapshots) {
            setupTags(itemStack);

            if (entityPlayer.isSneaking()) {
                if(itemStack.getItemDamage() != 0)
                    itemStack.setItemDamage((itemStack.getItemDamage() == 2) ? 1 : 2);
            } else {
                //Place block (if it is one...)
                LogHelper.info(itemStack.stackTagCompound);
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

            if ((itemStack.getItemDamage() == 2) && getID(itemStack) > 0) {
                InventoryPlayer inventory = entityPlayer.inventory;
                for (int i = 0; i < inventory.mainInventory.length; ++i) {
                    if (inventory.mainInventory[i] != null && (getStackTagNull(itemStack) ? inventory.mainInventory[i].stackTagCompound == null : inventory.mainInventory[i].stackTagCompound != null)) {
                        boolean flag = true;
                        if (inventory.mainInventory[i].stackTagCompound != null) {
                            getStackTag(itemStack).setByte("Count", inventory.mainInventory[i].stackTagCompound.getByte("Count"));
                            if (!getStackTag(itemStack).equals(inventory.mainInventory[i].stackTagCompound))
                                flag = false;
                        }
                        if (flag && getItem(itemStack).equals(inventory.mainInventory[i].getItem())) {
                            if(getStored(itemStack) != Long.MAX_VALUE)
                                add(itemStack, inventory.mainInventory[i].stackSize);
                            inventory.mainInventory[i] = null;
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        if(meta == 3){
            meta -= 2;
        }
        return itemIcons[meta];
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        if(meta == 2)
            return super.getUnlocalizedName(itemStack) + "_active";
        if(meta == 1 || meta == 3)
            return super.getUnlocalizedName(itemStack) + "_inactive";
        return super.getUnlocalizedName(itemStack);
    }

    @SubscribeEvent
    public void onPickupItem(EntityItemPickupEvent event) {
        LogHelper.info("Pickup");
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        int stored = (int)getStored(itemStack);
        if(stored == 0)
            return null;

        int extract = Math.min(Math.min(64, stored), getMaxStackSize(itemStack));
        ItemStack copy = itemStack.copy();
        remove(copy, extract);

        copy.setItemDamage(1);

        return copy;
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return getContainerItem(itemStack) != null;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        return meta != 3;
    }
}
