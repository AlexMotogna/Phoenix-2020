package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.Arrays;

@TeleOp(name = "NewControl", group = "TestControlSwitch")

public class NewControl extends LinearOpMode implements OpModeAddition{

    Hardware robot = new Hardware();

    double left;
    double right;
    double speed;
    double direction;
    int in_ce_directie = 1;

    boolean switch_gamepad2_to_gamepad1 = false;
    boolean switch_gamepad1_to_gamepad2 = false;
    boolean change_gamepad1_with_gamepad2 = false;

    @Override
    public boolean isOpModeIsActive() {
        return opModeIsActive();
    }

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

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

            if (gamepad1.right_stick_x != 0) {

                robot.leftMotorBack.setPower(-gamepad1.right_stick_x);
                robot.leftMotorFront.setPower(gamepad1.right_stick_x);
                robot.rightMotorBack.setPower(gamepad1.right_stick_x);
                robot.rightMotorFront.setPower(-gamepad1.right_stick_x);

            } else {
                robot.leftMotorBack.setPower(left);
                robot.leftMotorFront.setPower(left);
                robot.rightMotorBack.setPower(right);
                robot.rightMotorFront.setPower(right);
            }

            // catch servo1 - Y
            if (gamepad1.y) {
                robot.servo1.setPosition(1 - 0.1);
            }
            if (gamepad1.x) {
                robot.servo1.setPosition(0);
            }

            // catch servo2 - B
            if (gamepad1.b) {
                robot.servo2.setPosition(0.29);
            }
            if (gamepad1.a) {
                robot.servo2.setPosition(1);
            }

            if (gamepad2.right_bumper)
                robot.servo_arm.setPosition(0.7);
            if (gamepad2.left_bumper)
                robot.servo_arm.setPosition(0);

            robot.extensionMotor.setPower(gamepad2.right_stick_y);

            if (gamepad2.dpad_up) {
                robot.liftMotor.setPower(1);
            } else if (gamepad2.dpad_down) {
                robot.liftMotor.setPower(-1);
            } else {
                robot.liftMotor.setPower(0);
            }



            telemetry.addData("leftBack", robot.leftMotorBack.getCurrentPosition());
            telemetry.addData("leftFront", robot.leftMotorFront.getCurrentPosition());
            telemetry.addData("rightBack", robot.rightMotorBack.getCurrentPosition());
            telemetry.addData("rightFront", robot.rightMotorFront.getCurrentPosition());

            telemetry.addData("Bumper1", gamepad1.left_trigger);
            telemetry.addData("Bumper2", gamepad1.right_trigger);
            telemetry.addData("right", right);
            telemetry.addData("left", left);

            telemetry.update();

        }

    }

}

