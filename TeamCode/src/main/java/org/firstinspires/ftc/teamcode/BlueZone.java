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

        robot.loggerData.generateLogFile("BlueZone");

        robot.tensorDetectionClass.setOpModeAddition(this);
        robot.tensorDetectionClass.setHardwareMap(hardwareMap);
        robot.tensorDetectionClass.INITCAMERA();

        waitForStart();

        int skystone = robot.tensorDetectionClass.TensorDetection();

        telemetry.addData("pozitia este ", skystone);

        telemetry.update();


        if(skystone == 0) {
            robot.navigation.drive(-34, -0.3);

            robot.navigation.CatchForStone();

            robot.navigation.waitUntil(0.5);

            robot.navigation.drive(9, 0.2);

            robot.navigation.Turn(67, 0.5);

            robot.navigation.drive(-60, -0.6);

            robot.navigation.DontCatchForStone();

            robot.navigation.drive(88, 0.6);

            robot.navigation.Turn(-80, 0.3);

            robot.navigation.drive(-9, -0.2);

            robot.navigation.waitUntil(0.5);

            robot.navigation.CatchForStone();

            robot.navigation.waitUntil(0.5);

            robot.navigation.drive(11, 0.2);

            robot.navigation.Turn(74, 0.3);

            robot.navigation.drive(-90, -0.6);

            robot.navigation.DontCatchForStone();

            robot.navigation.drive(25, 0.6);
        }

       else if (skystone == -1){

           robot.navigation.drive(-8,-0.3);

           robot.navigation.Sliding(1, -0.3);

           robot.navigation.drive(-26, -0.3);

           robot.navigation.CatchForStone();

           robot.navigation.waitUntil(0.5);

           robot.navigation.drive(9, 0.2);

           robot.navigation.Turn(67, 0.5);

           robot.navigation.drive(-55, -0.6);

           robot.navigation.DontCatchForStone();

           robot.navigation.drive(83, 0.6);

           robot.navigation.Turn(-80, 0.3);

           robot.navigation.drive(-9, -0.2);

           robot.navigation.waitUntil(0.5);

           robot.navigation.CatchForStone();

           robot.navigation.waitUntil(0.5);

           robot.navigation.drive(11, 0.2);

           robot.navigation.Turn(74, 0.3);

           robot.navigation.drive(-85, -0.6);

           robot.navigation.DontCatchForStone();

           robot.navigation.drive(25, 0.6);
       }

       else {

           robot.navigation.drive(-4,-0.3);

           robot.navigation.Sliding(0.8, 0.3);

           robot.navigation.drive(-30, -0.3);

           robot.navigation.CatchForStone();

           robot.navigation.waitUntil(0.5);

           robot.navigation.drive(9, 0.2);

           robot.navigation.Turn(67, 0.5);

           robot.navigation.drive(-55, -0.6);

           robot.navigation.DontCatchForStone();

           robot.navigation.drive(35, 0.6);

           robot.navigation.Turn(-80, 0.3);

           robot.navigation.drive(-9, -0.2);

           robot.navigation.waitUntil(0.5);

           robot.navigation.CatchForStone();

           robot.navigation.waitUntil(0.5);

           robot.navigation.drive(11, 0.2);

           robot.navigation.Turn(74, 0.3);

           robot.navigation.drive(-40, -0.6);

           robot.navigation.DontCatchForStone();

           robot.navigation.drive(20, 0.6);

       }

       robot.loggerData.closeFile();

    }
}
