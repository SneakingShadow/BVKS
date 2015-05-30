package sneakingshadow.bvks.item.armor.obsidian;

import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;

public class ItemObsidianBoots extends ItemBVKSArmor
{
    public ItemObsidianBoots()
    {
        super(Names.ArmorTextures.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.BOOTS);
        this.setUnlocalizedName(Names.Items.OBSIDIAN_BOOTS);
    }
}