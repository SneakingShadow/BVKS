package sneakingshadow.bvks.block.MultiBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import sneakingshadow.bvks.util.LogHelper;
import sneakingshadow.bvks.util.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MultiBlockStructure {

    private Object[][][] structure;
    private int width = 0, length = 0, height = 0;
    public MultiBlockStructure(int width, int height, int length, Object... objects) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.structure = sortObjects(objects);
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
            if (obj instanceof String)
                obj = OreDictionary.getOres((String)obj);
            if (obj == null || obj instanceof Block || obj instanceof ItemStack || obj instanceof Material || obj instanceof ArrayList) {
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

    public MultiBlock findMultiBlock(World world, int x, int y, int z) {
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
            MultiBlock multiBlock = matches(world, x, y, z, pos);
            if (multiBlock != null)
                return multiBlock;
        }

        return null;
    }

    /*public boolean multiBlockValid(int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int rotation) {

    }*/

    private MultiBlock matches (World world, int x, int y, int z, Position position) {
        boolean flag;
        for (int i=0; i<4; i++) {
            flag = true;
            for (int w = 0; w < this.structure.length; w++)
                for (int h = 0; h < this.structure[w].length; h++)
                    for (int l = 0; l < this.structure[w][h].length; l++) {
                        Position pos = new Position(w + x-position.x, h + y-position.y, l + z-position.z).turn(i, position.x, position.z);
                        flag = flag && blockMatch(this.structure[w][h][l], world, pos.x, pos.y, pos.z);
                        if (blockMatch(this.structure[w][h][l], world, pos.x, pos.y, pos.z)&& false)
                            world.setBlock(pos.x,pos.y,pos.z, Blocks.cobblestone);
                    }
            LogHelper.info(flag);
            if (flag)
            {
                return new MultiBlock(new Position(x - position.x, y - position.y, z - position.z).turn(i, position.x, position.z),
                        new Position(x - position.x + this.structure.length-1, y - position.y + this.structure[0].length-1, z - position.z + this.structure[0][0].length-1).turn(i, position.x, position.z),
                        i, position.x, position.z, this.getID());
            }
        }
        return null;
    }

    private boolean blockMatch (Object object, World world, int x, int y, int z) {
        Block block = world.getBlock(x,y,z);
        if(object instanceof ArrayList) {
            boolean flag = false;
            Iterator<ItemStack> iterator = ((ArrayList<ItemStack>)object).iterator();
            while (iterator.hasNext() && !flag)
                flag = OreDictionary.itemMatches(iterator.next(), new ItemStack(block, 1, world.getBlockMetadata(x,y,z)), false);
            if (flag)
                return true;
        }
        return object == null && block.isAir(world, x,y,z)
                || object instanceof Block && object == block
                || object instanceof ItemStack && Block.getBlockFromItem(((ItemStack)object).getItem()) == block && world.getBlockMetadata(x,y,z) == ((ItemStack)object).getItemDamage()
                || object instanceof Material && object == block.getMaterial();
    }

    private int id=0;
    public void setID(int ID) {
        this.id = ID;
    }
    public int getID() { return this.id; }

}
