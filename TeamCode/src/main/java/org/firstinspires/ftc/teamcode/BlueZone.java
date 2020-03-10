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

        skystone = robot.tensorDetectionClass.TensorDetection();

        if(skystone == -2) skystone = 1;

        if(skystone == -1) {

            robot.navigation.drive(8, 0.3);

            robot.navigation.Sliding(1.5, 0.2);

//            robot.navigation.Turn(164, 0.3);

            robot.navigation.Release_Foundation();

            robot.navigation.drive(25, 0.4);



            robot.navigation.drive(-7, -0.4);  // -8 pt pod, -35 pt perete

            robot.navigation.Turn(85, 0.4);

            robot.navigation.drive(53, 0.8);


            //continuare luat cub 2, target 20 pt parcare

            robot.navigation.drive(-82, -0.8);

            robot.navigation.Turn(-80, 0.4);

            robot.navigation.drive(8, 0.3);


            robot.navigation.drive(-6, 0.4);

            robot.navigation.Turn(77, 0.5);

            robot.navigation.drive(80, 0.8);


            robot.navigation.drive(-15, -0.7);

            robot.navigation.LasaManaJos();
        }

        if(skystone == 0) {

            robot.navigation.drive(8, 0.3);

//            robot.navigation.Turn(164, 0.3);


            robot.navigation.drive(25, 0.6);


            robot.navigation.drive(-8, -0.3);  // -8 pt pod, -35 pt perete

            robot.navigation.Turn(85, 0.3);

            robot.navigation.drive(55, 0.7);


            //continuare luat cub 2, target 20 pt parcare

            robot.navigation.drive(-83, -0.6);

            robot.navigation.Turn(-79, 0.4);

            robot.navigation.drive(8, 0.3);


            robot.navigation.drive(-6, 0.4);

            robot.navigation.Turn(82, 0.4);

            robot.navigation.drive(85, 0.6);


            robot.navigation.drive(-15, -0.7);

            robot.navigation.LasaManaJos();

        }

        if(skystone == 1) {

            robot.navigation.drive(8, 0.4);

            robot.navigation.Sliding(1.5, -0.2);

//            robot.navigation.Turn(162, 0.4);


            robot.navigation.drive(25, 0.5);


            robot.navigation.drive(-9, -0.4);  //-9 pt pod, -36 pt perete

            robot.navigation.Turn(85, 0.3);

            robot.navigation.drive(70, 0.7);


            //continuare luat cub 2, target 20 pt parcare

            robot.navigation.drive(-60, -0.7);

            robot.navigation.Turn(-79, 0.4);

            robot.navigation.drive(7, 0.5);


            robot.navigation.drive(-6, 0.4);

            robot.navigation.Turn(80, 0.4);

            robot.navigation.drive(60, 0.6);


            robot.navigation.drive(-12, -0.8);

            robot.navigation.LasaManaJos();
        }


//        if(skystone == 0) {
//            robot.navigation.drive(-34, -0.3);
//
//            robot.navigation.CatchForStone();
//
//            robot.navigation.waitUntil(0.5);
//
//            robot.navigation.drive(10, 0.2);
//
//            robot.navigation.Turn(64, 0.5);
//
//            robot.navigation.drive(-60, -0.6);
//
//            robot.navigation.DontCatchForStone();
//
//            robot.navigation.drive(82, 0.8);
//
//            robot.navigation.Turn(-80, 0.3);
//
//            robot.navigation.drive(-9, -0.2);
//
//            robot.navigation.waitUntil(0.5);
//
//            robot.navigation.CatchForStone();
//
//            robot.navigation.waitUntil(0.5);
//
//            robot.navigation.drive(9, 0.2);
//
//            robot.navigation.Turn(73, 0.3);
//
//            robot.navigation.drive(-90, -0.6);
//
//            robot.navigation.DontCatchForStone();
//
//            robot.navigation.drive(23, 0.6);
//        }
//
//       else if (skystone == -1){
//
//           robot.navigation.drive(-8,-0.3);
//
////           robot.navigation.Sliding(1, -0.3);
//
//           robot.navigation.drive(-26, -0.3);
//
//           robot.navigation.CatchForStone();
//
//           robot.navigation.waitUntil(0.5);
//
//           robot.navigation.drive(11, 0.2);
//
//           robot.navigation.Turn(62, 0.5);
//
//           robot.navigation.drive(-50, -0.4);
//
//           robot.navigation.DontCatchForStone();
//
//           robot.navigation.drive(20, 0.5);
//
////           robot.navigation.Turn(-80, 0.3);
////
////           robot.navigation.drive(-9, -0.2);
////
////           robot.navigation.waitUntil(0.5);
////
////           robot.navigation.CatchForStone();
////
////           robot.navigation.waitUntil(0.5);
////
////           robot.navigation.drive(11, 0.2);
////
////           robot.navigation.Turn(74, 0.3);
////
////           robot.navigation.drive(-85, -0.6);
////
////           robot.navigation.DontCatchForStone();
////
////           robot.navigation.drive(25, 0.6);
//       }
//
//       else {
//
//           robot.navigation.drive(-4,-0.3);
//
//           robot.navigation.Sliding(0.8, 0.3);
//
//           robot.navigation.drive(-30, -0.3);
//
//           robot.navigation.CatchForStone();
//
//           robot.navigation.waitUntil(0.5);
//
//           robot.navigation.drive(9, 0.2);
//
//           robot.navigation.Turn(65, 0.5);
//
//           robot.navigation.drive(-55, -0.6);
//
//           robot.navigation.DontCatchForStone();
//
//           robot.navigation.drive(40, 0.6);
//
//           robot.navigation.Turn(-76, 0.3);
//
//           robot.navigation.drive(-9, -0.2);
//
//           robot.navigation.waitUntil(0.5);
//
//           robot.navigation.CatchForStone();
//
//           robot.navigation.waitUntil(0.5);
//
//           robot.navigation.drive(11, 0.2);
//
//           robot.navigation.Turn(74, 0.3);
//
//           robot.navigation.drive(-50, -0.6);
//
//           robot.navigation.DontCatchForStone();
//
//           robot.navigation.drive(17, 0.6);
//
//       }


       robot.loggerData.closeFile();

    }
}
