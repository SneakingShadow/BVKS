package com.sneakingshadow.bvks.creativetab;

import com.sneakingshadow.bvks.init.ModBlocks;
import com.sneakingshadow.bvks.init.ModItems;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabBVKS
{
    public static final CreativeTabs tabItem = new CreativeTabs(Names.creativeTabs.Item)
    {
        @Override
        public Item getTabIconItem() {
            this.setBackgroundImageName("item_search.png");
            return ModItems.DevilGem;
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
        }
    };

    public static final CreativeTabs tabBlock = new CreativeTabs(Names.creativeTabs.Block)
    {
        @Override
        public Item getTabIconItem() {
            this.setBackgroundImageName("item_search.png");
            return Item.getItemFromBlock(ModBlocks.DevilOre);
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
        }
    };
}
