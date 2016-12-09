package com.sneakingshadow.bvks.item.item;

public class ItemBVKSPickaxe extends ItemBVKSTool
{

    public ItemBVKSPickaxe(String unlocalizedName, ToolMaterial toolMaterial) {
        super(unlocalizedName, toolMaterial, 2.0F);
        this.setPickaxe(toolMaterial.getHarvestLevel());
    }

}