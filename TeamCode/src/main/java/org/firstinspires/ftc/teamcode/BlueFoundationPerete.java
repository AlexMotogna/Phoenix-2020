package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "FoundationBluePerete",group = "Pushbot")

public class BlueFoundationPerete extends LinearOpMode implements OpModeAddition {

    Hardware robot = new Hardware();

    @Override
    public boolean isOpModeIsActive(){
        return opModeIsActive();
    }

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        robot.navigation.setOpModeAddition(this);
        robot.navigation.setHardwareMap(hardwareMap);
        robot.navigation.setTelemetry(this, robot.tensorDetectionClass);
        robot.navigation.resetEncoders();
        robot.navigation.imuInit();

        robot.loggerData.generateLogFile("FoundationBluePerete");

        waitForStart();

        robot.navigation.drive(2, 0.2);
        robot.navigation.Sliding(4,0.2);
        robot.navigation.drive(34,0.2);
        robot.navigation.Catch_Foundation();
        robot.navigation.waitUntil(1);
        robot.navigation.drive(-28,-0.4);
        robot.navigation.Turn(75, 0.3);
        robot.navigation.drive(13, 0.5);
        robot.navigation.Release_Foundation();
        robot.navigation.waitUntil(0.3);
        // negativ la dreapta
        // pozitiv la stanga
        //robot.navigation.Sliding(2.5 , -0.2); //PARCARE LA PERETE
//        robot.navigation.Sliding(1.6, 0.3); //PARCARE LA POD
        robot.navigation.drive(-47, -0.5);
        robot.loggerData.closeFile();
    }
}
