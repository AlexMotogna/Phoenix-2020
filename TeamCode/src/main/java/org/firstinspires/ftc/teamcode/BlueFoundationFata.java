package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BlueFoundationFata",group = "Pushbot")

public class BlueFoundationFata extends LinearOpMode implements OpModeAddition {

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

//        robot.navigation.drive(-2, -0.8);
//        robot.navigation.Sliding(2,-0.3);
//        robot.navigation.drive(-34,-0.8);
//        robot.navigation.Catch();
//        robot.navigation.waitUntil(0.2);
//        robot.navigation.drive(40,0.8);
//        robot.navigation.DontCatch();
//        robot.navigation.Sliding(6,0.2);
//        robot.navigation.drive(-10, -0.8);
//        robot.navigation.Turn(80, 0.3);
//        robot.navigation.drive(-7, -0.6);
//        robot.navigation.drive(30, 0.6);

          robot.navigation.Sliding(5, 0.5);

    }
}
