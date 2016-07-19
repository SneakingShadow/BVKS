package sneakingshadow.bvks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import sneakingshadow.bvks.world.gen.WorldGenDevilOre;

public class ModWorldGen {

    public static void init(){
        GameRegistry.registerWorldGenerator(new WorldGenDevilOre(), 1);
    }

}
