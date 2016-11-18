package com.sneakingshadow.bvks.world.gen;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import com.sneakingshadow.bvks.init.ModBlocks;

import java.util.Random;

public class WorldGenDevilOre implements IWorldGenerator{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
            case -1:
                //Nether
                generateNether(world, random, chunkX, chunkZ);
            case 0:
                //Overworld
                generateSurface(world, random, chunkX, chunkZ);

        }
    }

    public void generateNether(World world, Random random, int chunkX, int chunkZ){

        for(int i = 1; i <= 2; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = random.nextInt(127) + 1;
            int z = chunkZ * 16 + random.nextInt(16);

            float rand = random.nextFloat();

            if ( rand <= 0.10000000F && (world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z, Blocks.netherrack) || world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z, Blocks.nether_brick) || world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z, Blocks.gravel)) )
            {
                world.setBlock(x, y, z, ModBlocks.DevilOre, 0, 2);
            }
        }

    }

    public void generateSurface(World world, Random random, int chunkX, int chunkZ){

        int x = chunkX * 16 + random.nextInt(16);
        int y = random.nextInt(9) + 1;
        int z = chunkZ * 16 + random.nextInt(16);

        float rand = random.nextFloat();

        if ( rand <= 0.05000000F && (world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z, Blocks.stone) || world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z, Blocks.dirt) || world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z, Blocks.gravel)) )
        {
            world.setBlock(x, y, z, ModBlocks.DevilOre, 0, 2);
        }

    }
}