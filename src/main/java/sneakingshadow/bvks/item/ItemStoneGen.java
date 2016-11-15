package sneakingshadow.bvks.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Name;

import java.util.List;

public class ItemStoneGen extends ItemBVKS{
    private Block[] blocks = {Blocks.cobblestone, Blocks.stone, Blocks.stonebrick};

    public ItemStoneGen(){
        super(Name.Item.STONE_GEN);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int metadata)
    {
        return blocks[metadata < blocks.length ? metadata : 0].getBlockTextureFromSide(1);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        return super.getItemStackDisplayName(itemStack) + ": " + this.blocks[itemStack.getItemDamage()].getLocalizedName();
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.UNDERLINE + "Shift+Right Click");
        list.add("to change block.");
        list.add("Placeable blocks:");
        for(int j=0;j<this.blocks.length;j++){
            list.add(this.blocks[j].getLocalizedName());
        }
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {

        if(!world.restoringBlockSnapshots && entityPlayer.isSneaking()){
            itemStack.setItemDamage(itemStack.getItemDamage()+1);
            if(itemStack.getItemDamage() == this.blocks.length) {
                itemStack.setItemDamage(0);
            }
        }

        return itemStack;
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int xPos, int yPos, int zPos, int side, float hitX, float hitY, float hitZ)
    {
        Item block = Item.getItemFromBlock(
                blocks[
                        itemStack.getItemDamage() < blocks.length ?
                                itemStack.getItemDamage() :
                                0
                        ]
        );
        return !entityPlayer.isSneaking() && block.onItemUse(
                new ItemStack(block), entityPlayer, world, xPos, yPos, zPos, side, hitX, hitY, hitZ
        );
    }
}
