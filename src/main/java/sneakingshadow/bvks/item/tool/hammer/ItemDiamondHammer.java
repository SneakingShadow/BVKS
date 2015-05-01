package sneakingshadow.bvks.item.tool.hammer;

import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;
import net.minecraft.init.Items;

public class ItemDiamondHammer extends ItemBVKSHammer
{
    public ItemDiamondHammer()
    {
        super(ItemToolMaterial.DiamondHammer, 5,5,5, Items.diamond_shovel);
        this.setUnlocalizedName(Names.Items.DiamondHammer);
    }
}