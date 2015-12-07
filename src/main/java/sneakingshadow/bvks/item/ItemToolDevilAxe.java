package sneakingshadow.bvks.item;

import sneakingshadow.bvks.item.base.ItemBVKSAxe;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemToolDevilAxe extends ItemBVKSAxe
{
    public ItemToolDevilAxe()
    {
        super(ItemToolMaterial.DEVIL_AXE);
        this.setUnlocalizedName(Names.Items.DEVIL_AXE);
    }

    @Override
    public boolean isDamageable() { return false; }
}