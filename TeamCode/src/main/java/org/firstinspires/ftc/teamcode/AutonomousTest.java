package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="AutonomousTest", group="Pushbot")
@Disabled

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
//        robot.navigation.setTelemetry(this, robot.tensorDetectionClass);
//        robot.navigation.resetEncoders();
//        robot.navigation.imuInit();

//        robot.tensorDetectionClass.setOpModeAddition(this);
        robot.tensorDetectionClass.setHardwareMap(hardwareMap);
//        robot.tensorDetectionClass.INITCAMERA();

        waitForStart();

        int skystone = 0;

        if(skystone == 1) {
            robot.navigation.Sliding(1,"Right");
            robot.navigation.drive(25,0.5);
            //colectare
            robot.navigation.drive(-10, -0.5);
            robot.navigation.Turn(90, 0.3);
            robot.navigation.drive(150,0.7);
            //lasare mineral
            robot.navigation.drive(-80,0.7);
            robot.navigation.Turn(-90,0.3);
            robot.navigation.drive(10,0.5);
            //colectare
            robot.navigation.drive(-10,-0.5);
            robot.navigation.Turn(90, 0.3);
            robot.navigation.drive(100,0.7);
            //lasare
            robot.navigation.drive(-40, -0.7);
        }

        if(skystone == 0)
        {
            robot.navigation.drive(25,0.5);
            //colectare
            robot.navigation.drive(-10, -0.5);
            robot.navigation.Turn(90, 0.3);
            robot.navigation.drive(140,0.7);
            //lasare mineral
            robot.navigation.drive(-180,0.7); //functie Masalier
            robot.navigation.Turn(-90,0.3);
            robot.navigation.drive(10,0.5);
            //colectare
            robot.navigation.drive(-10,-0.5);
            robot.navigation.Turn(90, 0.3);
            robot.navigation.drive(140,0.7);
            //lasare
            robot.navigation.drive(-40, -0.7);
        }

        if(skystone == -1)
        {
            robot.navigation.Sliding(1,"Left");
            robot.navigation.drive(25,0.5);
            //colectare
            robot.navigation.drive(-10, -0.5);
            robot.navigation.Turn(90, 0.3);
            robot.navigation.drive(130,0.7);
            //lasare mineral
            robot.navigation.drive(-180,0.7);
            robot.navigation.Turn(-90,0.3);
            robot.navigation.drive(10,0.5);
            //colectare
            robot.navigation.drive(-10,-0.5);
            robot.navigation.Turn(90, 0.3);
            robot.navigation.drive(180,0.7);
            //lasare
            robot.navigation.drive(-40, -0.7);
        }





    }

}