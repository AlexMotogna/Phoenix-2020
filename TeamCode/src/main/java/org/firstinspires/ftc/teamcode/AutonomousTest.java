package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.io.IOException;

@Autonomous(name="AutonomousTest", group="Pushbot")
@Disabled

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

        robot.navigation.CatchForStone();

        robot.navigation.waitUntil(1);

        robot.navigation.DontCatchForStone();

        robot.loggerData.closeFile();
    }

}