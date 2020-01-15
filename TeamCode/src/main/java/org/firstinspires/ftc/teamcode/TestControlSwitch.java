package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.Arrays;

@TeleOp(name = "TestControlSwitch", group = "TestControlSwitch")

public class TestControlSwitch extends LinearOpMode implements OpModeAddition{

    Hardware robot = new Hardware();

    double left;
    double right;
    double speed;
    double direction;

    boolean switch_gamepad2_to_gamepad1 = false;
    boolean switch_gamepad1_to_gamepad2 = false;
    boolean change_gamepad1_with_gamepad2 = false;

    float gamepad1RT;
    float gamepad1LT;
    boolean gamepad1RB;
    boolean gamepad1LB;
    boolean gamepad1A;
    boolean gamepad1B;
    boolean gamepad1X;
    boolean gamepad1Y;
    boolean gamepad1DPAD_UP;
    boolean gamepad1DPAD_DOWN;
    boolean gamepad1DPAD_LEFT;
    boolean gamepad1DPAD_RIGHT;
    float gamepad1R_STICK_X;
    float gamepad1R_STICK_Y;
    float gamepad1L_STICK_X;
    float gamepad1L_STICK_Y;

    float gamepad2RT;
    float gamepad2LT;
    boolean gamepad2RB;
    boolean gamepad2LB;
    boolean gamepad2A;
    boolean gamepad2B;
    boolean gamepad2X;
    boolean gamepad2Y;
    boolean gamepad2DPAD_UP;
    boolean gamepad2DPAD_DOWN;
    boolean gamepad2DPAD_LEFT;
    boolean gamepad2DPAD_RIGHT;
    float gamepad2R_STICK_X;
    float gamepad2R_STICK_Y;
    float gamepad2L_STICK_X;
    float gamepad2L_STICK_Y;

    @Override
    public boolean isOpModeIsActive() {
        return opModeIsActive();
    }

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            if (!change_gamepad1_with_gamepad2) {
                gamepad1RT = gamepad1.right_trigger;
                gamepad1LT = gamepad1.left_trigger;
                gamepad1RB = gamepad1.right_bumper;
                gamepad1LB = gamepad1.left_bumper;
                gamepad1A = gamepad1.a;
                gamepad1B = gamepad1.b;
                gamepad1X = gamepad1.x;
                gamepad1Y = gamepad1.y;
                gamepad1DPAD_UP = gamepad1.dpad_up;
                gamepad1DPAD_DOWN = gamepad1.dpad_down;
                gamepad1DPAD_LEFT = gamepad1.dpad_left;
                gamepad1DPAD_RIGHT = gamepad1.dpad_right;
                gamepad1R_STICK_X = gamepad1.right_stick_x;
                gamepad1R_STICK_Y = gamepad1.right_stick_y;
                gamepad1L_STICK_X = gamepad1.left_stick_x;
                gamepad1L_STICK_Y = gamepad1.left_stick_y;

                gamepad2RT = gamepad2.right_trigger;
                gamepad2LT = gamepad2.left_trigger;
                gamepad2RB = gamepad2.right_bumper;
                gamepad2LB = gamepad2.left_bumper;
                gamepad2A = gamepad2.a;
                gamepad2B = gamepad2.b;
                gamepad2X = gamepad2.x;
                gamepad2Y = gamepad2.y;
                gamepad2DPAD_UP = gamepad2.dpad_up;
                gamepad2DPAD_DOWN = gamepad2.dpad_down;
                gamepad2DPAD_LEFT = gamepad2.dpad_left;
                gamepad2DPAD_RIGHT = gamepad2.dpad_right;
                gamepad2R_STICK_X = gamepad2.right_stick_x;
                gamepad2R_STICK_Y = gamepad2.right_stick_y;
                gamepad2L_STICK_X = gamepad2.left_stick_x;
                gamepad2L_STICK_Y = gamepad2.left_stick_y;
            }
            else{
                gamepad1RT = gamepad2.right_trigger;
                gamepad1LT = gamepad2.left_trigger;
                gamepad1RB = gamepad2.right_bumper;
                gamepad1LB = gamepad2.left_bumper;
                gamepad1A = gamepad2.a;
                gamepad1B = gamepad2.b;
                gamepad1X = gamepad2.x;
                gamepad1Y = gamepad2.y;
                gamepad1DPAD_UP = gamepad2.dpad_up;
                gamepad1DPAD_DOWN = gamepad2.dpad_down;
                gamepad1DPAD_LEFT = gamepad2.dpad_left;
                gamepad1DPAD_RIGHT = gamepad2.dpad_right;
                gamepad1R_STICK_X = gamepad2.right_stick_x;
                gamepad1R_STICK_Y = gamepad2.right_stick_y;
                gamepad1L_STICK_X = gamepad2.left_stick_x;
                gamepad1L_STICK_Y = gamepad2.left_stick_y;

                gamepad2RT = gamepad1.right_trigger;
                gamepad2LT = gamepad1.left_trigger;
                gamepad2RB = gamepad1.right_bumper;
                gamepad2LB = gamepad1.left_bumper;
                gamepad2A = gamepad1.a;
                gamepad2B = gamepad1.b;
                gamepad2X = gamepad1.x;
                gamepad2Y = gamepad1.y;
                gamepad2DPAD_UP = gamepad1.dpad_up;
                gamepad2DPAD_DOWN = gamepad1.dpad_down;
                gamepad2DPAD_LEFT = gamepad1.dpad_left;
                gamepad2DPAD_RIGHT = gamepad1.dpad_right;
                gamepad2R_STICK_X = gamepad1.right_stick_x;
                gamepad2R_STICK_Y = gamepad1.right_stick_y;
                gamepad2L_STICK_X = gamepad1.left_stick_x;
                gamepad2L_STICK_Y = gamepad1.left_stick_y;
            }

            if ((gamepad2RT > 0 && gamepad2LT > 0 && gamepad2A) || (gamepad1RB && gamepad1LB && gamepad1DPAD_RIGHT))
                switch_gamepad2_to_gamepad1 = !switch_gamepad2_to_gamepad1;

            if (gamepad1RB && gamepad1LB && gamepad1DPAD_LEFT)
                switch_gamepad1_to_gamepad2 = !switch_gamepad1_to_gamepad2;

            if (gamepad1DPAD_LEFT && gamepad2DPAD_LEFT)
                change_gamepad1_with_gamepad2 = !change_gamepad1_with_gamepad2;

            if (switch_gamepad1_to_gamepad2 ) {
                speed = gamepad2RT - gamepad2LT;
                direction = gamepad2L_STICK_X;

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

                if (gamepad2R_STICK_X != 0) {

                    robot.leftMotorBack.setPower(-gamepad2R_STICK_X);
                    robot.leftMotorFront.setPower(gamepad2R_STICK_X);
                    robot.rightMotorBack.setPower(gamepad2R_STICK_X);
                    robot.rightMotorFront.setPower(-gamepad2R_STICK_X);

                } else {
                    robot.leftMotorBack.setPower(left);
                    robot.leftMotorFront.setPower(left);
                    robot.rightMotorBack.setPower(right);
                    robot.rightMotorFront.setPower(right);
                }

                if (gamepad2Y)
                    robot.servo1.setPosition(1 - 0.1);
                if (gamepad2X)
                    robot.servo1.setPosition(0);

                if (gamepad2B)
                    robot.servo2.setPosition(0.29);
                if (gamepad2A)
                    robot.servo2.setPosition(1);
            }
            else {
                speed = gamepad1RT - gamepad1LT;
                direction = gamepad1L_STICK_X;

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

                if (gamepad1R_STICK_X != 0) {

                    robot.leftMotorBack.setPower(-gamepad1R_STICK_X);
                    robot.leftMotorFront.setPower(gamepad1R_STICK_X);
                    robot.rightMotorBack.setPower(gamepad1R_STICK_X);
                    robot.rightMotorFront.setPower(-gamepad1R_STICK_X);

                } else {
                    robot.leftMotorBack.setPower(left);
                    robot.leftMotorFront.setPower(left);
                    robot.rightMotorBack.setPower(right);
                    robot.rightMotorFront.setPower(right);
                }

                if (gamepad1Y)
                    robot.servo1.setPosition(1 - 0.1);
                if (gamepad1X)
                    robot.servo1.setPosition(0);

                if (gamepad1B)
                    robot.servo2.setPosition(0.29);
                if (gamepad1A)
                    robot.servo2.setPosition(1);
            }
            if (switch_gamepad2_to_gamepad1 && !change_gamepad1_with_gamepad2) {
                if (gamepad1RB)
                    robot.servo_arm.setPosition(0.9);
                if (gamepad1LB)
                    robot.servo_arm.setPosition(0);

                //robot.extensionMotor.setPower(gamepad1R_STICK_Y);

                if (gamepad1DPAD_UP) {
                    robot.liftMotor.setPower(1);
                } else if (gamepad1DPAD_DOWN) {
                    robot.liftMotor.setPower(-1);
                } else {
                    robot.liftMotor.setPower(0);
                }
            }
            else {
                if (gamepad2RB)
                    robot.servo_arm.setPosition(0.7);
                if (gamepad2LB)
                    robot.servo_arm.setPosition(0);

                //robot.extensionMotor.setPower(gamepad2R_STICK_Y);

                if (gamepad2DPAD_UP) {
                    robot.liftMotor.setPower(1);
                } else if (gamepad2DPAD_DOWN) {
                    robot.liftMotor.setPower(-1);
                } else {
                    robot.liftMotor.setPower(0);
                }
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

