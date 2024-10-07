package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "AutoTest")
public class AutoTest extends LinearOpMode {

    boolean runF = true;

    DcMotor lf,rf,lb,rb;
    @Override
    public void runOpMode() {
        waitForStart();
        if (opModeIsActive()) {
            // Pre-run
            lf = hardwareMap.get(DcMotor.class, "lf");
            rf = hardwareMap.get(DcMotor.class, "rf");
            lb = hardwareMap.get(DcMotor.class, "lb");
            rb = hardwareMap.get(DcMotor.class, "rb");

            AutoMovement movement = new AutoMovement(lf,rf,lb,rb);

            while (opModeIsActive()) {
                // OpMode loop
                if(runF){
                    runF = false;
                    movement.move(new AutoDir(0.5,MoveDir.STOP),true);
                    movement.move(new AutoDir(2,MoveDir.F),true);
                    movement.move(new AutoDir(0.1,MoveDir.STOP),true);


                    // movement.move(new AutoDir(0.5,MoveDir.STOP),true);
                    // movement.reverseAll();
                }
            }
        }
    }
}
