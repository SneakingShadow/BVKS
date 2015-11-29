package sneakingshadow.bvks.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Names;

import java.util.List;

public class ItemStoneGen extends ItemBVKS{
    private static Block[] blocks = {Blocks.cobblestone, Blocks.stone, Blocks.stonebrick};

    public ItemStoneGen(){
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.STONE_GEN);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        return super.getItemStackDisplayName(itemStack) + ": " + blocks[itemStack.getItemDamage()].getLocalizedName();
    }

    @Override
    public IIcon getIconIndex(ItemStack itemStack){
        return blocks[itemStack.getItemDamage()].getIcon(0,0);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Shift+Right Click");
        list.add("to change block.");
        list.add("Placeable blocks:");
        for(int j=0;j<blocks.length;j++){
            list.add(blocks[j].getLocalizedName());
        }
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if(!world.isRemote && !world.restoringBlockSnapshots && entityPlayer.isSneaking()){
            if(itemStack.getItemDamage()==blocks.length-1){
                itemStack.setItemDamage(0);
            }else{
                itemStack.setItemDamage(itemStack.getItemDamage()+1);
            }
        }
        return itemStack;
    }
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int xPos, int yPos, int zPos, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(xPos, yPos, zPos);
        ItemStack itemBlock = new ItemStack( blocks[itemStack.getItemDamage()] );

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

        if (!entityPlayer.canPlayerEdit(xPos, yPos, zPos, side, itemBlock))
        {
            return false;
        }
        else if (yPos == 255 && blocks[itemStack.getItemDamage()].getMaterial().isSolid())
        {
            return false;
        }
        else if (world.canPlaceEntityOnSide(blocks[itemStack.getItemDamage()], xPos, yPos, zPos, false, side, entityPlayer, itemBlock))
        {
            if (placeBlockAt(itemStack, itemBlock, entityPlayer, world, xPos, yPos, zPos))
            {
                world.playSoundEffect((double)((float)xPos + 0.5F), (double)((float)yPos + 0.5F), (double)((float)zPos + 0.5F), blocks[itemStack.getItemDamage()].stepSound.func_150496_b(), (blocks[itemStack.getItemDamage()].stepSound.getVolume() + 1.0F) / 2.0F, blocks[itemStack.getItemDamage()].stepSound.getPitch() * 0.8F);
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
     */
    private boolean placeBlockAt(ItemStack itemStack, ItemStack itemBlock, EntityPlayer player, World world, int x, int y, int z)
    {

        if (!world.setBlock(x, y, z, blocks[itemStack.getItemDamage()], 0, 3))
        {
            return false;
        }
        if (world.getBlock(x, y, z) == blocks[itemStack.getItemDamage()])
        {
            blocks[itemStack.getItemDamage()].onBlockPlacedBy(world, x, y, z, player, itemBlock);
            blocks[itemStack.getItemDamage()].onPostBlockPlaced(world, x, y, z, 0);
        }
        return true;
    }
}
