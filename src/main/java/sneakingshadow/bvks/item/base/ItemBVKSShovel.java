package sneakingshadow.bvks.item.base;

public class ItemBVKSShovel extends ItemBVKSTool
{

    public ItemBVKSShovel(ToolMaterial toolMaterial) {
        super(toolMaterial, 1.0F);
        this.setShovel(toolMaterial.getHarvestLevel());
    }

}