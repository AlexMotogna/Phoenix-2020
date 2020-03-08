package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.internal.opmode.TelemetryImpl;

import static java.lang.Math.exp;

public class Navigation {
    Hardware robot;
    OpModeAddition opMode;
    Telemetry telemetry;

    public HardwareMap hMap = null;

    double reductie = 40*1.5; //pt motor 40:1
    double coutPerRev = 28; //count ul encoderului :)
    double wheelDiam = 4.0 * 2.54;
    double k = (reductie * coutPerRev) / (wheelDiam * 3.14);

    double GlobalAngle;
    Orientation lastAngle = new Orientation();

    public Navigation(Hardware robot){
        this.robot = robot;


    }

    public void setOpModeAddition(OpModeAddition opMode){
        this.opMode = opMode;
    }

    public void setTelemetry(OpMode opMode, TensorDetectionClass td){

        telemetry = new TelemetryImpl(opMode);
        td.telemetry = telemetry;
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

    public void grab()
    {

        robot.liftMotor.setPower(-1);

        waitUntil(1.4);

        robot.liftMotor.setPower(0);

        robot.servo_arm.setPosition(0);
        waitUntil(0.5);

        robot.servo_extension.setPower(-1);

        waitUntil(0.6);

        robot.servo_extension.setPower(0);
        robot.liftMotor.setPower(1);

        waitUntil(1.2);

        robot.liftMotor.setPower(0);
    }

    public void release() { robot.servo_arm.setPosition(0);}

    public void STRANGE_L()
    {
        robot.servo_arm.setPosition(0.5);
        waitUntil(1.5);

    }

    public void lift_sus(double time)
    {
        robot.liftMotor.setPower(0.5);
        waitUntil(time);
        robot.liftMotor.setPower(0);
    }

    public void lift_jos(double time)
    {
        robot.liftMotor.setPower(-0.5);
        waitUntil(time);
        robot.liftMotor.setPower(0);
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

        robot.loggerData.navigation_function = 1;

        while(robot.leftMotorBack.isBusy() && robot.rightMotorBack.isBusy() && robot.leftMotorFront.isBusy() && robot.rightMotorFront.isBusy() && opMode.isOpModeIsActive()){

            robot.loggerData.writeLogLine();

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

    public void waitUntil(double waitTime)
    {
        ElapsedTime time = new ElapsedTime();

        while(time.seconds() <= waitTime && opMode.isOpModeIsActive())
        {

        }
    }

    public void DriveOnTime (double time, double speed)
    {
        robot.leftMotorBack.setPower(speed);
        robot.leftMotorFront.setPower(speed);
        robot.rightMotorBack.setPower(speed);
        robot.rightMotorFront.setPower(speed);

        waitUntil(time);

        robot.leftMotorFront.setPower(0);
        robot.leftMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);
        robot.rightMotorBack.setPower(0);

    }

    public void imuInit()
    {

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.loggingEnabled = false;

        robot.imu.initialize(parameters);

        while(opMode.isOpModeIsActive() && !robot.imu.isGyroCalibrated()){
            waitUntil(0.05);
        }
/*
        telemetry.addData("imu calib status", robot.imu.getCalibrationStatus().toString());
        telemetry.update();*/

    }

    public void ResetAngle()
    {
        lastAngle = robot.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        GlobalAngle = 0;
    }

    public double getAngle()
    {
        Orientation aNgLeS = robot.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        double deltaAngle = aNgLeS.firstAngle - lastAngle.firstAngle;

        if (deltaAngle < -180)
            deltaAngle += 360;
        else if (deltaAngle > 180)
            deltaAngle -= 360;

        GlobalAngle += deltaAngle;

        lastAngle = aNgLeS;

        return GlobalAngle;
    }

    public void Turn ( double angle, double speed )
    {

        robot.loggerData.navigation_function = 2;

        ResetAngle();
        if (angle < 0)
        {
            robot.leftMotorFront.setPower(speed);
            robot.leftMotorBack.setPower(speed);
            robot.rightMotorFront.setPower(-speed);
            robot.rightMotorBack.setPower(-speed);

            while(opMode.isOpModeIsActive() && getAngle() > angle)
            {

                robot.loggerData.writeLogLine();

                telemetry.addData("unghi: ", getAngle());
                telemetry.update();
            }
        }
        if (angle > 0)
        {
            robot.leftMotorFront.setPower(-speed);
            robot.leftMotorBack.setPower(-speed);
            robot.rightMotorFront.setPower(speed);
            robot.rightMotorBack.setPower(speed);

            while(opMode.isOpModeIsActive() && getAngle() < angle)
            {
                robot.loggerData.writeLogLine();

                telemetry.addData("unghi: ", getAngle());
                telemetry.update();
            }
        }

        robot.leftMotorBack.setPower(0);
        robot.leftMotorFront.setPower(0);
        robot.rightMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);

        waitUntil(0.5);
        ResetAngle();

    }

    public void DriveToDistance(int dist, double Speed)
    {
        if(dist < 0)
            Speed = Speed * (-1);
        robot.rightMotorBack.setPower(Speed);
        robot.leftMotorBack.setPower(Speed);
        robot.rightMotorFront.setPower(Speed);
        robot.leftMotorFront.setPower(Speed);

        if(dist > 0) {
            while(((robot.distance_right.getDistance(DistanceUnit.CM) > dist) || (robot.distance_left.getDistance(DistanceUnit.CM) > dist)) && opMode.isOpModeIsActive()){

            }
        }

        robot.rightMotorBack.setPower(0);
        robot.leftMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);
        robot.leftMotorFront.setPower(0);

    }


    public void Sliding(double Time, double Speed)
    {
        // negativ la dreapta
        // pozitiv la stanga

        robot.loggerData.navigation_function = 3;

        robot.leftMotorBack.setPower(Speed);
        robot.leftMotorFront.setPower(-Speed);
        robot.rightMotorBack.setPower(-Speed);
        robot.rightMotorFront.setPower(Speed);


        ElapsedTime time = new ElapsedTime();

        while(time.seconds() <= Time && opMode.isOpModeIsActive()) {

            robot.loggerData.writeLogLine();

        }

        robot.rightMotorBack.setPower(0);
        robot.leftMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);
        robot.leftMotorFront.setPower(0);

    }

    public void Curba_Stanga()
    {
        robot.rightMotorBack.setPower(0.9);
        robot.rightMotorFront.setPower(0.9);
        robot.leftMotorFront.setPower(0.1);
        robot.leftMotorBack.setPower(0.1);

        waitUntil(0.83);

        robot.rightMotorBack.setPower(0);
        robot.leftMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);
        robot.leftMotorFront.setPower(0);


    }

    public void Sliding_45_Dreapta(double Time, double Speed)
    {
        this.robot.leftMotorBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.robot.leftMotorFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.robot.rightMotorFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.robot.rightMotorBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        robot.leftMotorBack.setPower(0);
        robot.leftMotorFront.setPower(Speed);
        robot.rightMotorBack.setPower(Speed);
        robot.rightMotorFront.setPower(0);

//        }
        waitUntil(Time);

        robot.rightMotorBack.setPower(0);
        robot.leftMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);
        robot.leftMotorFront.setPower(0);
    }

    public void Sliding_45_Stanga(double Time, double Speed)
    {
        robot.leftMotorBack.setPower(Speed);
        robot.leftMotorFront.setPower(0);
        robot.rightMotorBack.setPower(0);
        robot.rightMotorFront.setPower(Speed);

//        }
        waitUntil(Time);

        robot.rightMotorBack.setPower(0);
        robot.leftMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);
        robot.leftMotorFront.setPower(0);
    }

    public void Catch (){
        robot.foundationMotor.setPower(-0.3);
    }

    public void CatchForStone (){
        robot.servo_stone.setPosition(0.65);
        waitUntil(0.5);
    }

    public void DontCatch () {
        robot.foundationMotor.setPower(1);
        waitUntil(0.1);
        robot.foundationMotor.setPower(0);
    }
    
    public void DontCatchForStone () {
        robot.servo_stone.setPosition(0);
        waitUntil(0.5 );
    }

    public void FrontCatch () {
        robot.servo_extension.setPower(-0.5);
        waitUntil(0.5);
        robot.servo_extension.setPower(0);
        waitUntil(0.2);
        robot.servo_arm.setPosition(0.1);
        waitUntil(0.5);
    }

    public void FrontDontCatch () {
        robot.servo_arm.setPosition(0.6);
        waitUntil(0.5);
    }

    public void servo_initial () {
        robot.servo_rotatie.setPosition(0.5);
        waitUntil(0.5);
    }

    public void SlideToDistance (int dist, double Speed, String Direction){

        if(Speed < 0) Speed*=(-1);

        if(Direction == "right"){

            robot.rightMotorBack.setPower(Speed);
            robot.leftMotorBack.setPower(-Speed);
            robot.rightMotorFront.setPower(-Speed);
            robot.leftMotorFront.setPower(Speed);

            while ((robot.distance_right.getDistance(DistanceUnit.CM) > dist) && opMode.isOpModeIsActive()) {

            }
        }

        else{
            Speed*=(-1);

            robot.rightMotorBack.setPower(Speed);
            robot.leftMotorBack.setPower(-Speed);
            robot.rightMotorFront.setPower(-Speed);
            robot.leftMotorFront.setPower(Speed);

            while ((robot.distance_left.getDistance(DistanceUnit.CM) > dist) && opMode.isOpModeIsActive()) {

            }
        }

        robot.rightMotorBack.setPower(0);
        robot.leftMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);
        robot.leftMotorFront.setPower(0);

    }

    public void LasaManaJos (){
        robot.servo_arm.setPosition(0.1);
        waitUntil(0.5);
    }


    public void drive_on_function(int target){

        double speed = 0.368;

        target = (int)(target * k);

        robot.leftMotorBack.setTargetPosition(robot.leftMotorBack.getCurrentPosition() + target);
        robot.rightMotorBack.setTargetPosition(robot.rightMotorBack.getCurrentPosition() - target);
        robot.leftMotorFront.setTargetPosition(robot.leftMotorFront.getCurrentPosition() - target);
        robot.rightMotorFront.setTargetPosition(robot.rightMotorFront.getCurrentPosition() + target);

        robot.rightMotorBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        double Target = (double)target;

        speed = exp((-1)*((2/Target)*robot.leftMotorBack.getCurrentPosition() -  1)*((2/Target)*robot.leftMotorBack.getCurrentPosition() -  1));

        robot.leftMotorBack.setPower(speed);
        robot.leftMotorFront.setPower(-speed);
        robot.rightMotorBack.setPower(-speed);
        robot.rightMotorFront.setPower(speed);

        while(opMode.isOpModeIsActive() && robot.leftMotorFront.isBusy() && robot.leftMotorBack.isBusy() && robot.rightMotorFront.isBusy() && robot.rightMotorBack.isBusy()){

            speed = exp((-1)*((2/Target)*robot.leftMotorBack.getCurrentPosition() -  1)*((2/Target)*robot.leftMotorBack.getCurrentPosition() -  1));

            robot.leftMotorBack.setPower(speed);
            robot.leftMotorFront.setPower(-speed);
            robot.rightMotorBack.setPower(-speed);
            robot.rightMotorFront.setPower(speed);

            robot.loggerData.writeLogLine();

        }

        robot.leftMotorBack.setPower(0);
        robot.leftMotorFront.setPower(0);
        robot.rightMotorBack.setPower(0);
        robot.rightMotorFront.setPower(0);

    }


}
