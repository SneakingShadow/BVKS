package sneakingshadow.bvks.item;

import sneakingshadow.bvks.item.base.ItemBVKSSword;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemToolDevilSword extends ItemBVKSSword
{
    public ItemToolDevilSword()
    {
        super(ItemToolMaterial.DEVIL_SWORD);
        this.setUnlocalizedName(Names.Items.DEVIL_SWORD);
    }

    @Override
    public boolean isDamageable() { return false; }
}