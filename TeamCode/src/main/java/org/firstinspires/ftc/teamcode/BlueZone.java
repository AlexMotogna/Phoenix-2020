package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="BlueZone", group="Pushbot")

public class BlueZone extends LinearOpMode implements OpModeAddition {

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

        robot.navigation.drive(-34, -0.2);
        robot.navigation.CatchForStone();
        robot.navigation.waitUntil(0.5);
        robot.navigation.drive(9, 0.1);
        robot.navigation.Turn(67, 0.5);
        robot.navigation.drive(-60, -0.5);
        robot.navigation.DontCatch();
        robot.navigation.drive(20, 0.5);
        robot.navigation.Sliding(2,0.5);

    }
}
