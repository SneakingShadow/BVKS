package com.sneakingshadow.bvks.structure;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public class Vec {

    public int x;
    public int y;
    public int z;

    public Vec(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Rotate around x-axis
     * @param vec point to rotate around
     * @param rot how many 90 degrees it should be rotated. Rot = 3 ==> 270 degrees.
     */
    public Vec rotateX(Vec vec, int rot) {
        int[] ints = rotate(vec.y, vec.z, this.y, this.z, rot);
        return new Vec(this.x, ints[0], ints[1]);
    }

    /**
     * Rotate around y-axis
     * @param vec point to rotate around
     * @param rot how many 90 degrees it should be rotated. Rot = 3 ==> 270 degrees.
     */
    public Vec rotateY(Vec vec, int rot) {
        int[] ints = rotate(vec.x, vec.z, this.x, this.z, rot);
        return new Vec(ints[0], this.y, ints[1]);
    }

    /**
     * Rotate around z-axis
     * @param vec point to rotate around
     * @param rot how many 90 degrees it should be rotated. Rot = 3 ==> 270 degrees.
     */
    public Vec rotateZ(Vec vec, int rot) {
        int[] ints = rotate(vec.x, vec.y, this.x, this.y, rot);
        return new Vec(ints[0], ints[1], this.z);
    }

    /**
     * (a1,b1) center
     * (a2,b2) rotating point
     * rot = rotationY in units of 90 degrees
     * */
    private int[] rotate(int a1, int b1, int a2, int b2, int rot) {
        int numA = a2-a1;
        int numB = b2-b1;

        for (int i = 0; i < rot; i++) {
            int ta = numA;
            int tb = numB;
            numA = tb;
            numB = -ta;
        }

        return new int[] {numA + a1, numB + b1};
    }

}
