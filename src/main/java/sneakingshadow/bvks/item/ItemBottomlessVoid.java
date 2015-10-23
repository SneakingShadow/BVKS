package sneakingshadow.bvks.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.util.LogHelper;
import java.util.List;

public class ItemBottomlessVoid extends ItemBVKS {
    private static int iconAmount = 3;
    private static IIcon[] itemIcons;
    public static IIcon[] itemTransparentIcons;

    public ItemBottomlessVoid() {
        super();
        this.setMaxStackSize(1);
        this.setBaseName(Names.Items.BOTTOMLESS_VOID);
    }

    //TODO add metadata 3 back again, add tag "Decrease", make Extract recipe extract right amount, currently only gives one item, fix SetType recipe, make Extract recipe not delete void when it's empty, and make Extract let the void stay in the crafting window.
    /*Tags:
    *   Item:
    *       {
    *           Count: ..l
    *           id: ..s,
    *           tag: {..},
    *           Damage: ..s,
    *       }
    */

    public static ItemStack getItemStackStored(ItemStack itemStack) {
        NBTTagCompound nbtTagCompound = itemStack.getTagCompound().getCompoundTag("Item");
        NBTTagCompound itemCompound = new NBTTagCompound();
        itemCompound.setShort("id", nbtTagCompound.getShort("id"));
        itemCompound.setTag("tag", nbtTagCompound.getCompoundTag("tag"));
        itemCompound.setShort("Damage", nbtTagCompound.getShort("Damage"));
        itemCompound.setByte("Count", (byte) 1);
        return ItemStack.loadItemStackFromNBT(itemCompound);
    }

    public static ItemStack extractStack(ItemStack itemStack) {
        NBTTagCompound nbtTagCompound = itemStack.getTagCompound().getCompoundTag("Item");
        ItemStack itemStack1 = getItemStackStored(itemStack);
        if(nbtTagCompound.getLong("Count") < itemStack1.getMaxStackSize()){
            itemStack1.getTagCompound().setByte("Count", (byte)nbtTagCompound.getLong("Count"));
            nbtTagCompound.setLong("Count", 0);
        }else{
            itemStack1.getTagCompound().setByte("Count", (byte) itemStack1.getMaxStackSize());
            nbtTagCompound.setLong("Count", nbtTagCompound.getLong("Count") - itemStack1.getMaxStackSize());
        }
        return itemStack1;
    }

    public static Boolean isItemsEqual(NBTTagCompound itemCompound, NBTTagCompound bottomlessVoidCompound){
        return itemCompound.getShort("id") == bottomlessVoidCompound.getShort("id") &&
                itemCompound.getByte("Damage") == bottomlessVoidCompound.getByte("Damage") &&
                itemCompound.getCompoundTag("tag").equals(bottomlessVoidCompound.getCompoundTag("tag"));
    }

    public static void raiseItemCount(NBTTagCompound nbtTagCompound, long l)
    {
        nbtTagCompound.setLong("Count",
                (nbtTagCompound.getLong("Count")+l) <= (2^63 -308) ?
                        nbtTagCompound.getLong("Count") :
                        (2^63 -308)
        );
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add("Stores one type of item/block");
        if (itemStack.getItemDamage() != 0) {
            NBTTagCompound nbtTagCompound = itemStack.getTagCompound().getCompoundTag("Item");
            ItemStack itemStack1 = getItemStackStored(itemStack);

            LogHelper.info(itemStack.getTagCompound());
            LogHelper.info(itemStack1.getItem());
            LogHelper.info(itemStack1.getItem() instanceof ItemBlock);
            list.add("Item stored: " + itemStack1.getDisplayName());
            list.add("Amount stored: " + nbtTagCompound.getLong("Count"));
            if (nbtTagCompound.getLong("Count") == 0)
                list.add("Place in crafting table to clear this item");
            else
                list.add("Place in crafting table to get out items");
        } else
            list.add("Combine with item in crafting table to set type");

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

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        return itemIcons[meta];
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote && !world.restoringBlockSnapshots) {
            if (entityPlayer.isSneaking()) {
                itemStack.setItemDamage( itemStack.getItemDamage() == 0 ? 0 : ((itemStack.getItemDamage() == 2) ? 1 : 2));
            } else {

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
            //TODO: Find items in inventory
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        return super.getUnlocalizedName(itemStack) + (meta == 0 ? "" : (meta == 1 ? "_inactive" : "_active"));
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack itemStack1 = itemStack.copy();
        if(itemStack.getItemDamage() != 0 && itemStack.getTagCompound().getCompoundTag("Item").getLong("Count") != 0) return itemStack1;
        return null;
    }

    @Override
    public boolean  hasContainerItem(ItemStack itemStack) {
        return itemStack.getItemDamage() != 0 && itemStack.getTagCompound().getCompoundTag("Item").getLong("Count") != 0;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        return itemStack.getItemDamage() != 0 && itemStack.getTagCompound().getCompoundTag("Item").getLong("Count") != 0;
    }

    //TODO Fix what's below and make the item suck tings up on playerpickup and not just steal everything from their inventory.

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        //TODO place block if it stores a block, with correct metadata and nbtdata.
        return false;
    }
}
