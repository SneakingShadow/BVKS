package sneakingshadow.bvks.init;

import sneakingshadow.bvks.block.MultiBlock.MultiBlockStructure;

import java.util.ArrayList;

public class ModMultiBlocks {

    public static MultiBlockStructure demonAltar = new MultiBlockStructure(3, 1, 4,
            'a', 'a', 'a',
            'a', 'a', 'a',
            'a', 'a', 'a',
            'a', 'a', 'a',
            ModBlocks.DemonAltar, 'a'
    );

    public static void init(){
        registerMultiBlock(demonAltar);
    }



    private static ArrayList<MultiBlockStructure>  multiBlockList = new ArrayList<MultiBlockStructure>();
    public static void registerMultiBlock(MultiBlockStructure multiBlock) {
        multiBlock.setID(multiBlockList.size());
        multiBlockList.add(multiBlock);
    }

    public static MultiBlockStructure getMultiBlock(int ID) {
        return multiBlockList.get(ID);
    }

}
