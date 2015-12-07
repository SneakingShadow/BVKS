package sneakingshadow.bvks.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;

import java.util.List;

public class ItemArmorDevilLeggings extends ItemBVKSArmor
{
    public ItemArmorDevilLeggings()
    {
        super(Names.ArmorTextures.DEVIL, Armor.Material.DEVIL, Armor.Type.LEGGINGS);
        this.setUnlocalizedName(Names.Items.DEVIL_LEGGINGS);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 0, 3, true));
    }

    @SideOnly(Side.CLIENT)
    public static void addInformation(List list){
        list.add("Saitama's leggings");
    }
}