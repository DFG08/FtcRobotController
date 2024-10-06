package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

@TeleOp(name = "MoveTest")
public class MoveTest extends OpMode {

    Movement movement = new Movement();

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        movement.move(7,3);
    }
}
