package com.sneakingshadow.bvks.item.item;

public class ItemBVKSShovel extends ItemBVKSTool
{

    public ItemBVKSShovel(String unlocalizedName, ToolMaterial toolMaterial) {
        super(unlocalizedName, toolMaterial, 1.0F);
        this.setShovel(toolMaterial.getHarvestLevel());
    }

}