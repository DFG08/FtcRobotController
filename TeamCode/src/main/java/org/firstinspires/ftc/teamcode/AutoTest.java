package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

@Autonomous(name = "AutoTest")
public class AutoTest extends LinearOpMode {

    AutoMovement movement = new AutoMovement();
    boolean runF = true;


    @Override
    public void runOpMode() {
        waitForStart();
        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                // OpMode loop
                if(runF){
                    movement.move(new AutoDir(1,MoveDir.F));
                    movement.move(new AutoDir(1,MoveDir.R));
                    movement.move(new AutoDir(1,MoveDir.B));
                    movement.move(new AutoDir(1,MoveDir.L));
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    movement.move(new AutoDir(1,MoveDir.FR));
                    movement.move(new AutoDir(1,MoveDir.FL));
                    movement.move(new AutoDir(1,MoveDir.BL));
                    movement.move(new AutoDir(1,MoveDir.BR));
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    movement.move(new AutoDir(1,MoveDir.rR));
                    movement.move(new AutoDir(1,MoveDir.rL));

                    runF = false;
                }
            }
        }
    }
}
