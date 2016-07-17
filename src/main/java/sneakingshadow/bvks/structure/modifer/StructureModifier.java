package sneakingshadow.bvks.structure.modifer;

import sneakingshadow.bvks.structure.MultiBlockInit;
import sneakingshadow.bvks.structure.Vec;

import java.util.HashMap;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public abstract class StructureModifier {

    public abstract boolean structureMod(MultiBlockInit.ObjectArray multiBlock, Vec vec, Object object);

    public int skipObjects(int i, Object[] objects, HashMap<Character, Object> hashMap) {
        return 0;
    }
}
