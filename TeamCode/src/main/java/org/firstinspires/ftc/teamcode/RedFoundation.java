package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="FoundationRedPod", group="Pushbot")

public class RedFoundation extends LinearOpMode implements OpModeAddition {

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

        waitForStart();

        robot.navigation.drive(-2, -0.2);
        robot.navigation.Sliding(2,0.3);
        robot.navigation.drive(-34,-0.2);
        robot.navigation.Catch();
        robot.navigation.waitUntil(1);
        robot.navigation.drive(40,0.2);
        robot.navigation.Turn(-86, 0.3);
        robot.navigation.drive(-13, -0.5);
        robot.navigation.DontCatch();
        // negativ la dreapta
        // pozitiv la stanga
//        robot.navigation.Sliding(1.5 , 0.3); //PARCARE LA PERETE
        robot.navigation.Sliding(1.3, -0.3); //PARCARE LA POD
        robot.navigation.drive(45, 0.5);

    }
}
