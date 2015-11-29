package sneakingshadow.bvks.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
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
        return getItemStackStored(itemStack.getTagCompound().getCompoundTag("Item"));
    }

    public static ItemStack getItemStackStored(NBTTagCompound nbtTagCompound) {
        NBTTagCompound itemCompound = new NBTTagCompound();
        itemCompound.setShort("id", nbtTagCompound.getShort("id"));
        itemCompound.setTag("tag", nbtTagCompound.getCompoundTag("tag"));
        itemCompound.setShort("Damage", nbtTagCompound.getShort("Damage"));
        itemCompound.setByte("Count", (byte) 1);
        return ItemStack.loadItemStackFromNBT(itemCompound);
    }

    public static ItemStack extractStack(ItemStack itemStack) {
        NBTTagCompound nbtTagCompound = itemStack.getTagCompound().getCompoundTag("Item");
        NBTTagCompound itemCompound = new NBTTagCompound();
        itemCompound.setShort("id", nbtTagCompound.getShort("id"));
        itemCompound.setTag("tag", nbtTagCompound.getCompoundTag("tag"));
        itemCompound.setShort("Damage", nbtTagCompound.getShort("Damage"));
        itemCompound.setByte("Count", (byte) 1);
        ItemStack itemStack1 = ItemStack.loadItemStackFromNBT(itemCompound);
        if(nbtTagCompound.getLong("Count") < itemStack1.getMaxStackSize()){
            itemCompound.setByte("Count", (byte) nbtTagCompound.getLong("Count"));
        }else{
            itemCompound.setByte("Count", (byte) itemStack1.getMaxStackSize());
        }
        return ItemStack.loadItemStackFromNBT(itemCompound);
    }

    public static ItemStack extractWithRemoval(ItemStack itemStack, int size) {
        NBTTagCompound nbtTagCompound = itemStack.getTagCompound().getCompoundTag("Item");
        NBTTagCompound itemCompound = new NBTTagCompound();
        itemCompound.setShort("id", nbtTagCompound.getShort("id"));
        itemCompound.setTag("tag", nbtTagCompound.getCompoundTag("tag"));
        itemCompound.setShort("Damage", nbtTagCompound.getShort("Damage"));
        itemCompound.setByte("Count", (byte) 1);
        ItemStack itemStack1 = ItemStack.loadItemStackFromNBT(itemCompound);
        if(nbtTagCompound.getLong("Count") < size){
            itemCompound.setByte("Count", (byte) nbtTagCompound.getLong("Count"));
            nbtTagCompound.setLong("Count", 0);
        }else{
            itemCompound.setByte("Count", (byte) size);
            nbtTagCompound.setLong("Count", nbtTagCompound.getLong("Count")-size);
        }
        return ItemStack.loadItemStackFromNBT(itemCompound);
    }

    public static Boolean isItemsEqual(ItemStack itemStack, NBTTagCompound bottomlessVoidCompound){
        NBTTagCompound nbtTagCompound = bottomlessVoidCompound.getCompoundTag("Item");
        return Item.getIdFromItem(itemStack.getItem()) == nbtTagCompound.getShort("id") &&
                itemStack.getItemDamage() == nbtTagCompound.getByte("Damage") &&
                (itemStack.getTagCompound() == null ?
                        nbtTagCompound.getCompoundTag("tag").hasNoTags() :
                        itemStack.getTagCompound().equals(nbtTagCompound.getCompoundTag("tag"))
                );
    }

    public static Boolean isItemsEqual(ItemStack itemStack, ItemStack itemStackBottomlessVoid){
        return isItemsEqual(itemStack, itemStackBottomlessVoid.getTagCompound());
    }

    public static void raiseItemCount(ItemStack itemStack, long l){
        raiseItemCount(itemStack.getTagCompound().getCompoundTag("Item"), l);
    }

    public static void raiseItemCount(NBTTagCompound nbtTagCompound, long l)
    {
        nbtTagCompound.setLong("Count",
                (nbtTagCompound.getLong("Count")) <= (Math.pow(2,63) -308) ?
                        nbtTagCompound.getLong("Count")+l :
                        (long)(Math.pow(2,63) -308)
        );
    }

    public static boolean isItemBlock(ItemStack itemStack){
        return isItemBlock(itemStack.getTagCompound().getCompoundTag("Item"));
    }

    public static boolean isItemBlock(NBTTagCompound nbtTagCompound){
        NBTTagCompound nbtTagCompound1 = (NBTTagCompound)nbtTagCompound.copy();
        nbtTagCompound1.setByte("Count", (byte) 1);
        ItemStack itemStack1 = ItemStack.loadItemStackFromNBT(nbtTagCompound1);
        return itemStack1 != null && itemStack1.getItem() != null && itemStack1.getItem() instanceof ItemBlock;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (itemStack.getItemDamage() != 0) {
            ItemStack itemStack1 = getItemStackStored(itemStack);

            NBTTagCompound voidTagCompound = itemStack.getTagCompound();
            NBTTagCompound itemTagCompound = voidTagCompound.getCompoundTag("Item");
            NBTTagCompound stackTagCompound = itemStack1.getTagCompound();

            if (itemTagCompound.getLong("Count") == 0)
                list.add("Place in crafting table to clear the bottomless void of set item");
            else
                list.add("Place in crafting table to get out items");

            list.add("Item stored: " + itemStack1.getItem().getItemStackDisplayName(itemStack1));
            list.add("Amount stored: " + itemTagCompound.getLong("Count"));

            if ( Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT )) {
                //TODO if player is sneaking, show extra information. Enchantments, custom name, etc..

                list.add("Item ID: " + itemTagCompound.getShort("id"));
                list.add("Item metadata: " + itemTagCompound.getShort("Damage"));

                if (itemTagCompound.hasKey("display")) {
                    NBTTagCompound nbttagcompound = itemTagCompound.getCompoundTag("display");
                    if (nbttagcompound.hasKey("Name"))
                        list.add("Display name: " + nbttagcompound.getString("Name"));
                }
                if (itemTagCompound.hasKey("ench")){
                    //TODO
                }
                list.add("Stores a block: " + isItemBlock(itemTagCompound));
            }else
                list.add("Press shift for more info");

        } else {
            list.add("Stores one type of item/block");
            list.add("Combine with item in crafting table to set type");
        }
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
                itemStack.setItemDamage(
                        itemStack.getItemDamage() == 0 ? 0:
                                itemStack.getItemDamage() == 1 ? 2:1
                );
            } else {

            }
        }

        return itemStack;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        return super.getUnlocalizedName(itemStack) + (meta == 0 ? "" : (meta == 1 ? "_inactive" : "_active"));
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        //TODO place block if it stores a block, with correct metadata and nbtdata.
        return false;
    }

    //TODO Fix what's below and make the item suck tings up on playerpickup and not just steal everything from their inventory.

    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean bool) {
        if (entity instanceof EntityPlayer) {
            ItemStack[] mainInventory = ((EntityPlayer) entity).inventory.mainInventory;
            for (int i = 0; i<mainInventory.length; i++){

            }
            //TODO: Find items in inventory, then only make it update on pickup, and always keep a stack in the inventory, but not more.
        }
    }

/*
                Crafting
*/
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack itemStack1 = itemStack.copy();
        if(hasContainerItem(itemStack)) return itemStack1;
        return null;
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return itemStack.getItemDamage() != 0 && itemStack.getTagCompound().getCompoundTag("Item").getLong("Count") != 0;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        return itemStack.getItemDamage() == 0 || itemStack.getTagCompound().getCompoundTag("Item").getLong("Count") == 0;
    }
}


