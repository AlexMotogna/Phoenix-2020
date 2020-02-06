package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "RedZone",group = "Pushbot")


public class RedZone extends LinearOpMode implements OpModeAddition {

    Hardware robot = new Hardware();

    @Override
    public boolean isOpModeIsActive() {
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

        robot.loggerData.generateLogFile("RedZone");

        robot.tensorDetectionClass.setOpModeAddition(this);
        robot.tensorDetectionClass.setHardwareMap(hardwareMap);
        robot.tensorDetectionClass.INITCAMERA();




        waitForStart();

        int skystone = robot.tensorDetectionClass.TensorDetectionRed();

        telemetry.addData("pozitia este ", skystone);

        telemetry.update();

        if(skystone == -2)
            skystone = -1;

//        robot.navigation.Turn(180, 0.4);
//        robot.navigation.lift_sus(1);


        if(skystone == -1) {

            robot.navigation.drive(8, 0.3);

            robot.navigation.Sliding(3, 0.2);

//            robot.navigation.Turn(156, 0.5);

            robot.navigation.FrontDontCatch();

            robot.navigation.drive(25, 0.4);

            robot.navigation.FrontCatch();

            robot.navigation.drive(-7, -0.3); //-35 langa perete

            robot.navigation.Turn(-73, 0.4);

            robot.navigation.drive(62, 0.9);

            robot.navigation.FrontDontCatch();

            robot.navigation.servo_initial();

            // al doiles stone

            robot.navigation.drive(-45, -0.9);

            robot.navigation.Turn(78, 0.5);

            robot.navigation.drive(7, 0.5);

            robot.navigation.FrontCatch();

            robot.navigation.drive(-5, 0.5);

            robot.navigation.Turn(-76, 0.5);

            robot.navigation.drive(50, 0.9);

            robot.navigation.FrontDontCatch();

            robot.navigation.drive(-15, -0.9);

            robot.navigation.LasaManaJos();
        }

        if(skystone == 1) {

            robot.navigation.drive(8, 0.4);

//            robot.navigation.Turn(158, 0.4);

            robot.navigation.FrontDontCatch();

            robot.navigation.drive(25, 0.4);

            robot.navigation.FrontCatch();

            robot.navigation.drive(-8, -0.3); //-35 pt perete

            robot.navigation.Turn(-82, 0.3);

            robot.navigation.drive(50, 0.7);

            robot.navigation.FrontDontCatch();

            robot.navigation.servo_initial();

            //al doilea stone

            robot.navigation.drive(-78, -0.5);

            robot.navigation.Turn(74, 0.4);

            robot.navigation.drive(8, 0.4);

            robot.navigation.FrontCatch();

            robot.navigation.drive(-8, 0.4);

            robot.navigation.Turn(-80, 0.4);

            robot.navigation.drive(80, 0.7);

            robot.navigation.FrontDontCatch();

            robot.navigation.drive(-15, 0.8);

            robot.navigation.LasaManaJos();

        }

        if(skystone == 0) {

            robot.navigation.drive(8, 0.3);

            robot.navigation.Sliding(2, 0.2);

//            robot.navigation.Turn(155, 0.4);

            robot.navigation.FrontDontCatch();

            robot.navigation.drive(25, 0.4);

            robot.navigation.FrontCatch();

            robot.navigation.drive(-8 , -0.5); //-35 pt perete

            robot.navigation.Turn(-80, 0.3);

            robot.navigation.drive(55, 0.8);

            robot.navigation.FrontDontCatch();

            robot.navigation.servo_initial();

//            robot.navigation.drive(-20, -0.3);
            //al doilea stone

            robot.navigation.drive(-80, -0.8);

            robot.navigation.Turn(74, 0.4);

            robot.navigation.drive(8, 0.4);

            robot.navigation.FrontCatch();

            robot.navigation.drive(-8, 0.4);

            robot.navigation.Turn(-81, 0.4);

            robot.navigation.drive(80, 0.7);

            robot.navigation.FrontDontCatch();

            robot.navigation.drive(-15, 0.8);

            robot.navigation.LasaManaJos();

        }

        /*cod care merge si pe asta l punem
        if(skystone == -1) {

            robot.navigation.drive(-8, -0.3);

            robot.navigation.Sliding(2.7, -0.2);

            robot.navigation.Turn(163, 0.3);

            robot.navigation.FrontDontCatch();

            robot.navigation.drive(25, 0.2);

            robot.navigation.FrontCatch();

            robot.navigation.drive(-11, -0.3);

            robot.navigation.Turn(-85, 0.3);

            robot.navigation.drive(60, 0.7);

            robot.navigation.FrontDontCatch();

            robot.navigation.servo_initial();

            robot.navigation.drive(-20, -0.3);
        }

        if(skystone == 1) {

            robot.navigation.drive(-8, -0.4);

            robot.navigation.Turn(162, 0.4);

            robot.navigation.FrontDontCatch();

            robot.navigation.drive(25, 0.2);

            robot.navigation.FrontCatch();

            robot.navigation.drive(-11, -0.3);

            robot.navigation.Turn(-82, 0.3);

            robot.navigation.drive(50, 0.7);

            robot.navigation.FrontDontCatch();

            robot.navigation.servo_initial();

            robot.navigation.drive(-25, -0.5);

        }

        if(skystone == 0) {

            robot.navigation.drive(-8, -0.3);

            robot.navigation.Sliding(2, -0.2);

            robot.navigation.Turn(162, 0.2);

            robot.navigation.FrontDontCatch();

            robot.navigation.drive(25, 0.2);

            robot.navigation.FrontCatch();

            robot.navigation.drive(-11, -0.3);

            robot.navigation.Turn(-80, 0.3);

            robot.navigation.drive(55, 0.7);

            robot.navigation.FrontDontCatch();

            robot.navigation.servo_initial();

            robot.navigation.drive(-20, -0.3);
        }

         paana aici*/
        // aici se odihneste codul trecut

        /*
        if(skystone == -1) {
        // caz -1(1)
            robot.navigation.drive(-8,-0.3);

            robot.navigation.Sliding(1.8, -0.3);

            robot.navigation.drive(-33, -0.3);

            robot.navigation.CatchForStone();

            robot.navigation.waitUntil(0.5);

            robot.navigation.drive(9, 0.2);

            robot.navigation.Turn(-76, 0.5);

            robot.navigation.drive(-67, -0.6);

            robot.navigation.DontCatchForStone();

            robot.navigation.drive(45, 0.6);

            robot.navigation.Turn(80, 0.3);

            robot.navigation.drive(-11, -0.2);

            robot.navigation.waitUntil(0.5);

            robot.navigation.CatchForStone();

            robot.navigation.waitUntil(0.5);

            robot.navigation.drive(11, 0.2);

            robot.navigation.Turn(-85, 0.3);

            robot.navigation.drive(-46, -0.6);

            robot.navigation.DontCatchForStone();

            robot.navigation.drive(30, 0.6);
        }

        if(skystone == 1) {
            // caz 1(0)
//            robot.navigation.drive(-4,-0.3);

//            robot.navigation.Sliding(1, 0.3);

            robot.navigation.drive(-34, -0.3);

            robot.navigation.CatchForStone();

            robot.navigation.waitUntil(0.5);

            robot.navigation.drive(9, 0.2);

            robot.navigation.Turn(-70, 0.5);

            robot.navigation.drive(-55, -0.6);

            robot.navigation.DontCatchForStone();

            robot.navigation.drive(81, 0.6);

            robot.navigation.Turn(80, 0.3);

            robot.navigation.drive(-9, -0.2);

            robot.navigation.waitUntil(0.5);

            robot.navigation.CatchForStone();

            robot.navigation.waitUntil(0.5);

            robot.navigation.drive(11, 0.2);

            robot.navigation.Turn(-77, 0.3);

            robot.navigation.drive(-90, -0.6);

            robot.navigation.DontCatchForStone();

            robot.navigation.drive(23, 0.6);
        }

        if(skystone == 0) {
            // caz 0(-1)
            robot.navigation.drive(-2,-0.2);

            robot.navigation.Sliding(1,-0.3);

            robot.navigation.drive(-32, -0.3);

            robot.navigation.CatchForStone();

            robot.navigation.waitUntil(0.5);

            robot.navigation.drive(9, 0.2);

            robot.navigation.Turn(-70, 0.5);

            robot.navigation.drive(-60, -0.6);

            robot.navigation.DontCatchForStone();

            robot.navigation.drive(86, 0.6);

            robot.navigation.Turn(78, 0.3);

            robot.navigation.drive(-13, -0.2);

            robot.navigation.waitUntil(0.5);

            robot.navigation.CatchForStone();

            robot.navigation.waitUntil(0.5);

            robot.navigation.drive(15, 0.2);

            robot.navigation.Turn(-80, 0.3);

            robot.navigation.drive(-90, -0.6);

            robot.navigation.DontCatchForStone();

            robot.navigation.drive(25, 0.6);

        }
        */

        robot.loggerData.closeFile();

    }

}
