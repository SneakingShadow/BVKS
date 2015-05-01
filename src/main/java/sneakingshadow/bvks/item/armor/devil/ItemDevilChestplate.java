package sneakingshadow.bvks.item.armor.devil;

import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilChestplate extends ItemBVKSArmor
{
    public ItemDevilChestplate()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.CHESTPLATE);
        this.setUnlocalizedName(Names.Items.DevilChestplate);
        this.setInvisible();
    }
}