package sneakingshadow.bvks.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDebugBlock extends TileEntity {

    private final String tagPlayerList = "players";

    public NBTTagList players = new NBTTagList();

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        this.players = nbtTagCompound.getTagList(tagPlayerList, 8);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setTag(tagPlayerList, players);
    }

    public void addPlayer(String player){
        this.players.appendTag(new NBTTagString(player));
    }

    public boolean hasPlayer(String player){
        for(int i = 0; i < this.players.tagCount(); i++){
            if(this.players.getStringTagAt(i).equals(player))
                return true;
        }
        return false;
    }
}
