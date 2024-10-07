package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MoveTest")
public class MoveTest extends OpMode {

    Movement movement;
    DcMotor lf,rf,lb,rb;

    @Override
    public void init() {
        lf = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");

        movement = new Movement(lf,rf,lb,rb,gamepad1);
    }

    @Override
    public void loop() {
        movement.move(7,3);
    }
}
