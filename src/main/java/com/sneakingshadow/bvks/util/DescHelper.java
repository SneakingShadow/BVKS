package com.sneakingshadow.bvks.util;

import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * Created by SneakingShadow on 15.01.2016.
 */
public class DescHelper {

    public static String getDescription(String name) {
        return StatCollector.translateToLocal("description.bvks:" + name);
    }

    public static String getDescriptionUnwrapped() {
        return "";
    }

    public static void writeToDescription(List list, String... strings) {

    }

}
