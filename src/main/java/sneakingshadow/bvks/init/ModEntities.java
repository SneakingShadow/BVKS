package sneakingshadow.bvks.init;

import cpw.mods.fml.common.registry.EntityRegistry;
import sneakingshadow.bvks.BVKS;
import sneakingshadow.bvks.entity.EntityAwesomeCow;
import sneakingshadow.bvks.entity.EntityMiniSteve;

public class ModEntities {

    public static void init(){
        int id = 0;

        EntityRegistry.registerModEntity(EntityAwesomeCow.class, "AwesomeCow", id++, BVKS.instance, 10, 10, true);
        EntityRegistry.registerModEntity(EntityMiniSteve.class, "MiniSteve", id++, BVKS.instance, 10, 10, true);
    }

}
