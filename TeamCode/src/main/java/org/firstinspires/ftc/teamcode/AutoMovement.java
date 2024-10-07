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
    DcMotor[] motors;

    public AutoMovement(DcMotor lf,DcMotor rf,DcMotor lb,DcMotor rb) {
        this.lf = lf;
        this.rf = rf;
        this.lb = lb;
        this.rb = rb;
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
        try{
            double t = dir.time * 1000;
            Thread.sleep((long)t);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    void move(AutoDir dir){
        move(dir,false);
    }



    void reverse(){
        if(memory.isEmpty()) return;
        AutoDir dir = memory.remove(memory.size() - 1);

        move(new AutoDir(dir.time,getBackDir(dir.direction)));
    }

    MoveDir getBackDir(MoveDir dir){
        MoveDir output;
        switch (dir){
            case B:
                output =  MoveDir.F;
                break;
            case F:
                output =   MoveDir.B;
                break;
            case L:
                output =  MoveDir.R;
                break;
            case R:
                output =  MoveDir.L;
            case BL:
                output =  MoveDir.FR;
                break;
            case FL:
                output =   MoveDir.BR;
                break;
            case FR:
                output =  MoveDir.BL;
                break;
            case BR:
                output =  MoveDir.FL;
                break;
            case rL:
                output =  MoveDir.rR;
                break;
            case rR:
                output =  MoveDir.rL;
                break;
            default:
                output =  MoveDir.STOP;
                break;
        }
        return output;
    }

    void reverseAll() {
        while(!memory.isEmpty()){
            reverse();
        }
        return;
    }
}
