package sneakingshadow.bvks.util;

public class Position {

    public int x=0,y=0,z=0;

    public Position(int x, int y, int z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public Position turn(int i, int rx, int rz) {
        int temp;
        for (int j = 0; j < i; j++){
            temp = -this.z+rz;
            this.z = this.x-rx+rz;
            this.x = temp+rx;
        }
        return this;
    }
    public Position turn(int rx, int ry) {
        return turn(1,rx,ry);
    }
    public Position turn(int i) {
        return turn(i,0,0);
    }
    public Position turn() {
        return turn(1,0,0);
    }

}