package sneakingshadow.bvks.item.base;

public class ItemBVKSAxe extends ItemBVKSTool
{

    public ItemBVKSAxe(ToolMaterial toolMaterial) {
        super(toolMaterial, 3.0F);
        this.setAxe(toolMaterial.getHarvestLevel());
    }

}
