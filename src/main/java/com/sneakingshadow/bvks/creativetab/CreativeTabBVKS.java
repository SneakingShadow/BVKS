package com.sneakingshadow.bvks.creativetab;

import com.sneakingshadow.bvks.init.ModBlocks;
import com.sneakingshadow.bvks.init.ModItems;
import com.sneakingshadow.bvks.reference.Name;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class CreativeTabBVKS
{
    public static final CreativeTabs tabItem = new CreativeTabs(Name.CreativeTab.ITEM) {
        @Override
        public Item getTabIconItem() {
            return ModItems.DevilGem;
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllReleventItems(List list)
        {
            ModItems.add(list, this);
        }
    }.setBackgroundImageName(Name.CreativeTab.BACKGROUND);

    public static final CreativeTabs tabBlock = new CreativeTabs(Name.CreativeTab.BLOCK) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.DevilOre);
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
        }

        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllReleventItems(List list)
        {
            ModBlocks.add(list, this);
        }
    }.setBackgroundImageName(Name.CreativeTab.BACKGROUND);


    //---------------------------Adding to list---------------------------------------//


    public static void add(List list, CreativeTabs creativeTab, Item item) {
        item.getSubItems(item, creativeTab, list);
    }

    public static void add(List list, Item item, int metadata) {
        list.add(new ItemStack(item, 1, metadata));
    }

    public static void add(List list, CreativeTabs creativeTab, Block block) {
        block.getSubBlocks(Item.getItemFromBlock(block), creativeTab, list);
    }

    public static void add(List list, Block block, int metadata) {
        list.add(new ItemStack(block, 1, metadata));
    }

    public static void add(List list, NBTTagCompound nbtTagCompound) {
        list.add(ItemStack.loadItemStackFromNBT(nbtTagCompound));
    }

    public static void add(List list, CreativeTabs creativeTab, Object[] objects) {
        int num = 0;
        for(Object obj : objects){
            if (obj instanceof Item) {
                if (num == 0) {
                    add(list, creativeTab, (Item) obj);
                } else {
                    add(list, (Item) obj, num);
                }
            } else if (obj instanceof Block) {
                if (num == 0) {
                    add(list, creativeTab, (Block) obj);
                } else {
                    add(list, (Block) obj, num);
                }
            } else if (obj instanceof NBTTagCompound) {
                add(list, (NBTTagCompound) obj);
            }

            num = obj instanceof Integer ? (Integer) obj : 0;
        }
    }
}
