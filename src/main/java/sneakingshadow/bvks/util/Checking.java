package sneakingshadow.bvks.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class Checking {


    private void block(World world, int x, int y, int z)
    {

        Object object = "logWood";
        Block block = world.getBlock(x,y,z);
        int metadata = world.getBlockMetadata(x,y,z);;

        if ((object == null)) {
            LogHelper.info("object == null: " + (block == Blocks.air));
        }else if (object instanceof Item) {
            LogHelper.info("object instanceof Item: " + (Item.getItemFromBlock(block) == object));
        }else if (object instanceof ItemStack) {
            ItemStack objectStack = (ItemStack)object;
            LogHelper.info("object instanceof ItemStack: " + (objectStack.getItem() == Item.getItemFromBlock(block) && objectStack.getItemDamage() == metadata));
        }else if (object instanceof Block) {
            LogHelper.info("object instanceof Block: " + (object == block));
        }else if (object instanceof String) {
            boolean bool = false;
            for (ItemStack objectStack : OreDictionary.getOres((String)object)) {
                bool = bool || (objectStack.getItem() == Item.getItemFromBlock(block) && (objectStack.getItemDamage() == metadata || objectStack.getItemDamage() == OreDictionary.WILDCARD_VALUE));
            }
            LogHelper.info("object instanceof String: " + bool);
        }
    }


}
