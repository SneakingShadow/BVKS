package sneakingshadow.bvks.item.tool.hammer;

import net.minecraft.init.Items;
import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemStoneHammer extends ItemBVKSHammer
{
    public ItemStoneHammer()
    {
        super(ItemToolMaterial.STONE_HAMMER, 2,2,2, Items.stone_shovel);
        this.setUnlocalizedName(Names.Items.STONE_HAMMER);
    }
}