package sneakingshadow.bvks.item.tool.hammer;

import net.minecraft.init.Items;
import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemIronHammer extends ItemBVKSHammer
{
    public ItemIronHammer()
    {
        super(ItemToolMaterial.IRON_HAMMER, 3,3,3, Items.iron_shovel);
        this.setUnlocalizedName(Names.Items.IRON_HAMMER);
    }
}