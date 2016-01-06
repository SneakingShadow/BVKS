package sneakingshadow.bvks.item.base;

public class ItemBVKSPickaxe extends ItemBVKSTool
{

    public ItemBVKSPickaxe(ToolMaterial toolMaterial) {
        super(toolMaterial, 2.0F);
        this.setPickaxe(toolMaterial.getHarvestLevel());
    }

}