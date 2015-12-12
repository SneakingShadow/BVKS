package sneakingshadow.bvks.item;

import sneakingshadow.bvks.item.base.ItemBVKSPickaxe;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.Tool;

public class ItemToolDevilPickaxe extends ItemBVKSPickaxe
{
    public ItemToolDevilPickaxe()
    {
        super(Tool.ItemToolMaterial.DEVIL_PICKAXE);
        this.setUnlocalizedName(Name.Item.DEVIL_PICKAXE);
    }

    @Override
    public boolean isDamageable() { return false; }
}