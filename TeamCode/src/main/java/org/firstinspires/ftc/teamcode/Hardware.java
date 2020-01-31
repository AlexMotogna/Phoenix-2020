package org.firstinspires.ftc.teamcode;

import android.text.method.Touch;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.ConceptTensorFlowObjectDetection;
import org.firstinspires.ftc.robotcontroller.external.samples.ConceptTensorFlowObjectDetectionWebcam;

public class Hardware {

    HardwareMap hmap = null;

    public DcMotor leftMotorBack = null;
    public DcMotor leftMotorFront = null;
    public DcMotor rightMotorBack = null;
    public DcMotor rightMotorFront = null;
    public DcMotor liftMotor = null;
    public DcMotor extensionMotor = null;
    public DcMotor foundationMotor = null;
    public Navigation navigation = null;
    public TensorDetectionClass tensorDetectionClass = null;

    public BNO055IMU imu = null;
    public ModernRoboticsI2cRangeSensor distance_right = null;
    public ModernRoboticsI2cRangeSensor distance_left = null;
    public ModernRoboticsI2cRangeSensor distance_spate = null;
    public Servo servo_arm = null;
    public Servo servo1 = null;
    public Servo servo2 = null;
    public Servo servo_stone = null;
    public Servo servo_rotatie = null;

    public ConceptTensorFlowObjectDetection tensorflow = null;
    public LoggerData loggerData = null;


    public Hardware(){

    }

    public void init(HardwareMap tmap){

        hmap = tmap;
        liftMotor = hmap.get(DcMotor.class,"lift_motor");

        leftMotorBack = hmap.get(DcMotor.class, "left_motor_back");
        leftMotorFront = hmap.get(DcMotor.class, "left_motor_front");
        rightMotorBack = hmap.get(DcMotor.class, "right_motor_back");
        rightMotorFront = hmap.get(DcMotor.class, "right_motor_front");
        foundationMotor = hmap.get(DcMotor.class, "servo_motor");
        extensionMotor = hmap.get(DcMotor.class, "extension_motor");

//        leftMotorBack.setDirection(DcMotor.Direction.REVERSE); astea au reverse pt motoare gobilda
//        leftMotorFront.setDirection(DcMotor.Direction.REVERSE);
        rightMotorFront.setDirection(DcMotor.Direction.REVERSE);
        rightMotorBack.setDirection(DcMotor.Direction.REVERSE);
        extensionMotor.setDirection(DcMotor.Direction.REVERSE);
        foundationMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        extensionMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        foundationMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        leftMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        extensionMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        foundationMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        distance_right = hmap.get(ModernRoboticsI2cRangeSensor.class, "sensor_right");
        distance_left = hmap.get(ModernRoboticsI2cRangeSensor.class, "sensor_left");
        navigation = new Navigation(this);
        tensorDetectionClass = new TensorDetectionClass(this);
        loggerData = new LoggerData(this);
        servo_arm = hmap.get(Servo.class,"servo_arm");
        servo_stone = hmap.get(Servo.class, "servo_stone");
        servo_rotatie = hmap.get(Servo.class, "servo_rotatie");
//        servo1 = hmap.get(Servo.class, "servo1");
//        servo2 = hmap.get(Servo.class, "servo2");
        imu = hmap.get(BNO055IMU.class, "imu");

//        servo1.setDirection(Servo.Direction.REVERSE);

//        servo1.setPosition(0);
//        servo2.setPosition(1);

    }
}