package sneakingshadow.bvks.item.base;

import sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import sneakingshadow.bvks.reference.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBVKSArmor extends ItemArmor
{
    private String texture;
    private int armor;
    private static boolean isInvisible = false;

    public ItemBVKSArmor(String textureName, ArmorMaterial material, int armorType)
    {
        super(material, 0, armorType);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        texture = textureName;
        armor = armorType;
    }

    public ItemBVKSArmor(String textureName, ArmorMaterial material, int armorType, int renderIndex)
    {
        super(material, renderIndex, armorType);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.setCreativeTab(CreativeTabBVKS.tabItem);
        texture = textureName;
        armor = armorType;
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
        if(entity.isInvisible() && isInvisible) return Ref.RESOURCE_PREFIX+"textures/armor/invisible_armor.png";
        return Ref.RESOURCE_PREFIX+"textures/armor/" + this.texture + "_" + (this.armor == 2 ? "2" : "1") + ".png";
    }

    public void setInvisible(){
        isInvisible = true;
    }

    public static String description;
    public Object setDescription(String str) {
        description = str;
        return this;
    }
    public static void addDescription(List list){
        if (description != null)
            list.add(description);
    }
}
