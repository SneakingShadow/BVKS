package com.sneakingshadow.bvks.structure.comparator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import com.sneakingshadow.bvks.structure.MultiBlock;
import com.sneakingshadow.bvks.structure.MultiBlockUtil;

/**
 * Created by SneakingShadow on 23.07.2016.
 */
public class StairComparatorUtil {
    public static final Block[] VANILLA_STAIRS = {
            Blocks.oak_stairs, Blocks.birch_stairs, Blocks.spruce_stairs,
            Blocks.jungle_stairs, Blocks.acacia_stairs, Blocks.dark_oak_stairs,
            Blocks.stone_stairs, Blocks.stone_brick_stairs,
            Blocks.nether_brick_stairs, Blocks.quartz_stairs,
            Blocks.sandstone_stairs, Blocks.brick_stairs,
    };
    public static final Character CHAR_NORTH = 'n';
    public static final Character CHAR_SOUTH = 's';
    public static final Character CHAR_EAST = 'e';
    public static final Character CHAR_WEST = 'w';
    public static final Character CHAR_NORTH_EAST = 'N';
    public static final Character CHAR_NORTH_WEST = 'W';
    public static final Character CHAR_SOUTH_EAST = 'E';
    public static final Character CHAR_SOUTH_WEST = 'S';
    public static final String NORTH = "north";
    public static final String SOUTH = "south";
    public static final String EAST = "east";
    public static final String WEST = "west";
    public static final String NORTH_EAST = NORTH+"_"+EAST;
    public static final String NORTH_WEST = NORTH+"_"+WEST;
    public static final String SOUTH_EAST = SOUTH+"_"+EAST;
    public static final String SOUTH_WEST = SOUTH+"_"+WEST;

    /**
     * Initializes characters for stairs in all directions.
     * If no arguments is given, StairComparator is given no arguments
     *
     *
     *   WnN
     *   w e
     *   SsE
     *
     * */
    public static MultiBlock.StructureList stairInitializer(Object... objects) {
        Character[] chars = new Character[] {
                CHAR_NORTH, CHAR_SOUTH, CHAR_EAST, CHAR_WEST,
                CHAR_NORTH_EAST, CHAR_NORTH_WEST, CHAR_SOUTH_EAST, CHAR_SOUTH_WEST
        };
        return stairInitializer(chars, objects);
    }

    /**
     * Initializes strings for stairs in all directions.
     * If no arguments is given, StairComparator is given no arguments
     *
     *
     *   'string_north_west' 'string_north' 'string_north_east'
     *   'string_west'                      'string_east'
     *   'string_south_west' 'string_south' 'string_south_east'
     *
     *    Note: if string = "", then it won't add _ after string
     * */
    public static MultiBlock.StructureList stairStringInitializer(String string,Object... objects) {
        String[] strings = new String[] {
                NORTH, SOUTH, EAST, WEST,
                NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST
        };
        return stairStringInitializer(string,strings, objects);
    }

    /**
     * Initializes strings for stairs in all directions.
     * If no arguments is given, StairComparator is given no arguments
     *
     *
     *   'string_nw' 'string_n' 'string_ne'
     *   'string_w'             'string_e'
     *   'string_sw' 'string_s' 'string_se'
     *
     *   Note: if string = "", then it won't add _ after string
     * */
    public static MultiBlock.StructureList stairShortStringInitializer(String string, Object... objects) {
        String[] strings = new String[] {
                ""+ CHAR_NORTH, ""+ CHAR_SOUTH, ""+ CHAR_EAST, ""+ CHAR_WEST,
                ""+ CHAR_NORTH + CHAR_EAST, ""+CHAR_NORTH + CHAR_WEST,
                ""+ CHAR_SOUTH + CHAR_EAST, ""+CHAR_SOUTH + CHAR_WEST
        };
        return stairStringInitializer(string,strings, objects);
    }




    /**
     * Adds structures to multiBlock, each with specified stairs.
     */
    public static boolean addStructuresWithStairs(MultiBlock multiBlock, Block[] stairs, MultiBlock.StructureList structureList) {
        Boolean bool = true;
        for (Block stair : stairs) {
            bool = bool & multiBlock.addStructure(structureList, stairInitializer(stair));
        }
        return bool;
    }

    /**
     * Adds structures to multiBlock, each with specified stairs.
     */
    public static boolean addStructuresWithStairsString(MultiBlock multiBlock, Block[] stairs, String string, MultiBlock.StructureList structureList) {
        Boolean bool = true;
        for (Block stair : stairs) {
            bool = bool & multiBlock.addStructure(structureList, stairStringInitializer(string, stair));
        }
        return bool;
    }

    /**
     * Adds structures to multiBlock, each with specified stairs.
     */
    public static boolean addStructuresWithStairsShortString(MultiBlock multiBlock, Block[] stairs, String string, MultiBlock.StructureList structureList) {
        Boolean bool = true;
        for (Block stair : stairs) {
            bool = bool & multiBlock.addStructure(structureList, stairShortStringInitializer(string, stair));
        }
        return bool;
    }




    private static MultiBlock.StructureList stairStringInitializer(String string, String[] strings, Object... objects) {
        string = "#"+ (!string.isEmpty() ? string+"_" : "");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = string + strings[i];
        }
        return stairInitializer(strings, objects);
    }

    private static MultiBlock.StructureList stairInitializer(Object[] names, Object[] objects) {
        MultiBlock.StructureList stairList = new MultiBlock.StructureList();

        int[][] dirs = new int[][] {
                {StairComparator.NORTH},{StairComparator.SOUTH},{StairComparator.EAST},{StairComparator.WEST},
                StairComparator.NORTH_EAST,StairComparator.NORTH_WEST,StairComparator.SOUTH_EAST,StairComparator.SOUTH_WEST
        };

        for (int i = 0; i < Math.min(dirs.length, names.length); i++) {
            if (objects.length == 0) {
                stairList.add( names[i], new StairComparator().addDirections(dirs[i]));
            } else if (objects.length == 1) {
                stairList.add( names[i], new StairComparator(objects[0]).addDirections(dirs[i]));
            } else {
                stairList.add( names[i], new StairComparator(objects).addDirections(dirs[i]) );
            }
        }

        return stairList;
    }




    /**
     * Adds structures to multiBlock, each with specified stairs.
     */
    public static boolean addStructuresWithStairs(MultiBlock multiBlock, Block[] stairs, Object... objects) {
        return addStructuresWithStairs(multiBlock, stairs, MultiBlockUtil.structureList(objects));
    }

    /**
     * Adds structures to multiBlock, each with one of the vanilla stairs.
     */
    public static void addStructuresWithAllStairs(MultiBlock multiBlock, MultiBlock.StructureList structureList) {
        addStructuresWithStairs(multiBlock, VANILLA_STAIRS, structureList);
    }

    /**
     * Adds structures to multiBlock, each with one of the vanilla stairs.
     */
    public static void addStructuresWithAllStairs(MultiBlock multiBlock, Object... objects) {
        addStructuresWithStairs(multiBlock, VANILLA_STAIRS, MultiBlockUtil.structureList(objects));
    }

    /**
     * Adds structures to multiBlock, each with specified stairs.
     */
    public static boolean addStructuresWithStairsString(MultiBlock multiBlock, Block[] stairs, String string, Object... objects) {
        return addStructuresWithStairs(multiBlock, stairs, string, MultiBlockUtil.structureList(objects));
    }

    /**
     * Adds structures to multiBlock, each with one of the vanilla stairs.
     */
    public static void addStructuresWithAllStairsString(MultiBlock multiBlock, String string, MultiBlock.StructureList structureList) {
        addStructuresWithStairs(multiBlock, VANILLA_STAIRS, string, structureList);
    }

    /**
     * Adds structures to multiBlock, each with one of the vanilla stairs.
     */
    public static void addStructuresWithAllStairsString(MultiBlock multiBlock, String string, Object... objects) {
        addStructuresWithStairsString(multiBlock, VANILLA_STAIRS, string, MultiBlockUtil.structureList(objects));
    }

    /**
     * Adds structures to multiBlock, each with specified stairs.
     */
    public static boolean addStructuresWithStairsShortString(MultiBlock multiBlock, Block[] stairs, String string, Object... objects) {
        return addStructuresWithStairsShortString(multiBlock, stairs, string, MultiBlockUtil.structureList(objects));
    }

    /**
     * Adds structures to multiBlock, each with one of the vanilla stairs.
     */
    public static void addStructuresWithAllStairsShortString(MultiBlock multiBlock, String string, MultiBlock.StructureList structureList) {
        addStructuresWithStairsShortString(multiBlock, VANILLA_STAIRS, string, structureList);
    }

    /**
     * Adds structures to multiBlock, each with one of the vanilla stairs.
     */
    public static void addStructuresWithAllStairsShortString(MultiBlock multiBlock, String string, Object... objects) {
        addStructuresWithStairsShortString(multiBlock, VANILLA_STAIRS, string, MultiBlockUtil.structureList(objects));
    }

}