package sneakingshadow.bvks.item.tool.hammer;

import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;
import net.minecraft.init.Items;

public class ItemIronHammer extends ItemBVKSHammer
{
    public ItemIronHammer()
    {
        super(ItemToolMaterial.IronHammer, 3,3,3, Items.iron_shovel);
        this.setUnlocalizedName(Names.Items.IronHammer);
    }
}