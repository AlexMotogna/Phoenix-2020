package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.Arrays;

@TeleOp(name = "Control", group = "Control")

public class Control extends LinearOpMode implements OpModeAddition {

    Hardware robot = new Hardware();

    double left;
    double right;
    double speed;
    double direction;
    double arm_servo = 0.1;
    double servo_motor = 0;
    double servo_rot = 0.5;
    double extindere = 0;

    double servo_test1 = 0;
    double servo_test2 = 0;
    double servo_stone = 0;
    double servo_jos = 0.74;

    @Override
    public boolean isOpModeIsActive() {
        return opModeIsActive();
    }


    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

//            miscarea pe gamepad1 speed = gamepad1.right_trigger - gamepad1.left_trigger
//            speed = -gamepad1.right_stick_y;

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

            if (gamepad2.x) {
                servo_stone = 0.52;
            }

            if (gamepad2.y){
                servo_stone = 0;
            }

            if(gamepad2.a) {
                servo_jos = 0.24;
            }

            if(gamepad2.b){
                servo_jos = 0.74;
            }

            if(gamepad1.x){
                servo_test1+=0.05;
            }
            else if(gamepad1.y){
                servo_test1-=0.05;
            }

            if(gamepad1.a){
                servo_test2+=0.05;
            }
            else if(gamepad1.b){
                servo_test2-=0.05;
            }

            if(gamepad1.right_bumper){
                servo_test1 = 0.7;
                servo_test2 = 0.05;
            }

            else if(gamepad1.left_bumper){
                servo_test1 = 0.35;
                servo_test2 = 0.35;
            }

            robot.servo1.setPosition(servo_test1);
            //0.7 poz jos
            //0.35 poz sus
            robot.servo2.setPosition(servo_test2);

            robot.servot1.setPosition(servo_stone);

            robot.servot2.setPosition(servo_jos);

              telemetry.addData("servo_stone", servo_stone);
              telemetry.addData("servo_jos", servo_jos);
            telemetry.addData("servo_test1 ", servo_test1);
            telemetry.addData("servo_test2 ", servo_test2);

            /*
            if (gamepad1.dpad_down) {
                servo_motor+=0.05;
            }
            if (gamepad1.dpad_up) {
                servo_motor-=0.05 ;
            }

            if(servo_motor > 0.65) servo_motor = 0.65;

            if(servo_motor < 0) servo_motor = 0;

            robot.servo_stone.setPosition(servo_motor);
            telemetry.addData("servo motor ", servo_motor);
            */
            //prins skystone
//            if (gamepad2.left_bumper) {
//                arm_servo += 0.1;
//            }
//            if (gamepad2.right_bumper) {
//                arm_servo -= 0.1;
//            }
//
//            if(arm_servo > 0.5) arm_servo = 0.5;
//            if(arm_servo < 0.1) arm_servo = 0.1;
//            robot.servo_arm.setPosition(arm_servo);

//            telemetry.addData("servoul este ", robot.servo_arm.getPosition());

//            robot.extensionMotor.setPower(gamepad2.right_stick_y);
//            robot.servo_extension.setPower(gamepad2.right_stick_y);

//            if (gamepad2.dpad_up && !gamepad2.dpad_down) {
//                robot.liftMotor.setPower(0.5);
//            } else if (gamepad2.dpad_down && !gamepad2.dpad_up) {
//                robot.liftMotor.setPower(-0.5);
//            } else {
//                robot.liftMotor.setPower(0);
//            }


//            if(gamepad1.a){
//                robot.foundationMotor.setPower(0.5);
//            }
//            else if (gamepad1.b){
//                robot.foundationMotor.setPower(-0.5);
//            }
//            else robot.foundationMotor.setPower(0);


            //rotire mana

//            if(gamepad2.x){
//                servo_rot = 0.5;
//            }
//            else if(gamepad2.y){
//                servo_rot = -1;
//            }
//            else if(gamepad2.a){
//                servo_rot = 1;
//            }

//            robot.servo_rotatie.setPosition(servo_rot);

//            telemetry.addData("servo rotatie: ", servo_rot);

            telemetry.addData("leftBack", robot.leftMotorBack.getCurrentPosition());
            telemetry.addData("leftFront", robot.leftMotorFront.getCurrentPosition());
            telemetry.addData("rightBack", robot.rightMotorBack.getCurrentPosition());
            telemetry.addData("rightFront", robot.rightMotorFront.getCurrentPosition());

            telemetry.addData("left trigger", gamepad1.left_trigger);
            telemetry.addData("right trigger", gamepad1.right_trigger);
            telemetry.addData("right", right);
            telemetry.addData("left", left);

            telemetry.update();

        }

    }

}

