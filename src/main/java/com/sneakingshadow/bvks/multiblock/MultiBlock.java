package com.sneakingshadow.bvks.multiblock;

import net.minecraftforge.oredict.OreDictionary;

public class MultiBlock {

    /**
     *  A structure block is something that will be checked in the world.
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
     *  A character, that's not a special character nor modifier, followed by a structure block, will map the value to the character.
     *  Modifiers in-between character and structure block will be taken into consideration.
     *  All the mapped characters would post-init be replaced by its mapped value.
     *  If a character is not mapped, it will be replaced by null.
     *
     *  A string-object is a string that's mapped to a structure block.
     *  Modifiers in-between string-object and structure block will be taken into consideration.
     *  All the mapped string-object would post-init be replaced by its mapped structure block.
     *  If a string-object is not mapped, it will be replaced by null.
     *
     *  A string-object is mapped to a structure block, by inputting '^', the string-object key, wanted modifiers, and a structure-block.
     *
     *  ArrayLists are allowed, can take modifiers, special characters and values.
     *  Can be mapped to a character, and simply be used as a structure block.
     *  If will check if any of the values in the ArrayList is correct.
     *  Note: Does not work in same manner as '|'.
     *
     *  Strings will add all the characters to the structure array.
     *  Special characters, special values and modifiers are allowed.
     *  Note: @ has to encase the ore-name if OreDictionary modifier is used.
     *
     *  OreDictionary is allowed, but must have the special character '@' before the ore-name.
     *      Example: '@', "cobblestone"
     *
     *  A multi-block that's in the shape of a furnace recipe lying down, with air block in the center:
     *      new MultiBlock(Blocks.cobblestone,"xx/", '@', "cobblestone", "_x/@cobblestone@@cobblestone@x", 'x', Blocks.cobblestone);
     *
     *
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
     *
     *  Structure Block Modifiers:
     *      '!' = not
     *          Inverts the next check
     *      '|' = or
     *          z = Blocks.cobblestone | Blocks.stone
     *          Either all z is cobblestone, or all z is stone.
     *      '&' = and
     *          Same as or, just that it has to be both.
     *
     *  Characters in strings can represent objects
     *      Binding an object to a character:
     *          (character, object)
     *  Strings can also represent objects
     *      Binding an object to a string:
     *          ("#" + string, object)
     *      Using string object:
     *          ("'" + string + "'")
     *          NOTE: String object can be used inside of a larger string, and doesn't exclusively have to be "'" + string + "'".
     *  OreDictionary is supported, but the strings must start and end with "@".
     *      example: "@logWood@"
     *  ArrayList<Object> are allowed to specify multiple choices in one block-space, can include characters (both in string and as characters), but can't include "/", "\\" or "#".
     * */
    public MultiBlock() {
    }

}
