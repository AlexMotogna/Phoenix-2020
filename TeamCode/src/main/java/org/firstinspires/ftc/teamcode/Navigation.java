package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.opmode.TelemetryImpl;

public class Navigation {
    Hardware robot;
    OpModeAddition opMode;
    Telemetry telemetry;

    public HardwareMap hMap = null;

    double reductie = 40*1.5; //pt motor 40:1
    double coutPerRev = 28; //count ul encoderului :)
    double wheelDiam = 4.0 * 2.54;
    double k = (reductie * coutPerRev) / (wheelDiam * 3.14);

    public Navigation(Hardware robot){
        this.robot = robot;
    }

    public void setOpModeAddition(OpModeAddition opMode){
        this.opMode = opMode;
    }

    public void setTelemetry(OpMode opMode){
        telemetry = new TelemetryImpl(opMode);
    }

    public void setHardwareMap(HardwareMap hmap){ this.hMap = hmap; }

    public void resetEncoders()
    {
        robot.leftMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.leftMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void drive(int Target, double Speed){

        Target = (int)(Target * k);
        if(Target < 0) Speed = Speed*(-1);

        robot.leftMotorBack.setTargetPosition(robot.leftMotorBack.getCurrentPosition() + Target);
        robot.rightMotorBack.setTargetPosition(robot.rightMotorBack.getCurrentPosition() + Target);
        robot.leftMotorFront.setTargetPosition(robot.leftMotorFront.getCurrentPosition() + Target);
        robot.rightMotorFront.setTargetPosition(robot.rightMotorFront.getCurrentPosition() + Target);

        robot.rightMotorBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        robot.rightMotorBack.setPower(Speed);
        robot.leftMotorBack.setPower(Speed);
        robot.rightMotorFront.setPower(Speed);
        robot.leftMotorFront.setPower(Speed);

        while(robot.leftMotorBack.isBusy() && robot.rightMotorBack.isBusy() && robot.leftMotorFront.isBusy() && robot.rightMotorFront.isBusy() && opMode.isOpModeIsActive()){

            telemetry.addData("right_encoder_front", robot.rightMotorFront.getCurrentPosition());
            telemetry.addData("right_encoder_back", robot.rightMotorBack.getCurrentPosition());
            telemetry.addData("left_motor_back", robot.leftMotorBack.getCurrentPosition());
            telemetry.addData("left_motor_front", robot.leftMotorFront.getCurrentPosition());
            telemetry.addData("target", robot.leftMotorBack.getTargetPosition());
            telemetry.update();
        }

        robot.rightMotorBack.setPower(0);
        robot.leftMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);
        robot.leftMotorFront.setPower(0);

        robot.leftMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

}
