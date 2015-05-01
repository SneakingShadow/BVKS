package sneakingshadow.bvks.item.tool.hammer;

import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemObsidianHammer extends ItemBVKSHammer
{
    public ItemObsidianHammer()
    {
        super(ItemToolMaterial.ObsidianHammer, 4,4,4, ModItems.ObsidianShovel);
        this.setUnlocalizedName(Names.Items.ObsidianHammer);
    }
}