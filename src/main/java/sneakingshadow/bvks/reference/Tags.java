package sneakingshadow.bvks.reference;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Tags {

    public static final class Storage
    {
        public static final String STORED_AMOUNT = "stored";
        public static final String ID = "ID";
        public static final String NAME = "NAME";
        public static final String META = "META";
        public static final String STACK_TAG = "stack";
        public static final String STACK_TAG_NULL = "stackNull";
        public static final String MAX_STACK_SIZE = "MAX_STACK_SIZE";
    }





    public static void setTags(ItemStack itemStack){
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());
        setTags(itemStack.stackTagCompound);
    }

    public static void setTags(NBTTagCompound stackTagCompound){
        if (!stackTagCompound.hasKey(Ref.MOD_ID, 10))
            stackTagCompound.setTag(Ref.MOD_ID, new NBTTagCompound());
    }

    public static void clearTags(ItemStack itemStack){ //Only clears bvks tags
        itemStack.setTagCompound(null);
    }

    public static void clearBVKSTags(ItemStack itemStack){ //Only clears bvks tags
        itemStack.stackTagCompound.setTag(Ref.MOD_ID, new NBTTagCompound());
    }
}
