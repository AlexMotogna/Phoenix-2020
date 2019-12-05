package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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

        robot.tensorDetectionClass.setOpModeAddition(this);
        robot.tensorDetectionClass.setHardwareMap(hardwareMap);
        robot.tensorDetectionClass.INITCAMERA();

        int skystone = robot.tensorDetectionClass.TensorDetection() * -1;

        if(skystone == 1) {
        waitForStart();


        if(skystone == -2) {
            skystone = 0;
        }
        robot.navigation.Turn(180, 0.4);

            robot.navigation.Sliding(1, "Left");

            robot.navigation.drive(25, 0.5);

            robot.navigation.lift_jos(1);

            robot.navigation.grab();

            robot.navigation.drive(-13, -0.5);

            robot.navigation.Turn(-90, 0.3);

            robot.navigation.drive(150, 0.7);

            robot.navigation.release();

            robot.navigation.drive(-80, 0.7);

            robot.navigation.Turn(90, 0.3);

            robot.navigation.drive(10, 0.5);

            robot.navigation.lift_sus(1);

            robot.navigation.drive(3, 0.2);

            robot.navigation.lift_jos(1);

            robot.navigation.grab();

            robot.navigation.lift_jos(1);

            robot.navigation.drive(-13, -0.5);

            robot.navigation.Turn(-90, 0.3);

            robot.navigation.drive(100, 0.7);

            robot.navigation.release();

            robot.navigation.drive(-40, -0.7);
        }

        if(skystone == 0) {
            robot.navigation.drive(25, 0.5);

            robot.navigation.lift_jos(1);

            robot.navigation.grab();

            robot.navigation.drive(-13, -0.5);

            robot.navigation.Turn(-90, 0.3);

            robot.navigation.drive(140, 0.7);

            robot.navigation.release();

            robot.navigation.drive(-180, 0.7); //functie Masalier

            robot.navigation.Turn(90, 0.3);

            robot.navigation.drive(10, 0.5);

            robot.navigation.lift_sus(1);

            robot.navigation.drive(3, 0.2);

            robot.navigation.lift_jos(1);

            robot.navigation.grab();

            robot.navigation.drive(-13, -0.5);

            robot.navigation.Turn(-90, 0.3);

            robot.navigation.drive(140, 0.7);

            robot.navigation.release();

            robot.navigation.drive(-40, -0.7);
        }

        if(skystone == -1) {
            robot.navigation.Sliding(1, "Right");

            robot.navigation.drive(25, 0.5);

            robot.navigation.lift_jos(1);

            robot.navigation.grab();

            robot.navigation.drive(-13, -0.5);

            robot.navigation.Turn(-90, 0.3);

            robot.navigation.drive(130, 0.7);

            robot.navigation.release();

            robot.navigation.drive(-180, 0.7);

            robot.navigation.Turn(90, 0.3);

            robot.navigation.drive(10, 0.5);

            robot.navigation.lift_sus(1);

            robot.navigation.drive(3, 0.2);

            robot.navigation.lift_jos(1);

            robot.navigation.grab();

            robot.navigation.drive(-13, -0.5);

            robot.navigation.Turn(-90, 0.3);

            robot.navigation.drive(180, 0.7);

            robot.navigation.release();

            robot.navigation.drive(-40, -0.7);
        }




    }

}
