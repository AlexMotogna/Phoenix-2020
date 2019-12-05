package org.firstinspires.ftc.teamcode;

import android.text.method.Touch;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
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
     public Navigation navigation = null;
     public TensorDetectionClass tensorDetectionClass = null;

     public BNO055IMU imu = null;
    public ModernRoboticsI2cRangeSensor distance_fata1 = null;
    public ModernRoboticsI2cRangeSensor distance_fata2 = null;
    public ModernRoboticsI2cRangeSensor distance_spate = null;
    public Servo servo_arm = null;

     public ConceptTensorFlowObjectDetection tensorflow = null;



     public Hardware(){

     }

     public void init(HardwareMap tmap){

         hmap = tmap;
         liftMotor = hmap.get(DcMotor.class,"lift_motor");
//
         leftMotorBack = hmap.get(DcMotor.class, "left_motor_back");
         leftMotorFront = hmap.get(DcMotor.class, "left_motor_front");
         rightMotorBack = hmap.get(DcMotor.class, "right_motor_back");
         rightMotorFront = hmap.get(DcMotor.class, "right_motor_front");

         extensionMotor = hmap.get(DcMotor.class, "extension_motor");

         leftMotorBack.setDirection(DcMotor.Direction.REVERSE);
         leftMotorFront.setDirection(DcMotor.Direction.REVERSE);

         leftMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         rightMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         rightMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         leftMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         extensionMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

         leftMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         rightMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         leftMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         rightMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         extensionMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

         liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

         distance_fata1 = hmap.get(ModernRoboticsI2cRangeSensor.class, "senzor1");
         distance_fata2 = hmap.get(ModernRoboticsI2cRangeSensor.class, "senzor2");
         navigation = new Navigation(this);
         tensorDetectionClass = new TensorDetectionClass(this);
         servo_arm = hmap.get(Servo.class,"servo_arm");
         imu = hmap.get(BNO055IMU.class, "imu");
     }
}
