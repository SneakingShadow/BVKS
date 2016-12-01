package com.sneakingshadow.bvks.multiblock;

import com.sun.istack.internal.NotNull;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;

import static com.sneakingshadow.bvks.multiblock.MultiBlockUtil.rotate;

public class MultiBlock {

    private StructureArray structureArray;
    private boolean rotatesAroundX = false;
    private boolean rotatesAroundY = true;
    private boolean rotatesAroundZ = false;

    /**
     * A structure block is something that will be compared to the blocks in world.
     *     Example: Blocks.cobblestone
     * This will 'convert' the block into a StructureBlock that checks for that specific block.
     * For specifying metadata on blocks, the block must be put in an ItemStack, and ItemStack damage will be used as metadata.
     *
     * You can also input your own structure block. Remember to implement everything needed specified in the StructureBlock class.
     *
     * The structure array, is the array which the multi-block will compare to the in world structure to see if it's valid.
     *
     * The structure array starts at x = 0, y = 0, z = 0.
     * A structure block will increase x by one and add it in the structure array.
     * '/' character will set x to 0, and increase z by 1.
     * '\\' character will set x and z to 0, and increase y by 1.
     *
     * ArrayLists are counted as a structure block,
     * and they can take operators, special characters, values, duplicators and modifiers, but not structure modifiers.
     * Only requires one value to be correct, doesn't matter which one.
     * Can be made by using ( and ), where everything in between is put in an ArrayList.
     * Note:
     *     Does not work in same manner as '|'.
     *     ArrayList can contain ArrayLists.
     *     both '('  ')' and "("  ")" can be used.
     *
     * A structure block can be mapped to a character, and that character could be used in place of the structure block.
     * Mapping is done by inputting:
     *     A character, that's not a special character nor operator nor modifier nor structure modifier.
     *     followed by a structure block.
     * Note:
     *     Special values, modifiers and operators are allowed, but not structure modifiers.
     *     A & B counts as one structure block.
     *     Mapping can't be done in an ArrayList
     * All the key characters would post-init be replaced by its mapped value.
     * If a character is not mapped nor a special character, it will be replaced by null.
     * A character key is used by having that character in a string.
     *
     * A structure block can be mapped to a string, that key string is called a string-object,
     * and that string-object could be used in place of the structure block.
     * Mapping is done by inputting:
     *     '^',
     *     a string,
     *     followed by a structure block.
     * Note:
     *     Special values, modifiers and operators are allowed, but not structure modifiers.
     *     A & B counts as one structure block
     *     Mapping can't be done in an ArrayList
     * All the key string would post-init be replaced by its mapped structure block.
     * If a string-object is not mapped, it will be replaced by null.
     * A string-object is used by having "^" surrounding the string.
     *     Example: "^string_key^"
     *
     * Operators and the operand(s) it takes, are regarded as one structure block.
     *
     * In a string:
     * All the characters and string-object will be added to the structure array.
     * Special characters, operators, modifiers and structure modifiers are allowed, but not duplicators.
     * Special values are of course not allowed.
     * Note:
     *     @ has to encase the ore-name if OreDictionary modifier is used.
     *         "@cobblestone@"
     *
     * OreDictionary is allowed, but must have the special character '@' before the ore-name.
     *     Example: '@', "cobblestone"
     *
     * InputList extends ArrayList<Object>, but is treated differently.
     * Everything in an InputList is treated as if it was inputted outside of the input list.
     *     new MultiBlock(new InputList(A,B,C)) = new MultiBlock(A,B,C)
     *
     * There's also duplicators, like '>' and '<'.
     * The difference between the two is that '<' is called before the unpacking of InputLists,
     * while '>' is called after the unpacking of InputLists.
     * Usage of the two operators is done by inputting:
     *     an object to duplicate,
     *     operator,
     *     amount of times to duplicate
     * Note:
     *     amount of times to duplicate has to be an integer that's above 0
     * Example:
     *     new InputList(A,B,C), '<', 2   ->   new InputList(A,B,C),new InputList(A,B,C)  ->  A,B,C,A,B,C
     *     new InputList(A,B,C), '>', 3   ->   A,B,C,C,C
     *
     * Special Characters / Values:
     *     ' ' or null = anything. doesn't matter what block it is.
     *         true
     *     '+' = full block
     *         block.isOpaqueCube()
     *     '_' = air block
     *         block.isAir(world, x,y,z)
     *     '-' = replaceable block
     *         block.isReplaceable(world,x,y,z)
     *     '~' = liquid
     *         block.getMaterial().isLiquid()
     *     '*' = opaque material
     *         block.getMaterial().isOpaque()
     *     '#' = opaque light based
     *         block.getLightOpacity(world, x,y,z) == 255
     *
     * Modifiers, in order of precedence:
     *     '@' = OreDictionary
     *         If inputted as a character, next string will be assumed to be an ore-name.
     *         If used in string, the ore-name has to be encased in @
     *
     * Mapping:
     *     '^' = string-object
     *         If inputted as a character, next string will be assumed to be a string-object.
     *         Following structure block, and modifiers in between will be mapped to the string-object.
     *         If used in string, the string-object has to be encased in ^
     *
     * Structure Modifier:
     *     '/' = next z column.
     *         z++  x=0
     *     '\' = next level up.
     *         y++  x=0  z=0
     *
     * Duplicators, in order of precedence:
     *     '<' = duplicator
     *         level 0
     *     '>' = duplicator
     *         level 1
     *     '*' = duplicator
     *         level 2
     *
     *     These two take an operand before it, and an integer operand after it.
     *     It copies the value before it, the amount of times that the operand after it specifies.
     *     Note:
     *         This operand will be ignored if no integer is found, or integer is lower than 1.
     *
     * Operators, in order of precedence:
     *     '(' and ')' = Brackets
     *         Can be used in and outside of string as characters.
     *         Everything inside will be put in an ArrayList.
     *     '!' = not       takes one operand
     *         Inverts the next check
     *     '&' = and       takes two operands
     *         Both cases have to be true
     *     '|' = or        takes two operands
     *         One of the cases have to be true.
     *         If it's mapped to something, everything it's mapped to has to be the same.
     *         A, '|', B to character 'l', then everywhere l is used in place of (A, '|', B) has to yield the same result;
     *         meaning, if you get A,A,A,B it's invalid, but if it's only A or only B, then it's valid.
     *     Note:
     *         A & B & C = (A & B) & C
     *
     * Order of precedence:
     *     Duplicator, level 0
     *     Extraction of InputLists
     *     Duplicator, level 1
     *     Brackets
     *     Sort any found ArrayLists, in this order of precedence, without Structure Modifiers
     *     Modifiers
     *     Transform special characters and special values to StructureBlock
     *     Duplicator, level 2
     *     Operators
     *     Duplicator, level 3
     *     Mapping
     *     Structure Modifiers
     *
     * A multi-block that's in the shape of a furnace recipe lying down, with air block in the center:
     *     new MultiBlock("xxx/x_x/xxx", 'x', Blocks.cobblestone);
     *
     * The multiblock-object can check for structures with any orientation, by using:
     *     multiBlockObject.findStructure(World world, int x, int y, int z)
     * This returns a new Structure, or null if no structure was found.
     *
     *     findStructures(World world, int x, int y, int z)
     * Checks for all possible structures of this multiblock in world,
     * and returns an ArrayList<Structure>, that's empty if none are found.
     * This can be useful if you want to avoid overlapping structures.
     *
     * Rotation is by default set to only rotate around Y axis,
     * but this can be changed using the 'set rotation around axis' functions.
     * Rotation is per 90°, 1/2 pi in radians.
     *
     *
     *
     * */
    public MultiBlock(Object... objects) {
        structureArray = InputHandler.getStructureArray(objects);
    }

    /*
    * Set rotation around axis
    * */
    public MultiBlock setRotationXAxis(boolean bool) {
        rotatesAroundX = bool;
        return this;
    }
    public MultiBlock setRotationYAxis(boolean bool) {
        rotatesAroundY = bool;
        return this;
    }
    public MultiBlock setRotationZAxis(boolean bool) {
        rotatesAroundZ = bool;
        return this;
    }





    /*
    * Get rotation around axis
    * */
    public boolean rotatesAroundXAxis() {
        return rotatesAroundX;
    }
    public boolean rotatesAroundYAxis() {
        return rotatesAroundY;
    }
    public boolean rotatesAroundZAxis() {
        return rotatesAroundZ;
    }

    /**
     * Checks for a structure in world, in any possible position that overlaps x,y,z.
     * Returns null if it didn't find a structure.
     * */
    public Structure findStructure(World world, int x, int y, int z) {
        ArrayList<Structure> structure = findStructures(world, x, y, z, false);
        return structure.isEmpty() ? null : structure.get(0);
    }

    /**
     * Finds all possible structures in world. Useful if you want to guarantee there aren't structures overlapping.
     * Returns and empty array if none are found
     * */
    public ArrayList<Structure> findStructures(World world, int x, int y, int z) {
        return findStructures(world, x, y, z, true);
    }

    /**
     * Returns an empty ArrayList if no structures are found.
     * */
    @NotNull
    private ArrayList<Structure> findStructures(World world, int x, int y, int z, boolean checkAllStructures) {
        ArrayList<Structure> structureList = new ArrayList<Structure>();

        if (y < 0 || y > 255)
            return structureList;

        //Loop through array
        for (int ix = 0; ix < structureArray.sizeX(); ix++) {
            for (int iy = 0; iy < structureArray.sizeY(); iy++) {
                for (int iz = 0; iz < structureArray.sizeZ(); iz++) {
                    //Check if program should continue checking for structure at these array coordinates
                    if (structureArray.get(ix, iy, iz).startCheckingForStructure(world, x, y, z)) {
                        /*
                        * Looks at array as a cube with 6 sides and 4 possible rotations per side.
                        * */

                        //Top side, and if rotatesAroundX or rotatesAroundZ then the bottom side as well
                        for (int rotationX = 0; rotationX < (rotatesAroundX || rotatesAroundZ ? 4 : 1); rotationX += 2) {
                            Structure structure = validate(world, x,y,z, ix,iy,iz, rotationX, 0);
                            if (structure != null) {
                                structureList.add(structure);
                                if (!checkAllStructures)
                                    return structureList;
                            }
                        }

                        //Two of the four sides that are not top nor bottom, that are inaccessible by rotationZ
                        if (rotatesAroundX) for (int rotationX = 1; rotationX < 4; rotationX += 2) {
                            Structure structure = validate(world, x, y, z, ix, iy, iz, rotationX, 0);
                            if (structure != null) {
                                structureList.add(structure);
                                if (!checkAllStructures)
                                    return structureList;
                            }
                        }

                        //Two of the four sides that are not top nor bottom, that are inaccessible by rotationX
                        if (rotatesAroundZ) for (int rotationZ = 1; rotationZ < 4; rotationZ += 2) {
                            Structure structure = validate(world, x, y, z, ix, iy, iz, 0, rotationZ);
                            if (structure != null) {
                                structureList.add(structure);
                                if (!checkAllStructures)
                                    return structureList;
                            }
                        }

                    }
                }
            }
        }

        return structureList;
    }

    /**
     * validates the side accessed by rotationX and rotationZ, in any rotationY.
     * */
    private Structure validate(World world, int x, int y, int z, int ix, int iy, int iz, int rotationX, int rotationZ) {
        for (int rotationY = 0; rotationY < (rotatesAroundY ? 4 : 1); rotationY++) {
            Vec3 arrayPosition = rotate(Vec3.createVectorHelper(ix, iy, iz), rotationX, rotationY, rotationZ);
            Vec3 startCorner = arrayPosition.subtract(Vec3.createVectorHelper(x, y, z));

            if (validate(world, startCorner, rotationX, rotationY, rotationZ)) {
                return new Structure(this, world, startCorner, rotationX, rotationY, rotationZ);
            }
        }

        return null;
    }

    /**
     * Validates a structure based on:
     * @param world
     * @param cornerPosition the location of the corner of the structure.
     * @param rotationX the rotation of the structure around the x-axis.
     * @param rotationY the rotation of the structure around the y-axis.
     * @param rotationZ the rotation of the structure around the z-axis.
     *
     * Rotations are measured in quarter-full rotations, meaning from 0 to 3.
     * */
    public boolean validate(World world, Vec3 cornerPosition, int rotationX, int rotationY, int rotationZ) {
        for (int x = 0; x < structureArray.sizeX(); x++) {
            for (int y = 0; y < structureArray.sizeY(); y++) {
                for (int z = 0; z < structureArray.sizeZ(); z++) {
                    Vec3 currentArrayPosition = Vec3.createVectorHelper(x,y,z);
                    Vec3 currentWorldPosition = rotate(
                            Vec3.createVectorHelper(x,y,z), rotationX, rotationY, rotationZ //can't rotate currentArrayPosition, and therefore have to make a new one
                    ).addVector(cornerPosition.xCoord, cornerPosition.yCoord, cornerPosition.zCoord);

                    if (!structureArray.blockIsValid(world, currentWorldPosition, currentArrayPosition, rotationX, rotationY, rotationZ)) {
                        structureArray.reset();
                        return false;
                    }
                }
            }
        }
        structureArray.reset();

        return true;
    }

    public int sizeX() {
        return structureArray.sizeX();
    }
    public int sizeY() {
        return structureArray.sizeY();
    }
    public int sizeZ() {
        return structureArray.sizeZ();
    }

    /**
     * Outputs the structure in string form.
     * Will try to optimize readability, by putting the axis with the lowest size first.
     * */
    public String toString() {
        return super.toString() + "\n\n" + structureArray.toString();
    }

    public void debugStructureArray() {
        structureArray.debug();
    }
}
