package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.BVKS;
import com.sneakingshadow.bvks.entity.EntityAwesomeCow;
import com.sneakingshadow.bvks.entity.EntityMiniSteve;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {

    public static void init(){
        int id = 0;

        EntityRegistry.registerModEntity(EntityAwesomeCow.class, "AwesomeCow", id++, BVKS.instance, 10, 10, true);
        EntityRegistry.registerModEntity(EntityMiniSteve.class, "MiniSteve", id++, BVKS.instance, 10, 10, true);
    }

}
