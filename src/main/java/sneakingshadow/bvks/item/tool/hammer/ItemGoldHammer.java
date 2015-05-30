package sneakingshadow.bvks.item.tool.hammer;

import net.minecraft.init.Items;
import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemGoldHammer extends ItemBVKSHammer
{
    public ItemGoldHammer()
    {
        super(ItemToolMaterial.GOLD_HAMMER, 3,3,3, Items.golden_shovel);
        this.setUnlocalizedName(Names.Items.GOLD_HAMMER);
    }
}