package sneakingshadow.bvks.block.MultiBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import sneakingshadow.bvks.util.LogHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiBlockStructure {

    private Object[][][] structure;
    private int width = 0, length = 0, height = 0;
    public MultiBlockStructure(int width, int height, int length, Object... objects) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.structure = sortObjects(objects);
    }

    public MultiBlockInWorld findMultiBlock(World world, int x, int y, int z) {
        ArrayList<Position> positions = new ArrayList<Position>();
        for (int k=0; k<length; k++) {
            for (int j=0; j<height; j++) {
                for (int i=0; i<width; i++) {
                    if (blockMatch( this.structure[i][j][k], world, x,y,z )) {
                        positions.add(new Position(i,j,k));
                    }
                }
            }
        }
        for (Position pos : positions) {
            MultiBlockInWorld multiBlock = matches(world, x, y, z, pos);
            if (multiBlock != null)
                return multiBlock;
        }

        return null;
    }

    public class MultiBlockInWorld {

        public int minX,minY,minZ;
        public int maxX,maxY,maxZ;
        private int turns;

        public MultiBlockInWorld(Position minPos, Position maxPos, int turns) {
            this.minX = minPos.x;
            this.minY = minPos.y;
            this.minZ = minPos.z;
            this.maxX = maxPos.x;
            this.maxY = maxPos.y;
            this.maxZ = maxPos.z;
            this.turns = turns;
        }

        public Block getBlockAtMapPosition(World world, int x, int y, int z) {
            Position pos = new Position(x,y,z).turn(turns);
            return world.getBlock(minX+pos.x, minY+pos.y, minZ+pos.z);
        }
    }

    private Object[][][] sortObjects (Object[] objects) {
        Object[][][] returnObjects = new Object[this.width][this.height][this.length];
        HashMap<Character, Object> hashMap = new HashMap<Character, Object>();

        boolean flag = false;
        char character = 'a';
        ArrayList<Integer> remove = new ArrayList<Integer>();
        int num = -1;
        for (int i = objects.length-1; i>-1; i--)
        {
            if (flag && !(objects[i] instanceof Character)) {
                hashMap.put(character, objects[i]);
                remove.add(num);
                remove.add(i);
                flag = false;
            }
            if (objects[i] instanceof Character && !hashMap.containsKey(objects[i])) {
                character = (Character) objects[i];
                num = i;
                flag = true;
            }
        }
        ArrayList<Object> objectArrayList = new ArrayList<Object>();
        for (Object obj : objects)
            objectArrayList.add(obj);
        for (int i : remove)
            objectArrayList.remove(i);
        objects = objectArrayList.toArray();

        int x=0,y=0,z=0;
        for (Object obj : objects)
        {
            if (obj instanceof Character)
                obj = hashMap.get(obj);
            if (obj == null || obj instanceof Block || obj instanceof ItemStack || obj instanceof Material || obj instanceof String) {
                returnObjects[x][y][z] = obj;
                x++;
                if (x == this.width) {
                    x=0;
                    z++;
                    if (z == this.length) {
                        z=0;
                        y++;
                    }
                }
            }
        }
        return returnObjects;
    }

    private MultiBlockInWorld matches (World world, int x, int y, int z, Position position) {
        boolean flag;
        for (int i=0; i<4; i++) {
            flag = true;
            for (int w = 0; w < this.structure.length; w++)
                for (int h = 0; h < this.structure[w].length; h++)
                    for (int l = 0; l < this.structure[w][h].length; l++) {
                        Position pos = new Position(w + x-position.x, h + y-position.y, l + z-position.z,  x-position.x, y-position.y, z-position.z).turn(i);
                        flag = flag && blockMatch(this.structure[w][h][l], world, pos.x, pos.y, pos.z);
                        //world.setBlock(pos.x,pos.y,pos.z, Blocks.cobblestone);
                    }
            if (flag)
            {
                LogHelper.info("x: "+x);
                LogHelper.info("y: "+y);
                LogHelper.info("z: "+z);
                return new MultiBlockInWorld(new Position(x - position.x, y - position.y, z - position.z).turn(i),
                        new Position(x - position.x + this.structure.length-1, y - position.y + this.structure[0].length-1, z - position.z + this.structure[0][0].length-1).turn(i),
                        i
                );
            }
        }
        return null;
    }

    private boolean blockMatch (Object object, World world, int x, int y, int z) {
        Block block = world.getBlock(x,y,z);
        return object == null && block.isAir(world, x,y,z)
                || object instanceof Block && object == block
                || object instanceof ItemStack && Block.getBlockFromItem(((ItemStack)object).getItem()) == block && world.getBlockMetadata(x,y,z) == ((ItemStack)object).getItemDamage()
                || object instanceof Material && object == block.getMaterial()
                || object instanceof String && OreDictionary.getOreName(Item.getIdFromItem(Item.getItemFromBlock(block))).equals(object);
    }

    private class Position {

        public int x=0,y=0,z=0;
        public int rx=0,ry=0,rz=0; // The point this point turns around

        public Position(int x, int y, int z) {
            this.x=x;
            this.y=y;
            this.z=z;
        }

        public Position(int x, int y, int z, int rx, int ry, int rz) {
            this.x=x;
            this.y=y;
            this.z=z;
            this.rx=rx;
            this.ry=ry;
            this.rz=rz;
        }

        public Position turn(int i) {
            int num;
            for (int j = 0; j < i; j++) {
                num = x;
                x = z;
                z = -num;
            }
            return this;
        }

    }
}
