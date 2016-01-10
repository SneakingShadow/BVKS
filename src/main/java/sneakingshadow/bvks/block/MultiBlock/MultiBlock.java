package sneakingshadow.bvks.block.MultiBlock;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import sneakingshadow.bvks.init.ModMultiBlocks;
import sneakingshadow.bvks.util.Position;

public class MultiBlock {

    public int minX,minY,minZ;
    public int maxX,maxY,maxZ;
    public int rx,rz;
    public int id;
    public int turns;
    public MultiBlockStructure multiBlock;

    public MultiBlock(Position minPos, Position maxPos, int turns, int rotatePointX, int rotatePointZ, int structureID) {
        this(minPos.x, minPos.y, minPos.z, maxPos.x, maxPos.y, maxPos.z, turns, rotatePointX, rotatePointZ, structureID);
    }
    public MultiBlock(int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int turns, int rotatePointX, int rotatePointZ, int structureID) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.minZ = minZ;
        this.maxZ = maxZ;
        this.turns = turns;
        this.rx = rotatePointX;
        this.rz = rotatePointZ;
        this.id = structureID;
        this.multiBlock = ModMultiBlocks.getMultiBlock(id);
    }

    public Block getBlockAtMapPosition(World world, int x, int y, int z) {
        Position pos = new Position(x,y,z).turn(turns, rx, rz);
        return world.getBlock(minX+pos.x, minY+pos.y, minZ+pos.z);
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound){
        nbtTagCompound.setInteger("minX",this.minX);
        nbtTagCompound.setInteger("minY",this.minY);
        nbtTagCompound.setInteger("minZ",this.minZ);
        nbtTagCompound.setInteger("maxX",this.maxX);
        nbtTagCompound.setInteger("maxY",this.maxY);
        nbtTagCompound.setInteger("maxZ",this.maxZ);
        nbtTagCompound.setInteger("turns",this.turns);
        nbtTagCompound.setInteger("rotatePointX",this.rx);
        nbtTagCompound.setInteger("rotatePointZ",this.rz);
        nbtTagCompound.setInteger("structureID",this.id);
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound){
        this.minX = nbtTagCompound.getInteger("minX");
        this.minY = nbtTagCompound.getInteger("minY");
        this.minZ = nbtTagCompound.getInteger("minZ");
        this.maxX = nbtTagCompound.getInteger("maxX");
        this.maxY = nbtTagCompound.getInteger("maxY");
        this.maxZ = nbtTagCompound.getInteger("maxZ");
        this.turns = nbtTagCompound.getInteger("turns");
        this.rx = nbtTagCompound.getInteger("rotatePointX");
        this.rz = nbtTagCompound.getInteger("rotatePointZ");
        this.id = nbtTagCompound.getInteger("structureID");
        this.multiBlock = ModMultiBlocks.getMultiBlock(id);
    }

    public static MultiBlockStructure createFromNBT(NBTTagCompound nbtTagCompound){
        return new MultiBlockStructure(
                nbtTagCompound.getInteger("minX"),
                nbtTagCompound.getInteger("minY"),
                nbtTagCompound.getInteger("minZ"),
                nbtTagCompound.getInteger("maxX"),
                nbtTagCompound.getInteger("maxY"),
                nbtTagCompound.getInteger("maxZ"),
                nbtTagCompound.getInteger("turns"),
                nbtTagCompound.getInteger("rotatePointX"),
                nbtTagCompound.getInteger("rotatePointZ"),
                nbtTagCompound.getInteger("structureID")
        );
    }
}
