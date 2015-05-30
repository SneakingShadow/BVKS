package sneakingshadow.bvks.item.tool.hammer;

import net.minecraft.init.Items;
import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemDiamondHammer extends ItemBVKSHammer
{
    public ItemDiamondHammer()
    {
        super(ItemToolMaterial.DIAMOND_HAMMER, 5,5,5, Items.diamond_shovel);
        this.setUnlocalizedName(Names.Items.DIAMOND_HAMMER);
    }
}