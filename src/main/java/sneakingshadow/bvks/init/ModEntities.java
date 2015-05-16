package sneakingshadow.bvks.init;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import sneakingshadow.bvks.BVKS;
import sneakingshadow.bvks.client.renderer.Entity.RenderAwesomeCow;
import sneakingshadow.bvks.entity.EntityAwesomeCow;
import sneakingshadow.bvks.reference.Ref;

public class ModEntities {

    public static void init(){
        int id = 0;

        EntityRegistry.registerModEntity(EntityAwesomeCow.class, "AwesomeCow", id++, BVKS.instance, 10, 10, true);
    }

}
