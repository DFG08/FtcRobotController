package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.ArrayList;
import java.util.List;

public class AutoMovement  {

    public List<AutoDir> memory = new ArrayList<AutoDir>();


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

    void move(AutoDir dir, boolean isRecord){
        float spd = 1;//이동 속도
        if(dir.direction == MoveDir.rR || dir.direction == MoveDir.rL) {
            spd = 0.5f;//회전 속도
        }
        if(isRecord){
            memory.add(dir);
        }
        for(int i = 0; i < 4; i++){
            motors[i].setPower(dir.direction.dir[i] * spd);
        }
    }
    void move(AutoDir dir){
        move(dir,false);
    }



    void reverse(){
        if(memory.isEmpty()) return;
        AutoDir dir = memory.remove(memory.size() - 1);
        move(dir);
    }
    void reverseAll() {
        while(!memory.isEmpty()){
            reverse();
        }
        return;
    }
}
