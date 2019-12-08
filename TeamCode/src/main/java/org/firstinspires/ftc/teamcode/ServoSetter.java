package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="servo_setter", group="Pushbot")
@Disabled
public class ServoSetter extends LinearOpMode {


    @Override
    public void runOpMode(){

        Servo servo = hardwareMap.get(Servo.class, "servo");

        double pos = 1;
        double inc = 0.0001;


        waitForStart();

        while (opModeIsActive()){

            if(gamepad1.a){
                pos += inc;
            }

            if(gamepad1.b){
                pos -= inc;
            }

            if(pos > 1) pos = 1;
            if(pos < 0) pos = 0;

            servo.setPosition(pos);

            telemetry.addData("pos", pos);
            telemetry.update();
        }

    }
}
