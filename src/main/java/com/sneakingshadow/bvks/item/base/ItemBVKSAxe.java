package com.sneakingshadow.bvks.item.base;

public class ItemBVKSAxe extends ItemBVKSTool
{

    public ItemBVKSAxe(String unlocalizedName, ToolMaterial toolMaterial) {
        super(unlocalizedName, toolMaterial, 3.0F);
        this.setAxe(toolMaterial.getHarvestLevel());
    }

}
