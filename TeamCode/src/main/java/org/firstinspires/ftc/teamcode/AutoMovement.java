package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.ArrayList;
import java.util.List;

@Autonomous(name = "AutoMovement")
public class AutoMovement extends LinearOpMode {

    public List<MoveDir> memory = new ArrayList<MoveDir>();

    DcMotor lf;
    DcMotor rf;
    DcMotor lb;
    DcMotor rb;
    DcMotor[] motors = new DcMotor[4];

    @Override
    public void runOpMode() {
        waitForStart();
        if (opModeIsActive()) {
            lf = hardwareMap.get(DcMotor.class,"lf");
            rf = hardwareMap.get(DcMotor.class,"rf");
            lb = hardwareMap.get(DcMotor.class,"lb");
            rb = hardwareMap.get(DcMotor.class,"rb");
            motors = new DcMotor[]{lf,rf,lb,rb};
            while (opModeIsActive()) {

            }
        }
    }

    void move(MoveDir dir){
        for(int i = 0; i < 4; i++){
            motors[i].setPower(dir.dir[i]);
        }
        memory.add(dir);
    }
    void move(MoveDir dir, boolean isRecord){
        for(int i = 0; i < 4; i++){
            motors[i].setPower(dir.dir[i]);
        }
        if(isRecord){
            memory.add(dir);
        }
    }

    void reverse(){
        if(memory.isEmpty()) return;
        MoveDir dir = memory.remove(memory.size() - 1);
        move(dir,false);
    }
    void reverseAll() {
        while(!memory.isEmpty()){
            reverse();
        }
        return;
    }
}
