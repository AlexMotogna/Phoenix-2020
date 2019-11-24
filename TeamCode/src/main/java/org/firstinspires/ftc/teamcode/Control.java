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


            if(gamepad1.dpad_right || gamepad1.dpad_left){

                if(gamepad1.dpad_right) in_ce_directie = 1;
                else in_ce_directie = -1;

                robot.leftMotorBack.setPower(in_ce_directie*(-0.3));
                robot.leftMotorFront.setPower(in_ce_directie*(0.3));
                robot.rightMotorBack.setPower(in_ce_directie*(0.3));
                robot.rightMotorFront.setPower(in_ce_directie*(-0.3));

            }
            else {
                robot.leftMotorBack.setPower(left);
                robot.leftMotorFront.setPower(left);
                robot.rightMotorBack.setPower(right);
                robot.rightMotorFront.setPower(right);
            }

            telemetry.addData("leftBack", robot.leftMotorBack.getCurrentPosition());
            telemetry.addData("leftFront", robot.leftMotorFront.getCurrentPosition());
            telemetry.addData("rightBack", robot.rightMotorBack.getCurrentPosition());
            telemetry.addData("rightFront", robot.rightMotorFront.getCurrentPosition());


            telemetry.addData("Bumper1, Vlad e cel mai tare ", gamepad1.left_trigger);
            telemetry.addData("Bumper2, Victor e cel mai tare ", gamepad1.right_trigger);
            telemetry.addData("right", right);
            telemetry.addData("left", left);
            telemetry.update();

        }

    }



}
