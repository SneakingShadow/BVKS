package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.world.gen.WorldGenDevilOre;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModWorldGen {

    public static void init(){
        GameRegistry.registerWorldGenerator(new WorldGenDevilOre(), 1);
    }

}
