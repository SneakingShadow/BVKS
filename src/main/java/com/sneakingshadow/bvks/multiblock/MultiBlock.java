package com.sneakingshadow.bvks.multiblock;

import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class MultiBlock {

    /**
     *  A structure block is something that will be compared to the blocks in world.
     *      Example: Blocks.cobblestone
     *  For specifying metadata on blocks, the block must be put in an ItemStack.
     *
     *  The structure array, is the array which the multi-block will compare to the in world structure to see if it's valid.
     *
     *  The structure array starts at x = 0, y = 0, z = 0.
     *  A structure block will increase x by one and add it in the structure array.
     *  '/' character will set x to 0, and increase z by 1.
     *  '\\' character will set x and z to 0, and increase y by 1.
     *
     *  ArrayLists are counted as a structure block,
     *  and they can take operators, special characters, values and modifiers, but not structure modifiers.
     *  Only requires one value to be correct, doesn't matter which one.
     *  Can be made by using ( and ), where everything in between is put in an ArrayList.
     *  Note:
     *      Does not work in same manner as '|'.
     *      ArrayList can contain ArrayLists.
     *      both '('  ')' and "("  ")" can be used.
     *
     *  A structure block can be mapped to a character, and that character could be used in place of the structure block.
     *  Mapping is done by inputting:
     *      A character, that's not a special character nor modifier.
     *      followed by a structure block.
     *  Note:
     *      Modifiers and operators are allowed, but not structure modifiers.
     *      A & B counts as one structure block
     *  All the key characters would post-init be replaced by its mapped value.
     *  If a character is not mapped nor a special character, it will be replaced by null.
     *  A character key is used by having that character in a string.
     *
     *  A structure block can be mapped to a string, that string is called a string-object,
     *  and that string-object could be used in place of the structure block.
     *  Mapping is done by inputting:
     *      '^',
     *      a string,
     *      followed by a structure block.
     *  Note:
     *      Modifiers and operators are allowed, but not structure modifiers.
     *      A & B counts as one structure block
     *  All the key string would post-init be replaced by its mapped structure block.
     *  If a string-object is not mapped, it will be replaced by null.
     *  A string-object is used by having "^" surrounding the string.
     *      Example: "^string_key^"
     *
     *  Operators and the operand(s) it takes, are regarded as one structure block.
     *
     *  In a string:
     *  All the characters and string-object will be added to the structure array.
     *  Special characters, special values, operators and modifiers are allowed.
     *  Structure modifiers are not allowed.
     *  Note:
     *      @ has to encase the ore-name if OreDictionary modifier is used.
     *          "@cobblestone@"
     *
     *  OreDictionary is allowed, but must have the special character '@' before the ore-name.
     *      Example: '@', "cobblestone"
     *
     *  A multi-block that's in the shape of a furnace recipe lying down, with air block in the center:
     *      new MultiBlock(Blocks.cobblestone,"xx/", '@', "cobblestone", "_x/@cobblestone@@cobblestone@x", 'x', Blocks.cobblestone);
     *
     *  InputList extends ArrayList<Object>, but is treated differently.
     *  Everything in an InputList is treated as if it was inputted outside of the input list.
     *      new MultiBlock(new InputList(A,B,C)) = new MultiBlock(A,B,C)
     *
     *  Special Characters / Values:
     *      ' ' or null = anything. doesn't matter what block it is.
     *          true
     *      '+' = full block
     *          block.isOpaqueCube()
     *      '_' = air block
     *          block.isAir(world, x,y,z)
     *      '-' = replaceable block
     *          block.isReplaceable(world,x,y,z)
     *      '~' = liquid
     *          block.getMaterial().isLiquid()
     *      '*' = opaque material
     *          block.getMaterial().isOpaque()
     *      '#' = opaque light based
     *          block.getLightOpacity(world, x,y,z) == 255
     *
     *  Modifiers, in order of precedence:
     *      '@' = OreDictionary
     *          If inputted as a character, next string will be assumed to be an ore-name.
     *          If used in string, the ore-name has to be encased in @
     *
     *  Mapping:
     *      '^' = string-object
     *          If inputted as a character, next string will be assumed to be a string-object.
     *          Following structure block, and modifiers in between will be mapped to the string-object.
     *          If used in string, the string-object has to be encased in ^
     *
     *  Structure Modifier:
     *      '(' and ')' = Brackets
     *          Can be used in and outside of string as characters.
     *          Everything inside will be put in an ArrayList.
     *      '/' = next z column.
     *          z++  x=0
     *      '\' = next level up.
     *          y++  x=0  z=0
     *
     *  Operators, in order of precedence:
     *      '!' = not       takes one operand
     *          Inverts the next check
     *      '&' = and       takes two operands
     *          Both cases have to be true
     *      '|' = or        takes two operands
     *          One of the cases have to be true.
     *          If you have two structure blocks, A and B, and you map:
     *          A, '|', B to character 'l', then everywhere l is used in place of (A, '|', B) has to yield the same result;
     *          meaning, if you get A,A,A,B it's invalid, but if it's only A or only B, then it's valid.
     *      Note:
     *          A & B & C = (A & B) & C
     *
     *  Order of precedence:
     *      Extract InputLists
     *      Brackets
     *      Sort any found ArrayLists, in this order of precedence, without Structure Modifiers
     *      Modifiers
     *      Transform special characters and special values to StructureBlock
     *      Operators
     *      Mapping
     *      Structure Modifiers
     *
     *  The multiblock can check for structures with any orientation.
     *  Rotation is by default set to only rotate around Y axis,
     *  but this can be changed using the 'set rotation around axis' functions.
     *  Rotation is per 90°, 1/2 pi in radians.
     *
     * */
    public MultiBlock(Object... objects) {
        structureArray = InputHandler.getStructure(objects);
    }

    private StructureArray structureArray;
    private boolean rotatesAroundX = false;
    private boolean rotatesAroundY = true;
    private boolean rotatesAroundZ = false;

    /*
    * Set rotation around axis
    * */
    public MultiBlock setRotatationAroundXAxis(boolean bool) {
        rotatesAroundX = bool;
        return this;
    }
    public MultiBlock setRotatationAroundYAxis(boolean bool) {
        rotatesAroundY = bool;
        return this;
    }
    public MultiBlock setRotatationAroundZAxis(boolean bool) {
        rotatesAroundZ = bool;
        return this;
    }

    /*
    * Get rotation around axis
    * */
    public boolean getRotationAroundXAxis() {
        return rotatesAroundX;
    }
    public boolean getRotationAroundYAxis() {
        return rotatesAroundY;
    }
    public boolean getRotationAroundZAxis() {
        return rotatesAroundZ;
    }

    /**
     * Returns null if no structure is found
     * */
    public Structure findStructure(World world, int x, int y, int z) {

        if (y < 0 || y > 255)
            return null;

        //Loop through array
        for (int ix = 0; ix < structureArray.sizeX(); ix++)
            for (int iy = 0; iy < structureArray.sizeY(); iy++)
                for (int iz = 0; iz < structureArray.sizeZ(); iz++)

                    //Check if structure block is equal to block in world
                    if ( structureArray.get(ix, iy, iz).blockIsValid(world, x, y, z) )

                        /*
                        * Rotate around set axes.
                        * If not rotating around axis, it will go from [0,1>.
                        * */
                        for (int rotationX = 0; rotationX < (rotatesAroundX ? 4 : 1); rotationX++)
                            for (int rotationY = 0; rotationY < (rotatesAroundY ? 4 : 1); rotationY++)
                                for (int rotationZ = 0; rotationZ < (rotatesAroundZ ? 4 : 1); rotationZ++) {

                                    //Try to find structure with set rotations.
                                    Structure structure = findStructure(
                                            world,
                                            Vec3.createVectorHelper(x,y,z),
                                            Vec3.createVectorHelper(ix,iy,iz),
                                            rotationX,
                                            rotationY,
                                            rotationZ
                                    );

                                    if (structure != null)
                                        return structure;
                                }


        return null;
    }

    /**
     * Finds a structure based on:
     * @param world
     * @param startPosition the block in world that is equal to that in the array.
     * @param arrayPosition the position in the array that the structure block is compared to.
     * @param rotationX the rotation of the structure around the x-axis.
     * @param rotationY the rotation of the structure around the y-axis.
     * @param rotationZ the rotation of the structure around the z-axis.
     *
     * Rotations are measured in quarter-full rotations, meaning from 0 to 3.
     * */
    public Structure findStructure(World world, Vec3 startPosition, Vec3 arrayPosition, int rotationX, int rotationY, int rotationZ) {

        return null;
    }

    private float rotation(int rotation) {
        return (float) (rotation/2 * Math.PI);
    }
}
