package sneakingshadow.bvks.item.tool.devil;

import sneakingshadow.bvks.item.base.ItemBVKSPickaxe;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilPickaxe extends ItemBVKSPickaxe
{
    public ItemDevilPickaxe()
    {
        super(ItemToolMaterial.DEVIL_PICKAXE);
        this.setUnlocalizedName(Names.Items.DEVIL_PICKAXE);
    }

    @Override
    public boolean isDamageable() { return false; }
}