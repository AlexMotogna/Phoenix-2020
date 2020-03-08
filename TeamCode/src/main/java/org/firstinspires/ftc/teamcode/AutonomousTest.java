package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.io.IOException;

@Autonomous(name="AutonomousTest", group="Pushbot")


public class AutonomousTest extends LinearOpMode implements OpModeAddition {

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

        robot.loggerData.generateLogFile("AutonomouusTest");

//        robot.tensorDetectionClass.setOpModeAddition(this);
//        robot.tensorDetectionClass.setHardwareMap(hardwareMap);
//        robot.tensorDetectionClass.INITCAMERA();

        waitForStart();

//        robot.navigation.drive(40, 0.1);

//        robot.navigation.SlideToDistance(20, 0.2, "left");

//            robot.navigation.FrontCatch();

        //robot.navigation.drive_on_function(50);

      //  robot.navigation.Sliding_45_Dreapta(2,0.3);

//        robot.navigation.drive(5,0.4);
//        robot.navigation.Curba_Stanga();
//        robot.navigation.waitUntil(0.5);
        robot.navigation.drive(80, 0.8);

        robot.loggerData.closeFile();
    }

}