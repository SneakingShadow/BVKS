package sneakingshadow.bvks.item;

import sneakingshadow.bvks.item.base.ItemBVKSShovel;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemToolDevilShovel extends ItemBVKSShovel
{
    public ItemToolDevilShovel()
    {
        super(ItemToolMaterial.DEVIL_SHOVEL);
        this.setUnlocalizedName(Names.Items.DEVIL_SHOVEL);
    }

    @Override
    public boolean isDamageable() { return false; }
}