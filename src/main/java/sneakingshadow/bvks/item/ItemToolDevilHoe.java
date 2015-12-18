package sneakingshadow.bvks.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import sneakingshadow.bvks.item.base.ItemBVKSHoe;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.Tool;

import java.util.List;

public class ItemToolDevilHoe extends ItemBVKSHoe
{
    public ItemToolDevilHoe() {
        super(Tool.ItemToolMaterial.DEVIL_HOE);
        this.setUnlocalizedName(Name.Item.DEVIL_HOE);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4)
    {
        list.add("I think death dropped something...");
        list.add("Also functions like a hoe");
        list.add("Gotta love them hoes");
    }

    @Override
    public boolean isDamageable() { return false; }
}
