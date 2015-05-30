package sneakingshadow.bvks.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sneakingshadow.bvks.init.ModBlocks;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.reference.Names;

import java.util.List;

public class CreativeTabBVKS
{
    private static List listItem;
    private static List listBlock;

    public static final CreativeTabs tabItem = new TabItem();
    public static final CreativeTabs tabBlock = new TabBlock();

    public static class TabItem extends CreativeTabs{
        public TabItem(){
            super(Names.CreativeTabs.Item);
            this.setBackgroundImageName(Names.CreativeTabs.Background);
        }

        @Override
        public Item getTabIconItem() { return ModItems.DevilGem; }

        @Override
        public boolean hasSearchBar() { return true; }

        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllReleventItems(List list)
        {
            listItem = list;
            ModItems.add();
        }
    }

    public static class TabBlock extends CreativeTabs{
        public TabBlock(){
            super(Names.CreativeTabs.Block);
            this.setBackgroundImageName(Names.CreativeTabs.Background);
        }

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
            listBlock = list;
            ModBlocks.add();
        }
    }

    public static void add(Item item) {
        item.getSubItems(item, tabItem, listItem);
    }

    public static void add(Block block) {
        block.getSubBlocks(new ItemStack(block).getItem(), tabBlock, listBlock);
    }

    public static void add(Object[] objects) {
        for(int i=0; i<objects.length;i++){
            if(objects[i] instanceof Item)
                add((Item)objects[i]);
            if(objects[i] instanceof Block)
                add((Block)objects[i]);
        }
    }

    public static void add(Item[] items) {
        for(int i=0; i<items.length;i++){
            add(items[i]);
        }
    }

    public static void add(Block[] blocks) {
        for(int i=0; i<blocks.length;i++){
            add(blocks[i]);
        }
    }
}
