package sneakingshadow.bvks.item.tool.hammer;

import net.minecraft.init.Items;
import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemWoodHammer extends ItemBVKSHammer
{
    public ItemWoodHammer()
    {
        super(ItemToolMaterial.WoodHammer, 1,1,1, Items.wooden_shovel);
        this.setUnlocalizedName(Names.Items.WoodHammer);
    }
}