package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

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
        robot.navigation.setTelemetry(this);
        robot.navigation.resetEncoders();
        robot.navigation.imuInit();

        waitForStart();

//        robot.navigation.drive(40, 0.5);
          robot.navigation.Turn(85, 0.3);
          robot.navigation.DriveToDistance(15,0.5);
          robot.navigation.Turn(85, 0.3);
          robot.navigation.DriveOnTime(3, 0.5);


    }


}
