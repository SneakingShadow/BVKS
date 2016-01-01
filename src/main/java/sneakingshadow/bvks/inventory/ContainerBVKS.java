package sneakingshadow.bvks.inventory;

import net.minecraft.inventory.Container;

/**
 * Created by SneakingShadow on 21.12.2015.
 */
public abstract class ContainerBVKS extends Container {

    private int ID;

    public void setID(int id){
        this.ID = id;
    }

    public int getID(){
        return ID;
    }

}
