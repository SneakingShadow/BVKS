package sneakingshadow.bvks.item;

import sneakingshadow.bvks.item.base.ItemBVKSPickaxe;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemToolDevilPickaxe extends ItemBVKSPickaxe
{
    public ItemToolDevilPickaxe()
    {
        super(ItemToolMaterial.DEVIL_PICKAXE);
        this.setUnlocalizedName(Names.Items.DEVIL_PICKAXE);
    }

    @Override
    public boolean isDamageable() { return false; }
}