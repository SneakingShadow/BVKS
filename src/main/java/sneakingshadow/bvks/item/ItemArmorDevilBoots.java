package sneakingshadow.bvks.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Name;

import java.util.List;

public class ItemArmorDevilBoots extends ItemBVKSArmor
{
    public ItemArmorDevilBoots()
    {
        super(Name.Armor.DEVIL, sneakingshadow.bvks.reference.Armor.Material.DEVIL, sneakingshadow.bvks.reference.Armor.Type.BOOTS);
        this.setUnlocalizedName(Name.Item.DEVIL_BOOTS);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.fallDistance = 0F;
        player.addPotionEffect(new PotionEffect(Potion.jump.getId(),0,3,true));
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add("Also called:");
        list.add("The opposite-of-hello-kitty armor");
    }
}
