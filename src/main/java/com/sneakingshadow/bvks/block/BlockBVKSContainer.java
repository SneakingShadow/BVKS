package com.sneakingshadow.bvks.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import com.sneakingshadow.bvks.reference.Reference;

public abstract class BlockBVKSContainer extends BlockBVKS implements ITileEntityProvider{

    public BlockBVKSContainer(String unlocalizedName, Material material){
        super(unlocalizedName, material);
        this.isBlockContainer = true;
    }

    public BlockBVKSContainer(String unlocalizedName){
        this(unlocalizedName, Material.rock);
    }

    public BlockBVKSContainer setTileEntity(Class tileEntity, String name){
        TileEntity.addMapping(tileEntity, Reference.RESOURCE_PREFIX + name);
        return this;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param world
     * @param metadata
     */
    @Override
    abstract public TileEntity createNewTileEntity(World world, int metadata);
}
