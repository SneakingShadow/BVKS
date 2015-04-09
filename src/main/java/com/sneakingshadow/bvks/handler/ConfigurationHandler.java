package com.sneakingshadow.bvks.handler;

import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Ref;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean testValue = false;
    public static int DPickaxeHarvestLevel, DSwordHarvestLevel, DAxeHarvestLevel, DShovelHarvestLevel, DPickaxeMaxUses, DSwordMaxUses, DAxeMaxUses, DShovelMaxUses, DPickaxeEnchantability, DSwordEnchantability, DAxeEnchantability, DShovelEnchantability; public static float DPickaxeEfficiency, DSwordEfficiency, DAxeEfficiency, DShovelEfficiency, DPickaxeDamage, DSwordDamage, DAxeDamage, DShovelDamage;
    public static int OPickaxeHarvestLevel, OSwordHarvestLevel, OAxeHarvestLevel, OShovelHarvestLevel, OPickaxeMaxUses, OSwordMaxUses, OAxeMaxUses, OShovelMaxUses, OPickaxeEnchantability, OSwordEnchantability, OAxeEnchantability, OShovelEnchantability; public static float OPickaxeEfficiency, OSwordEfficiency, OAxeEfficiency, OShovelEfficiency, OPickaxeDamage, OSwordDamage, OAxeDamage, OShovelDamage;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if ( configuration == null )
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if ( event.modID.equalsIgnoreCase(Ref.MOD_ID) )
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, true, "Testing value");

        DPickaxeHarvestLevel = configuration.getInt("Devil Pickaxe Harvest Level", Names.Configuration.DevilTools, 100, 1, 2^31-1, ""); DSwordHarvestLevel = configuration.getInt("Devil Sword Harvest Level", Names.Configuration.DevilTools, 100, 1, 1000000, ""); DAxeHarvestLevel = configuration.getInt("Devil Axe Harvest Level", Names.Configuration.DevilTools, 100, 1, 1000000, ""); DShovelHarvestLevel = configuration.getInt("Devil Shovel Harvest Level", Names.Configuration.DevilTools, 100, 1, 1000000, ""); DPickaxeMaxUses = configuration.getInt("Devil Pickaxe Harvest Level", Names.Configuration.DevilTools, 100, 1, 2^15-1, ""); DSwordMaxUses = configuration.getInt("Devil Sword Harvest Level", Names.Configuration.DevilTools, 100, 1, 1000000, ""); DAxeMaxUses = configuration.getInt("Devil Axe Harvest Level", Names.Configuration.DevilTools, 100, 1, 1000000, ""); DShovelMaxUses = configuration.getInt("Devil Shovel Harvest Level", Names.Configuration.DevilTools, 100, 1, 1000000, ""); DPickaxeEfficiency = configuration.getFloat("Devil Pickaxe Efficiency", Names.Configuration.DevilTools, 100000F, 1F, 2^31-1, ""); DSwordEfficiency = configuration.getFloat("Devil Sword Efficiency", Names.Configuration.DevilTools, 100000F, 1F, 2^31-1, ""); DAxeEfficiency = configuration.getFloat("Devil Axe Efficiency", Names.Configuration.DevilTools, 100000F, 1F, 2^31-1, ""); DShovelEfficiency = configuration.getFloat("Devil Shovel Efficiency", Names.Configuration.DevilTools, 100000F, 1F, 2^31-1, ""); DPickaxeDamage = configuration.getFloat("Devil Pickaxe Damage", Names.Configuration.DevilTools, 100000F, 1F, 2^31-1, ""); DSwordDamage = configuration.getFloat("Devil Sword Damage", Names.Configuration.DevilTools, 100000F, 1F, 2^31-1, ""); DAxeDamage = configuration.getFloat("Devil Axe Damage", Names.Configuration.DevilTools, 100000F, 1F, 2^31-1, ""); DShovelDamage = configuration.getFloat("Devil Shovel Damage", Names.Configuration.DevilTools, 100000F, 1F, 2^31-1, ""); DPickaxeEnchantability = configuration.getInt("Devil Pickaxe Harvest Level", Names.Configuration.DevilTools, 100, 1, 2^31-1, ""); DSwordEnchantability = configuration.getInt("Devil Sword Harvest Level", Names.Configuration.DevilTools, 100, 1, 2^31-1, ""); DAxeEnchantability = configuration.getInt("Devil Axe Harvest Level", Names.Configuration.DevilTools, 100, 1, 2^31-1, ""); DShovelEnchantability = configuration.getInt("Devil Shovel Harvest Level", Names.Configuration.DevilTools, 100, 1, 2^31-1, "");
        OPickaxeHarvestLevel = configuration.getInt("Obsidian Pickaxe Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 2^31-1, ""); OSwordHarvestLevel = configuration.getInt("Obsidian Sword Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 1000000, ""); OAxeHarvestLevel = configuration.getInt("Obsidian Axe Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 1000000, ""); OShovelHarvestLevel = configuration.getInt("Obsidian Shovel Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 1000000, ""); OPickaxeMaxUses = configuration.getInt("Obsidian Pickaxe Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 2^15-1, ""); OSwordMaxUses = configuration.getInt("Obsidian Sword Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 1000000, ""); OAxeMaxUses = configuration.getInt("Obsidian Axe Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 1000000, ""); OShovelMaxUses = configuration.getInt("Obsidian Shovel Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 1000000, ""); OPickaxeEfficiency = configuration.getFloat("Obsidian Pickaxe Efficiency", Names.Configuration.ObsidianTools, 100000F, 1F, 2^31-1, ""); OSwordEfficiency = configuration.getFloat("Obsidian Sword Efficiency", Names.Configuration.ObsidianTools, 100000F, 1F, 2^31-1, ""); OAxeEfficiency = configuration.getFloat("Obsidian Axe Efficiency", Names.Configuration.ObsidianTools, 100000F, 1F, 2^31-1, ""); OShovelEfficiency = configuration.getFloat("Obsidian Shovel Efficiency", Names.Configuration.ObsidianTools, 100000F, 1F, 2^31-1, ""); OPickaxeDamage = configuration.getFloat("Obsidian Pickaxe Damage", Names.Configuration.ObsidianTools, 100000F, 1F, 2^31-1, ""); OSwordDamage = configuration.getFloat("Obsidian Sword Damage", Names.Configuration.ObsidianTools, 100000F, 1F, 2^31-1, ""); OAxeDamage = configuration.getFloat("Obsidian Axe Damage", Names.Configuration.ObsidianTools, 100000F, 1F, 2^31-1, ""); OShovelDamage = configuration.getFloat("Obsidian Shovel Damage", Names.Configuration.ObsidianTools, 100000F, 1F, 2^31-1, ""); OPickaxeEnchantability = configuration.getInt("Obsidian Pickaxe Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 2^31-1, ""); OSwordEnchantability = configuration.getInt("Obsidian Sword Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 2^31-1, ""); OAxeEnchantability = configuration.getInt("Obsidian Axe Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 2^31-1, ""); OShovelEnchantability = configuration.getInt("Obsidian Shovel Harvest Level", Names.Configuration.ObsidianTools, 100, 1, 2^31-1, "");

        if(configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
