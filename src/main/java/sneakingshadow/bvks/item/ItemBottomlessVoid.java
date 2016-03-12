package sneakingshadow.bvks.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import sneakingshadow.bvks.BVKS;
import sneakingshadow.bvks.init.ModGuis;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Name;

import java.util.List;

public class ItemBottomlessVoid extends ItemBVKS {
    private static int iconAmount = 3;
    private static IIcon[] itemIcons;
    public static IIcon[] itemTransparentIcons;

    public ItemBottomlessVoid() {
        super(Name.Item.BOTTOMLESS_VOID);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (itemStack.getItemDamage() != 0) {
            ItemStack itemStack1 = ItemStack.loadItemStackFromNBT(itemStack.getTagCompound().getCompoundTag("Item"));
            long count = itemStack.getTagCompound().getLong("Count");

            if ( Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT )) {
                list.add("Place in crafting table");
                if (count == 0)
                    list.add("to clear");
                else
                    list.add("to get out items");
                list.add("");
                list.add("Item: " + itemStack1.getItem().getItemStackDisplayName(itemStack1));
                list.add("Amount: " + count);
                list.add("Damage: " + itemStack1.getItemDamage());
                list.add("Custom display-name:");
                list.add(itemStack1.hasDisplayName() ? itemStack1.getDisplayName() : "none");
                list.add("Enchantments: " + (itemStack1.isItemEnchanted() ? "" : "none"));
                NBTTagList tagList = itemStack1.getEnchantmentTagList();
                if (tagList != null)
                    for (int i = 0; i < tagList.tagCount(); ++i)
                    {
                        short short1 = tagList.getCompoundTagAt(i).getShort("id");
                        short short2 = tagList.getCompoundTagAt(i).getShort("lvl");

                        if (Enchantment.enchantmentsList[short1] != null)
                        {
                            list.add(Enchantment.enchantmentsList[short1].getTranslatedName(short2));
                        }
                    }
            }else
                list.add(this.getDescription(".shift"));
        } else {
            list.add(this.getDescription());
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iIconRegister) {
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
        if (entityPlayer.isSneaking()) {
            if (!world.isRemote && !world.restoringBlockSnapshots) {
                itemStack.setItemDamage(
                    itemStack.getItemDamage() == 0 ? 0:
                            itemStack.getItemDamage() == 1 ? 2:1
                );
            } else {

            }
        } else
            entityPlayer.openGui(BVKS.instance, ModGuis.guiBottomlessVoid.getID(), world, findItemStack(itemStack, entityPlayer.inventory.mainInventory) ,0,0);

        return itemStack;
    }

    private int findItemStack(ItemStack itemStack, ItemStack[] mainInventory) {
        for (int i = 0; i<mainInventory.length; i++)
            if (itemStack == mainInventory[i])
                return i;
        return -1;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        return super.getUnlocalizedName() + (meta == 0 ? "" : (meta == 1 ? "_inactive" : "_active"));
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        return false;
    }

    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean currentItem) {
        if (entity instanceof EntityPlayer) {
            ItemStack[] mainInventory = ((EntityPlayer) entity).inventory.mainInventory;
            for (int i = 0; i<mainInventory.length; i++){

            }
        }
    }

/*
                Crafting
*/
    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        ItemStack itemStack1 = itemStack.getItemDamage() == 0 ? null : ItemStack.loadItemStackFromNBT(itemStack.getTagCompound().getCompoundTag("Item"));
        return super.getItemStackDisplayName(itemStack) + (itemStack.getItemDamage() == 0 ? "" : (": '" + itemStack1.getItem().getItemStackDisplayName(itemStack1) + "'"));
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack itemStack1 = itemStack.copy();
        NBTTagCompound tag = itemStack1.getTagCompound();
        ItemStack itemStack2 = ItemStack.loadItemStackFromNBT(itemStack1.getTagCompound().getCompoundTag("Item"));
        tag.setLong("Count", tag.getLong("Count") - (tag.getLong("Count") > itemStack2.getMaxStackSize() ? itemStack2.getMaxStackSize() : tag.getLong("Count")));
        return itemStack1;
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return itemStack.getItemDamage() != 0 && itemStack.getTagCompound().getLong("Count") != 0;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack){
        return itemStack.getTagCompound().getLong("Count") == 0;
    }
}


