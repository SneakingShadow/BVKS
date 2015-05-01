package sneakingshadow.bvks.item.tool.devil;

import sneakingshadow.bvks.item.base.ItemBVKSPickaxe;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilPickaxe extends ItemBVKSPickaxe
{
    public ItemDevilPickaxe()
    {
        super(ItemToolMaterial.DevilPickaxe);
        this.setUnlocalizedName(Names.Items.DevilPickaxe);
    }

    @Override
    public boolean isDamageable() { return false; }
}