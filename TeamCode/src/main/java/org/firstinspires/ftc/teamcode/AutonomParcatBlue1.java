package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="ParcareBluePerete", group="Pushbot")

public class AutonomParcatBlue1 extends LinearOpMode implements OpModeAddition {

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
//
        robot.loggerData.generateLogFile("AutonomParcatPErete");
        waitForStart();
        robot.navigation.Sliding(0.5, -0.3);
        robot.navigation.drive(40, 0.3);
        robot.loggerData.closeFile();
    }

}