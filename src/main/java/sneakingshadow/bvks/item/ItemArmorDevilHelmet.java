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

public class ItemArmorDevilHelmet extends ItemBVKSArmor
{
    public ItemArmorDevilHelmet()
    {
        super(Names.ArmorTextures.DEVIL, Armor.Material.DEVIL, Armor.Type.HELMET);
        this.setUnlocalizedName(Names.Items.DEVIL_HELMET);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.setAir(300);
        player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 11, 12, true));
    }

    @SideOnly(Side.CLIENT)
    public static void addInformation(List list){
        list.add("No reason to have");
        list.add("a dark view at life");
    }
}