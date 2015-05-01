package sneakingshadow.bvks.item.tool.devil;

import sneakingshadow.bvks.item.base.ItemBVKSShovel;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilShovel extends ItemBVKSShovel
{
    public ItemDevilShovel()
    {
        super(ItemToolMaterial.DevilShovel);
        this.setUnlocalizedName(Names.Items.DevilShovel);
    }

    @Override
    public boolean isDamageable() { return false; }
}