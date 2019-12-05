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
    int in_ce_directie;




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


            if(gamepad1.right_stick_x != 0){

                robot.leftMotorBack.setPower(in_ce_directie*(-gamepad1.right_stick_x));
                robot.leftMotorFront.setPower(in_ce_directie*(gamepad1.right_stick_x));
                robot.rightMotorBack.setPower(in_ce_directie*(gamepad1.right_stick_x));
                robot.rightMotorFront.setPower(in_ce_directie*(-gamepad1.right_stick_x));

            }
            else {
                robot.leftMotorBack.setPower(-left);
                robot.leftMotorFront.setPower(-left);
                robot.rightMotorBack.setPower(-right);
                robot.rightMotorFront.setPower(-right);
            }


            //prins skystone
            if(gamepad1.right_bumper)
            {
                robot.servo_arm.setPosition(0.5);
            }
            if(gamepad1.left_bumper)
            {
                robot.servo_arm.setPosition(0);
            }

            robot.extensionMotor.setPower(gamepad1.right_stick_y);

            if(gamepad1.dpad_up && !gamepad1.dpad_down)
            {
                robot.liftMotor.setPower(0.5);
            }

            else if(gamepad1.dpad_down && !gamepad1.dpad_up)
            {
                robot.liftMotor.setPower(-0.5);
            }

            else
            {
                robot.liftMotor.setPower(0.01);
            }

            // catch servo1 - Y
            if (gamepad1.y) {

                robot.servo1.setPower(1);
            }
            else if (gamepad1.x){

                robot.servo1.setPower(-1);
            }

            else {
                robot.servo1.setPower(-0.2);
            }

            // catch servo2 - B
            if (gamepad1.b) {

                robot.servo2.setPower(-1);
            }
            else if (gamepad1.a) {

                robot.servo2.setPower(1);

            }
            else {
                robot.servo2.setPower(0);
            }
//            telemetry.addData("leftBack", robot.leftMotorBack.getCurrentPosition());
//            telemetry.addData("leftFront", robot.leftMotorFront.getCurrentPosition());
//            telemetry.addData("rightBack", robot.rightMotorBack.getCurrentPosition());
//            telemetry.addData("rightFront", robot.rightMotorFront.getCurrentPosition());


            telemetry.addData("Bumper1, Vlad e cel mai tare ", gamepad1.left_trigger);


            telemetry.addData("Bumper2, Victor e cel mai tare ", gamepad1.right_trigger);
            telemetry.addData("right, Croi e cel mai tare ", right);
            telemetry.addData("left, Afra e cel mai tare ", left);
            telemetry.update();

        }

    }



}
