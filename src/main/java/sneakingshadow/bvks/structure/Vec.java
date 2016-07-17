package sneakingshadow.bvks.structure;

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
     * @param vec point to rotate around
     * @param rot how many 90 degrees it should be rotated. Rot = 3 ==> 270 degrees.
     */
    public Vec rotateY(Vec vec, int rot) {

        int numX = this.x - vec.x;
        int numZ = this.z - vec.z;

        for (int i = 0; i < rot; i++) {
            int tx = numX;
            int tz = numZ;
            numX = tz;
            numZ = -tx;
        }

        numX += vec.x;
        numZ += vec.z;

        return new Vec(numX, y, numZ);
    }

    /**
     * (a1,b1,c1)
     * (a2,b2,c2)
     * rot = rotation in units of 90 degrees
     * */
    private int[] rotateC(int a1, int b1, int c1, int a2, int b2, int c2, int rot) {



    }

}
