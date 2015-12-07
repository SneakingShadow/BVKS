package sneakingshadow.bvks.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import sneakingshadow.bvks.init.ModBlocks;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.reference.Names;

import java.util.List;

public class CreativeTabBVKS
{
    public static final CreativeTabs tabItem = new CreativeTabs(Names.CreativeTabs.ITEM) {
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
            ModItems.add(list);
        }
    }.setBackgroundImageName(Names.CreativeTabs.BACKGROUND);
    public static final CreativeTabs tabBlock = new CreativeTabs(Names.CreativeTabs.BLOCK) {
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
            ModBlocks.add(list);
        }
    }.setBackgroundImageName(Names.CreativeTabs.BACKGROUND);

    /**
     *
     *
     *
     */

    public static void add(List list, Item item) {
        list.add(new ItemStack(item, 1, 0));
    }

    public static void add(List list, Item item, int metadata) {
        list.add(new ItemStack(item, 1, metadata));
    }

    public static void add(List list, Block block) {
        list.add(new ItemStack(block, 1, 0));
    }

    public static void add(List list, Block block, int metadata) {
        list.add(new ItemStack(block, 1, metadata));
    }

    public static void add(List list, NBTTagCompound nbtTagCompound) {
        list.add(ItemStack.loadItemStackFromNBT(nbtTagCompound));
    }

    public static void add(List list, Object[] objects) {
        int temp = 0;
        for(Object obj : objects){
            if (obj instanceof Item)

                if (temp == 0)
                    add(list, (Item)obj);
                else
                    add(list, (Item)obj, temp);

            else if (obj instanceof Block)

                if (temp == 0)
                    add(list, (Block)obj);
                else
                    add(list, (Block)obj, temp);

            else if (obj instanceof NBTTagCompound)

                add(list, (NBTTagCompound)obj);

            else if (obj instanceof Integer)
                temp = (Integer)obj;
            else
                temp = 0;
        }
    }
}
