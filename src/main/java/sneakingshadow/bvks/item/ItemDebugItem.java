package sneakingshadow.bvks.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.util.LogHelper;

import java.util.List;

public class ItemDebugItem extends ItemBVKS {

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add("Use at own risk!");
    }

    public ItemDebugItem() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.DEBUG_ITEM);
        this.setFull3D();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        if(!world.isRemote && !world.restoringBlockSnapshots) {
            LogHelper.all("");
        }

        return itemStack;
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int xPos, int yPos, int zPos, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(xPos, yPos, zPos);
        ItemStack itemBlock = new ItemStack(Blocks.cobblestone);

        if(entityPlayer.isSneaking())
            LogHelper.all("onItemUse");
            //TODO
        if (block == Blocks.snow_layer && (world.getBlockMetadata(xPos, yPos, zPos) & 7) < 1)
        {
            side = 1;
        }
        else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush && !block.isReplaceable(world, xPos, yPos, zPos))
        {
            if (side == 0)
            {
                --yPos;
            }

            if (side == 1)
            {
                ++yPos;
            }

            if (side == 2)
            {
                --zPos;
            }

            if (side == 3)
            {
                ++zPos;
            }

            if (side == 4)
            {
                --xPos;
            }

            if (side == 5)
            {
                ++xPos;
            }
        }

        if (itemBlock.stackSize == 0)
        {
            return false;
        }
        else if (!entityPlayer.canPlayerEdit(xPos, yPos, zPos, side, itemBlock))
        {
            return false;
        }
        else if (yPos == 255 && Blocks.cobblestone.getMaterial().isSolid())
        {
            return false;
        }
        else if (world.canPlaceEntityOnSide(Blocks.cobblestone, xPos, yPos, zPos, false, side, entityPlayer, itemBlock))
        {
            int i1 = this.getMetadata(itemBlock.getItemDamage());
            int j1 = Blocks.cobblestone.onBlockPlaced(world, xPos, yPos, zPos, side, hitX, hitY, hitZ, i1);

            if (placeBlockAt(itemBlock, entityPlayer, world, xPos, yPos, zPos, side, hitX, hitY, hitZ, j1))
            {
                world.playSoundEffect((double)((float)xPos + 0.5F), (double)((float)yPos + 0.5F), (double)((float)zPos + 0.5F), Blocks.cobblestone.stepSound.func_150496_b(), (Blocks.cobblestone.stepSound.getVolume() + 1.0F) / 2.0F, Blocks.cobblestone.stepSound.getPitch() * 0.8F);
                --itemBlock.stackSize;
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
     * @param stack The item stack that was used to place the block. This can be changed inside the method.
     * @param player The player who is placing the block. Can be null if the block is not being placed by a player.
     * @param side The side the player (or machine) right-clicked on.
     */
    private boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {

        if (!world.setBlock(x, y, z, Blocks.cobblestone, metadata, 3))
        {
            return false;
        }

        if (world.getBlock(x, y, z) == Blocks.cobblestone)
        {
            Blocks.cobblestone.onBlockPlacedBy(world, x, y, z, player, stack);
            Blocks.cobblestone.onPostBlockPlaced(world, x, y, z, metadata);
        }

        return true;
    }
}
