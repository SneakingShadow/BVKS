package sneakingshadow.bvks.item.base;

public class ItemBVKSPickaxe extends ItemBVKSTool
{

    public ItemBVKSPickaxe(String unlocalizedName, ToolMaterial toolMaterial) {
        super(unlocalizedName, toolMaterial, 2.0F);
        this.setPickaxe(toolMaterial.getHarvestLevel());
    }

}