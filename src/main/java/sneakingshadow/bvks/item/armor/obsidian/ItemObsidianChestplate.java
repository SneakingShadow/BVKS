package sneakingshadow.bvks.item.armor.obsidian;

import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;

public class ItemObsidianChestplate extends ItemBVKSArmor
{
    public ItemObsidianChestplate()
    {
        super(Names.ArmorTextures.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.CHESTPLATE);
        this.setUnlocalizedName(Names.Items.OBSIDIAN_CHESTPLATE);
    }
}