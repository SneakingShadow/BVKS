package sneakingshadow.bvks.init;

import sneakingshadow.bvks.world.WorldGenDevilOre;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {

    public static void init(){
        GameRegistry.registerWorldGenerator(new WorldGenDevilOre(), 1);
    }

}
