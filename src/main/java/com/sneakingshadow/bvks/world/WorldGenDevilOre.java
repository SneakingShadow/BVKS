package com.sneakingshadow.bvks.world;

import com.sneakingshadow.bvks.init.ModBlocks;
import com.sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenDevilOre implements IWorldGenerator{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
            case -1:
                //Nether
                generateNether(world, random, chunkX, chunkZ);
                break;
            case 0:
                //Overworld
                generateSurface(world, random, chunkX, chunkZ);
                break;

        }
    }

    public void generateNether(World world, Random random, int chunkX, int chunkZ){

        for(int i = 1; i <= 4; i++){
            int randPosX = chunkX*16 + random.nextInt(16);
            int randPosY = random.nextInt(127)+1;
            int randPosZ = chunkZ*16 + random.nextInt(16);

            new WorldGenMinable(ModBlocks.DevilOre, random.nextInt(2)+1, Blocks.netherrack).generate(world, random, randPosX, randPosY, randPosZ);
        }

    }

    public void generateSurface(World world, Random random, int chunkX, int chunkZ){

        int randPosX = chunkX*16 + random.nextInt(16);
        int randPosY = random.nextInt(25)+1;
        int randPosZ = chunkZ*16 + random.nextInt(16);

        new WorldGenMinable(ModBlocks.DevilOre, 1).generate(world, random, randPosX, randPosY, randPosZ);

    }
}