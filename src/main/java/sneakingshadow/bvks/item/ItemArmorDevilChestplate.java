package sneakingshadow.bvks.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.util.DescHelper;

import java.util.List;

public class ItemArmorDevilChestplate extends ItemBVKSArmor
{
    public ItemArmorDevilChestplate()
    {
        super(Name.Armor.DEVIL, sneakingshadow.bvks.reference.Armor.Material.DEVIL, sneakingshadow.bvks.reference.Armor.Type.CHESTPLATE);
        this.setUnlocalizedName(Name.Item.DEVIL_CHESTPLATE);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.fallDistance = 0F;
        player.capabilities.allowFlying = true;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add( DescHelper.getDescription( Name.Item.DEVIL_CHESTPLATE ) );
    }
}