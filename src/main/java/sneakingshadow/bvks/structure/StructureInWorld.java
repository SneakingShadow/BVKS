package sneakingshadow.bvks.structure;

import net.minecraft.world.World;

public class StructureInWorld {

    public Structure structure;
    public int x,y,z,rotation;

    public StructureInWorld(Structure structure, int x, int y, int z, int rotation) {
        this.structure = structure; this.x = x; this.y = y; this.z = z; this.rotation = rotation;
    }

    public boolean structureValid(World world) {
        return structure.checkStructure(world, x, y, z, rotation);
    }

}
