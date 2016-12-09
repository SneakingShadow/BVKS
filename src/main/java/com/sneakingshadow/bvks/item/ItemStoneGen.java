package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.item.ItemBVKS;
import com.sneakingshadow.bvks.reference.Name;
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

import java.util.List;

public class ItemStoneGen extends ItemBVKS {
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

    /*
    
-    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int xPos, int yPos, int zPos, int side, float hitX, float hitY, float hitZ)
-    {
-        Block block = world.getBlock(xPos, yPos, zPos);
-        ItemStack itemBlock = new ItemStack( this.blocks[itemStack.getItemDamage()] );
-
-        if (block == Blocks.snow_layer && (world.getBlockMetadata(xPos, yPos, zPos) & 7) < 1)
-        {
-            side = 1;
-        }
-        else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush && !block.isReplaceable(world, xPos, yPos, zPos))
-        {
-            if (side == 0)
-            {
-                --yPos;
-            }
-
-            if (side == 1)
-            {
-                ++yPos;
-            }
-
-            if (side == 2)
-            {
-                --zPos;
-            }
-
-            if (side == 3)
-            {
-                ++zPos;
-            }
-
-            if (side == 4)
-            {
-                --xPos;
-            }
 
-            if (side == 5)
-            {
-                ++xPos;
+        if(!world.restoringBlockSnapshots && entityPlayer.isSneaking()){
+            itemStack.setItemDamage(itemStack.getItemDamage()+1);
+            if(itemStack.getItemDamage() == this.blocks.length) {
+                itemStack.setItemDamage(0);
             }
         }
 
-        if (!entityPlayer.canPlayerEdit(xPos, yPos, zPos, side, itemBlock))
-        {
-            return false;
-        }
-        else if (yPos == 255 && this.blocks[itemStack.getItemDamage()].getMaterial().isSolid())
-        {
-            return false;
-        }
-        else if (world.canPlaceEntityOnSide(this.blocks[itemStack.getItemDamage()], xPos, yPos, zPos, false, side, entityPlayer, itemBlock))
-        {
-            if (placeBlockAt(itemStack, itemBlock, entityPlayer, world, xPos, yPos, zPos))
-            {
-                world.playSoundEffect((double)((float)xPos + 0.5F), (double)((float)yPos + 0.5F), (double)((float)zPos + 0.5F), blocks[itemStack.getItemDamage()].stepSound.func_150496_b(), (blocks[itemStack.getItemDamage()].stepSound.getVolume() + 1.0F) / 2.0F, blocks[itemStack.getItemDamage()].stepSound.getPitch() * 0.8F);
-            }
-
-            return true;
-        }
-        else
-        {
-            return false;
-        }
+        return itemStack;
     }

    */

    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int xPos, int yPos, int zPos, int side, float hitX, float hitY, float hitZ)
    {
        /*
        if (!world.setBlock(x, y, z, this.blocks[itemStack.getItemDamage()], 0, 3))
        {
                return false;
        }
        if (world.getBlock(x, y, z) == this.blocks[itemStack.getItemDamage()])
        {
            this.blocks[itemStack.getItemDamage()].onBlockPlacedBy(world, x, y, z, player, itemBlock);
            this.blocks[itemStack.getItemDamage()].onPostBlockPlaced(world, x, y, z, 0);
        }
        return true;
        */

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
