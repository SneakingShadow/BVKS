package sneakingshadow.bvks.item.tool.devil;

import sneakingshadow.bvks.item.base.ItemBVKSShovel;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilShovel extends ItemBVKSShovel
{
    public ItemDevilShovel()
    {
        super(ItemToolMaterial.DEVIL_SHOVEL);
        this.setUnlocalizedName(Names.Items.DEVIL_SHOVEL);
    }

    @Override
    public boolean isDamageable() { return false; }
}