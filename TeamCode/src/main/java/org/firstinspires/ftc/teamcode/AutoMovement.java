package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.ArrayList;
import java.util.List;

public class AutoMovement  {

    public List<MoveDir> memory = new ArrayList<MoveDir>();


    DcMotor lf;
    DcMotor rf;
    DcMotor lb;
    DcMotor rb;
    DcMotor[] motors = new DcMotor[4];

    public void init() {
        lf = hardwareMap.get(DcMotor.class,"lf");
        rf = hardwareMap.get(DcMotor.class,"rf");
        lb = hardwareMap.get(DcMotor.class,"lb");
        rb = hardwareMap.get(DcMotor.class,"rb");
        motors = new DcMotor[]{lf,rf,lb,rb};

    }

    void move(MoveDir dir, boolean isRecord){
        float spd = 1;//이동 속도
        if(dir == MoveDir.rR || dir == MoveDir.rL) {
            spd = 0.5f;//회전 속도
        }
        if(isRecord){
            memory.add(dir);
        }
        for(int i = 0; i < 4; i++){
            motors[i].setPower(dir.dir[i] * spd);
        }
    }
    void move(MoveDir dir){
        move(dir,false);
    }



    void reverse(){
        if(memory.isEmpty()) return;
        MoveDir dir = memory.remove(memory.size() - 1);
        move(dir);
    }
    void reverseAll() {
        while(!memory.isEmpty()){
            reverse();
        }
        return;
    }
}
