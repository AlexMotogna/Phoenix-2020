package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Control", group = "Control")

public class Control extends LinearOpMode implements OpModeAddition {

    Hardware robot = new Hardware();

    double left;
    double right;
    double speed;
    double direction;

    @Override
    public boolean isOpModeIsActive() { return opModeIsActive(); }

    

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){

            speed = gamepad1.right_trigger - gamepad1.left_trigger;
            direction = gamepad1.left_stick_x;

            right = speed - direction;
            left = speed + direction;

            if (right > 1)
                right = 1;
            if (right < -1)
                right = -1;
            if (left > 1)
                left = 1;
            if (left < -1)
                left = -1;

            robot.leftMotorBack.setPower(left);
            robot.leftMotorFront.setPower(left);
            robot.rightMotorBack.setPower(right);
            robot.rightMotorFront.setPower(right);


            telemetry.addData("Bumper1", gamepad1.left_bumper);
            telemetry.addData("Bumper2", gamepad1.right_bumper);
            telemetry.update();

        }

    }



}
