package com.sneakingshadow.bvks.multiblock;

import net.minecraftforge.oredict.OreDictionary;

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
     *  '\' character will set x and z to 0, and increase y by 1.
     *
     *  ArrayLists are counted as a structure block, can take modifiers, special characters and values.
     *  Only requires one value to be correct, doesn't matter which one.
     *  Note:
     *      Does not work in same manner as '|'.
     *      ArrayList can contain ArrayLists.
     *
     *  A structure block can be mapped to a character, and that character could be used in place of the structure block.
     *  Mapping is done by inputting:
     *      A character, that's not a special character nor modifier,
     *      wanted operands, 0 or more,
     *      followed by a structure block.
     *  All the key characters would post-init be replaced by its mapped value.
     *  If a character is not mapped, it will be replaced by null.
     *  A character key is used by having that character in a string.
     *
     *  A structure block can be mapped to a string, and that string could be used in place of the structure block.
     *  Mapping is done by inputting:
     *      '^',
     *      a string,
     *      wanted modifiers, 0 or more,
     *      followed by a structure block.
     *  All the key string would post-init be replaced by its mapped structure block.
     *  If a string-object is not mapped, it will be replaced by null.
     *  A string key is used by having "^" surrounding the string.
     *      Example: "^string_key^"
     *
     *  Operands and the structure block(s) it takes, are regarded as one structure block.
     *
     *  All the characters and string keys from a string will be added to the structure array.
     *  Special characters, special values and modifiers are allowed.
     *  Note: @ has to encase the ore-name if OreDictionary modifier is used.
     *
     *  OreDictionary is allowed, but must have the special character '@' before the ore-name.
     *      Example: '@', "cobblestone"
     *
     *  A multi-block that's in the shape of a furnace recipe lying down, with air block in the center:
     *      new MultiBlock(Blocks.cobblestone,"xx/", '@', "cobblestone", "_x/@cobblestone@@cobblestone@x", 'x', Blocks.cobblestone);
     *
     *  InputList work the exact same way as ArrayList<Object>, but is treated differently.
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
     *      '*' = opaque
     *          block.getMaterial().isOpaque()
     *      '#' = opaque
     *          block.getLightOpacity(world, x,y,z) == 255
     *
     *  Structure Array Modifier:
     *      '/' = next z column.
     *          z++  x=0
     *      '\' = next level up.
     *          y++  x=0  z=0
     *      '@' = OreDictionary
     *          If inputted as a character, next string will be assumed to be an ore-name.
     *          If used in string, the ore-name has to be encased in @
     *      '^' = string-object
     *          If inputted as a character, next string will be assumed to be a string-object.
     *          Following structure-block, and modifiers in between will be mapped to the string-object.
     *          If used in string, the string-object has to be encased in ^
     *
     *  Structure Block Operators:
     *      '!' = not       takes one operand
     *          Inverts the next check
     *      '&' = and       takes two operands
     *          Both cases have to be true
     *      '|' = or        takes two operands
     *          One of the cases have to be true.
     *          If you have two structure blocks, A and B, and you map:
     *          A, '|', B to character 'l', then everywhere l is used in place of (A, '|', B) has to yield the same result;
     *          meaning, if you get A,A,A,B it's invalid, but if it's only A or only B, then it's valid.
     *
     *      Note:
     *          These are in order of precedence, meaning:
     *          !A & B | c = ((!A) & B) | C
     *
     * */
    public MultiBlock(Object... objects) {

    }

}
