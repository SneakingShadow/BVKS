package sneakingshadow.bvks.init;

import sneakingshadow.bvks.structure.MultiBlock;

import java.util.ArrayList;

public class ModMultiBlocks {

    public static void init() {

    }

    private static ArrayList<MultiBlock> multiBlocks = new ArrayList<MultiBlock>();

    public static void register(MultiBlock multiBlock) {
        multiBlocks.add(multiBlock.setID(multiBlocks.size()));
    }

    public static MultiBlock getMultiblock(int ID) {
        if (ID >= multiBlocks.size()) {
            return null;
        }
        return multiBlocks.get(ID);
    }

    public static boolean hasMultiBlockID(int ID) {
        return ID != -1 && ID < multiBlocks.size();
    }

}
