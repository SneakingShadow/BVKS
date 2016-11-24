package com.sneakingshadow.bvks.multiblock.structureblock;

import com.sneakingshadow.bvks.util.OreDictionaryHelper;
import net.minecraft.world.World;

public class SBlockOreDictionary extends StructureBlock {

    private String ore_name;

    public SBlockOreDictionary (String string) {
        ore_name = string;
    }

    public boolean blockIsValid(World world, int x, int y, int z){
        return OreDictionaryHelper.isValidItem(ore_name,world,x,y,z);
    }

}
