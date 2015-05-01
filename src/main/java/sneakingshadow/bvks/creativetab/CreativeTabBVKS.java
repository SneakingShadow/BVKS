package sneakingshadow.bvks.creativetab;

import sneakingshadow.bvks.init.ModBlocks;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.reference.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabBVKS
{
    public static final CreativeTabs tabItem = new TabItem();
    public static final CreativeTabs tabBlock = new TabBlock();

    public static class TabItem extends CreativeTabs{
        public TabItem(){
            super(Names.CreativeTabs.Item);
            this.setBackgroundImageName(Names.CreativeTabs.Background);
        }

        @Override
        public Item getTabIconItem() {
            return ModItems.DevilGem;
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
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
    }
}
