package sneakingshadow.bvks.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.util.LogHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class ItemDebugItem extends ItemBVKS {

    private static Block placeBlock = Blocks.cobblestone;

    public ItemDebugItem() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Name.Item.DEBUG_ITEM);
        this.setFull3D();
        this.setMaxDamage(10);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        if(!world.isRemote && !world.restoringBlockSnapshots) {
        }
        for (int i = 0; i < 9; i++) {
            LogHelper.info("Slot "+i+": " +
                    (entityPlayer.inventoryContainer.getSlot(i).getHasStack() ?
                            entityPlayer.inventoryContainer.getSlot(8).getStack().getTagCompound()
                            : "is empty"));
        }
        return itemStack;
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        Object object = Blocks.cobblestone;
        Block block = world.getBlock(x,y,z);
        int metadata = world.getBlockMetadata(x,y,z);

        if ((object == null)) {
            LogHelper.info("Null: " + (block == Blocks.air));
        }else if (object instanceof Item) {
            LogHelper.info("Object instanceof Item: " + (Item.getItemFromBlock(block) == object));
        }else if (object instanceof ItemStack) {
            ItemStack objectStack = (ItemStack)object;
            LogHelper.info("Object instanceof ItemStack: " + (objectStack.getItem() == Item.getItemFromBlock(block) && objectStack.getItemDamage() == metadata));
        }else if (object instanceof Block) {
            LogHelper.info("Object instanceof Block: " + (object == block));
        }else if (object instanceof ArrayList) {

        }

        //if (object == null || object instanceof Block && (  ))


        /*
        Block block = world.getBlock(x, y, z);
        placeBlock = block;
        ItemStack itemBlock = new ItemStack(placeBlock);
        int meta = world.getBlockMetadata(x, y, z);
        itemBlock.setItemDamage(meta);
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        if(world.getTileEntity(x, y, z) != null){
            world.getTileEntity(x, y, z).writeToNBT(nbtTagCompound);
        }else{
            nbtTagCompound = null;
        }

        if(entityPlayer.isSneaking()) {
            LogHelper.info("onItemUse");
        }

        if (block == Blocks.snow_layer && (meta & 7) < 1)
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

        if (itemBlock.stackSize == 0)
        {
            return false;
        }
        else if (!entityPlayer.canPlayerEdit(x, y, z, side, itemBlock))
        {
            return false;
        }
        else if (y == 255 && placeBlock.getMaterial().isSolid())
        {
            return false;
        }
        else if (world.canPlaceEntityOnSide(placeBlock, x, y, z, false, side, entityPlayer, itemBlock))
        {
            int metaB = placeBlock.onBlockPlaced(world, x, y, z, side, hitX, hitY, hitZ, meta);

            if (placeBlockAt(itemBlock, entityPlayer, world, x, y, z, side, hitX, hitY, hitZ, metaB, nbtTagCompound))
            {
                world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), placeBlock.stepSound.func_150496_b(), (placeBlock.stepSound.getVolume() + 1.0F) / 2.0F, placeBlock.stepSound.getPitch() * 0.8F);
                --itemBlock.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
        */ return false;
    }

    /**
     * Called to actually place the block, after the location is determined
     * and all permission checks have been made.
     *
     * @param stack The item stack that was used to place the block. This can be changed inside the method.
     * @param player The player who is placing the block. Can be null if the block is not being placed by a player.
     * @param side The side the player (or machine) right-clicked on.
     */
    private boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata, @Nullable NBTTagCompound nbtTagCompound)
    {

        if (!world.setBlock(x, y, z, placeBlock, metadata, 3))
        {
            return false;
        }

        if (world.getBlock(x, y, z) == placeBlock)
        {
            placeBlock.onBlockPlacedBy(world, x, y, z, player, stack);
            placeBlock.onPostBlockPlaced(world, x, y, z, metadata);
            LogHelper.info(world.getTileEntity(x,y,z));
            LogHelper.info(world.getTileEntity(x,y,z) != null);
            if(world.getTileEntity(x,y,z) != null && nbtTagCompound != null){
                NBTTagCompound nbt1 = new NBTTagCompound();
                TileEntity tileEntity = world.getTileEntity(x, y, z);
                tileEntity.writeToNBT(nbt1);
                nbtTagCompound.setString("id", nbt1.getString("id"));
                nbtTagCompound.setInteger("x", nbt1.getInteger("x"));
                nbtTagCompound.setInteger("y", nbt1.getInteger("y"));
                nbtTagCompound.setInteger("z", nbt1.getInteger("z"));
                tileEntity.readFromNBT(nbtTagCompound);
            }
        }

        return true;
    }
}
