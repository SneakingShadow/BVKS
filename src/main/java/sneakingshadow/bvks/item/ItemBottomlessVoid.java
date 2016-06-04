package sneakingshadow.bvks.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.util.BottomlessVoidHelper;
import sneakingshadow.bvks.util.LogHelper;

import java.util.List;

public class ItemBottomlessVoid extends ItemBVKS {
    private static IIcon[] itemIcons = new IIcon[3];

    public ItemBottomlessVoid() {
        super(Name.Item.BOTTOMLESS_VOID);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        /*if (itemStack.getItemDamage() != 0) {
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
                list.add("Hold shift for info");
        } else {
            list.add("Stores items.");
            list.add("To set type,");
            list.add("combine with item in crafting table");
        }*/
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iIconRegister) {
        for (int i = 0; i < itemIcons.length; i++) {
            itemIcons[i] = iIconRegister.registerIcon(this.getIconString() + "_" + i);
        }
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        return itemIcons[meta & 3];
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        LogHelper.info(itemStack.getTagCompound());

        if (entityPlayer.isSneaking()) {
            if (!world.isRemote && !world.restoringBlockSnapshots) {
                itemStack.setItemDamage(
                    itemStack.getItemDamage() == 0 ? 0:
                            itemStack.getItemDamage() == 1 ? 2:1
                );
            } else {

            }
        } else
            LogHelper.info(Minecraft.getMinecraft().objectMouseOver);

            /*int slot = findItem(itemStack, entityPlayer.inventory.mainInventory);
            if (slot != -1) {
                entityPlayer.openGui(BVKS.instance, ModGuis.guiBottomlessVoid.getID(), world, slot, 0, 0);
            }*/
        return itemStack;
    }

    private int findItem(ItemStack itemStack, ItemStack[] mainInventory) {
        for (int i = 0; i<mainInventory.length; i++)
            if (itemStack == mainInventory[i])
                return i;
        return -1;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage() & 3;
        return super.getUnlocalizedName() + (meta == 0 ? "" : (meta == 1 ? "_inactive" : "_active"));
    }

    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean currentItem) {
        if (entity instanceof EntityPlayer) {
            if (itemStack.getItemDamage() == 2) {
                ItemStack[] mainInventory = ((EntityPlayer) entity).inventory.mainInventory;
                for (int i = 0; i<mainInventory.length; i++){
                    mainInventory[i] = BottomlessVoidHelper.addItem(itemStack, mainInventory[i]);
                }
            }
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        Boolean bool = BottomlessVoidHelper.hasItems(itemStack);
        ItemStack itemStack1 = BottomlessVoidHelper.getItemStack(itemStack);
        return super.getItemStackDisplayName(itemStack) + (bool ? (": " + itemStack1.getItem().getItemStackDisplayName(itemStack1)) : "");
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack itemStack1 = itemStack.copy();
        ItemStack itemStored = BottomlessVoidHelper.getItemStored(itemStack);
        long count = BottomlessVoidHelper.getCount(itemStack);
        BottomlessVoidHelper.addToCount(itemStack1,
                -((count > itemStored.getMaxStackSize()) ? itemStored.getMaxStackSize() : count));
        itemStack1.setItemDamage(1);
        return itemStack1;
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return BottomlessVoidHelper.hasItems(itemStack);
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack){
        return itemStack.getItemDamage() == 0 || BottomlessVoidHelper.getCount(itemStack) == 0;
    }



    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (itemStack.getItemDamage() == 0) {
            return false;
        }

        Long count = BottomlessVoidHelper.getCount(itemStack);
        if (count == 0) {
            return false;
        }

        ItemStack placingStack = BottomlessVoidHelper.getItemStored(itemStack);
        Block placingBlock = BottomlessVoidHelper.getBlock(itemStack);

        Block block = world.getBlock(x, y, z);

        if (block == Blocks.snow_layer && (world.getBlockMetadata(x, y, z) & 7) < 1)
        {
            side = 1;
        }
        else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush && !block.isReplaceable(world, x, y, z))
        {
            if (side == 0)
            {
                --y;
            }

            if (side == 1)
            {
                ++y;
            }

            if (side == 2)
            {
                --z;
            }

            if (side == 3)
            {
                ++z;
            }

            if (side == 4)
            {
                --x;
            }

            if (side == 5)
            {
                ++x;
            }
        }

        if (!entityPlayer.canPlayerEdit(x, y, z, side, placingStack))
        {
            return false;
        }
        else if (y == 255 && placingBlock.getMaterial().isSolid())
        {
            return false;
        }
        else if (world.canPlaceEntityOnSide(placingBlock, x, y, z, false, side, entityPlayer, placingStack))
        {
            int i1 = placingStack.getItemDamage();
            int j1 = placingBlock.onBlockPlaced(world, x, y, z, side, hitX, hitY, hitZ, i1);

            if (placeBlockAt(placingStack, placingBlock, entityPlayer, world, x, y, z, side, hitX, hitY, hitZ, j1))
            {
                world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), placingBlock.stepSound.func_150496_b(), (placingBlock.stepSound.getVolume() + 1.0F) / 2.0F, placingBlock.stepSound.getPitch() * 0.8F);
                BottomlessVoidHelper.addToCount(itemStack, -1);
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Called to actually place the block, after the location is determined
     * and all permission checks have been made.
     *
     * @param itemStack The item stack that was used to place the block. This can be changed inside the method.
     * @param player The player who is placing the block. Can be null if the block is not being placed by a player.
     * @param side The side the player (or machine) right-clicked on.
     */
    public boolean placeBlockAt(ItemStack itemStack, Block block, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        if (!world.setBlock(x, y, z, block, metadata, 3))
        {
            return false;
        }

        if (world.getBlock(x, y, z) == block)
        {
            block.onBlockPlacedBy(world, x, y, z, player, itemStack);
            block.onPostBlockPlaced(world, x, y, z, metadata);
        }

        return true;
    }
}