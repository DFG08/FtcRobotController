package org.firstinspires.ftc.teamcode;

public enum MoveDir {
    F(new int[]{1, -1, 1, -1}),
    B(new int[]{-1, 1, -1, 1}),
    R(new int[]{1, 1, -1, -1}),
    L(new int[]{-1, -1, 1, 1}),
    FL(new int[]{0, -1, 1, 0}),
    FR(new int[]{1, 0, 0, -1}),
    BL(new int[]{0, 1, -1, 0}),
    BR(new int[]{-1, 0, 0, 1}),
    rL(new int[]{-1, -1, -1, -1}),
    rR(new int[]{1, 1, 1, 1}),
    STOP(new int[]{0,0,0,0});

    final public int[] dir;

    MoveDir(int[] dir){
        this.dir = dir;
    }
}
