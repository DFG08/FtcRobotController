package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;
import java.util.Set;


public class Movement {
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


    public void move(float mSpd, float rSpd){

        if(mSpd + rSpd > 1){
            //power 최대치 = 1, 1이상 구동 X, 따라서 최고 속도가 1 초과시 최고 속도를 1로 조정
            float moveTemp, rotateTemp;
            moveTemp = mSpd /(mSpd + rSpd);
            rotateTemp = rSpd / (mSpd + rSpd);
            mSpd = moveTemp;
            rSpd = rotateTemp;
        }
        if(gamepad1.right_stick_x == 0){
            mSpd = 1;
        }else if(gamepad1.left_stick_x == 0 && gamepad1.left_stick_y == 0){
            rSpd = 0.5f;
        }

        float x = gamepad1.left_stick_x * mSpd;
        float y = -gamepad1.left_stick_y * mSpd;
        float r = gamepad1.right_stick_x * rSpd;
        lf.setPower(x + y + r);
        rf.setPower(y - x - r);
        lb.setPower(y - x + r);
        rb.setPower(x + y - r);
    }

}
