package org.firstinspires.ftc.teamcode;

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


public class Movement extends OpMode {





    DcMotor lf;
    DcMotor rf;
    DcMotor lb;
    DcMotor rb;

    Gamepad pad;

    DcMotor[] motors = new DcMotor[4];


    @Override
    public void init() {
        lf = hardwareMap.get(DcMotor.class,"lf");
        rf = hardwareMap.get(DcMotor.class,"rf");
        lb = hardwareMap.get(DcMotor.class,"lb");
        rb = hardwareMap.get(DcMotor.class,"rb");
        motors = new DcMotor[]{lf,rf,lb,rb};
    }

    @Override
    public void loop() {
        move(0.7f,0.3f);
    }

    public void move(float moveSpeed, float rotateSpeed){

        if(moveSpeed + rotateSpeed > 1){
            //power 최대치 = 1, 1이상 구동 X, 따라서 최고 속도가 1 초과시 최고 속도를 1로 조정
            float moveTemp, rotateTemp;
            moveTemp = moveSpeed /(moveSpeed + rotateSpeed);
            rotateTemp = rotateSpeed / (moveSpeed + rotateSpeed);
            moveSpeed = moveTemp;
            rotateSpeed = rotateTemp;
        }
        float x =gamepad1.left_stick_x * moveSpeed;
        float y =-gamepad1.left_stick_y * moveSpeed;
        float r =gamepad1.right_stick_x * rotateSpeed;
        lf.setPower(x + y + r);
        rf.setPower(y - x - r);
        lb.setPower(y - x + r);
        rb.setPower(x + y - r);
    }

}
