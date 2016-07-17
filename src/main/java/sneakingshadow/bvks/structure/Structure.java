package sneakingshadow.bvks.structure;

import net.minecraft.world.World;

public class Structure {

    private boolean valid = true;
    public MultiBlock multiBlock;
    public int x,y,z,rotation;

    /**
     *  A multi block structure in world.
     *
     */
    public Structure(MultiBlock multiBlock, int x, int y, int z, int rotation) {
        this.multiBlock = multiBlock; this.x = x; this.y = y; this.z = z; this.rotation = rotation;
    }

    public Structure() {
        valid = false;
    }

    public boolean structureValid(World world) {
        return valid && multiBlock.checkStructure(world, x, y, z, rotation);
    }

    public MultiBlock getMultiBlock() {
        return multiBlock;
    }

    //TODO if I add id's to MultiBlock, then add write to and read from nbt here.

}
