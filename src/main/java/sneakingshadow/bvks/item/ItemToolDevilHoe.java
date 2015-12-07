package sneakingshadow.bvks.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import sneakingshadow.bvks.item.base.ItemBVKSHoe;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

import java.util.List;

public class ItemToolDevilHoe extends ItemBVKSHoe
{
    public ItemToolDevilHoe() {
        super(ItemToolMaterial.DEVIL_HOE);
        this.setUnlocalizedName(Names.Items.DEVIL_HOE);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Lets you be the grim reaper!");
        list.add("Also functions like a hoe");
        list.add("Gotta love them hoes");
    }

    @Override
    public boolean isDamageable() { return false; }
}
