package sneakingshadow.bvks.item.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.util.DescHelper;

import java.util.List;

public class ItemBVKSArmor extends ItemArmor
{
    private String texture;
    private int armor;

    public ItemBVKSArmor(String unlocalizedName, String textureName, ArmorMaterial material, int armorType)
    {
        this(unlocalizedName, textureName, material, armorType, 0);
    }

    public ItemBVKSArmor(String unlocalizedName, String textureName, ArmorMaterial material, int armorType, int renderIndex)
    {
        super(material, renderIndex, armorType);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        texture = textureName;
        armor = armorType;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if ( !"".equals( this.getDescription() ) )
            list.add( this.getDescription() );
    }

    public String getDescription(String string) {
        String unloc = getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + string;
        String desc = DescHelper.getDescription( unloc );
        return desc.equals(unloc) ? unloc : desc;
    }
    public String getDescription() {
        return getDescription("");
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Ref.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Ref.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Ref.RESOURCE_PREFIX+"textures/armor/" + this.texture + "_" + (this.armor == 2 ? "2" : "1") + ".png";
    }
}
