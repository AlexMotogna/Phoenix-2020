package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="RedFoundaation", group="Pushbot")
@Disabled
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

        robot.navigation.Sliding(1, "Right");
        robot.navigation.drive(25, 0.5);
        //agatare fundatie
        robot.navigation.drive(-25, -0.5);//robot.naviigation.marsalier(10,0.5);
        //desprindere fundatie
        robot.navigation.Sliding(3, "Left");

    }
}
