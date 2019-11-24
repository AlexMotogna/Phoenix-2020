package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.ConceptTensorFlowObjectDetection;
import org.firstinspires.ftc.robotcontroller.external.samples.ConceptTensorFlowObjectDetectionWebcam;

public class Hardware {

     HardwareMap hmap = null;

     public DcMotor leftMotorBack = null;
     public DcMotor leftMotorFront = null;
     public DcMotor rightMotorBack = null;
     public DcMotor rightMotorFront = null;
     public Navigation navigation = null;
     public TensorDetectionClass tensorDetectionClass = null;

     public BNO055IMU imu = null;
    public ModernRoboticsI2cRangeSensor distance_fata1 = null;
    public ModernRoboticsI2cRangeSensor distance_fata2 = null;
    public ModernRoboticsI2cRangeSensor distance_spate = null;

//     public ConceptTensorFlowObjectDetection tensorflow = null;



     public Hardware(){

     }

     public void init(HardwareMap tmap){

         hmap = tmap;

         leftMotorBack = hmap.get(DcMotor.class, "left_motor_back");
         leftMotorFront = hmap.get(DcMotor.class, "left_motor_front");
         rightMotorBack = hmap.get(DcMotor.class, "right_motor_back");
         rightMotorFront = hmap.get(DcMotor.class, "right_motor_front");

         leftMotorBack.setDirection(DcMotor.Direction.REVERSE);
         leftMotorFront.setDirection(DcMotor.Direction.REVERSE);

         leftMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         rightMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         rightMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         leftMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

         leftMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         rightMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         leftMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         rightMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//         distance_fata1 = hmap.get(ModernRoboticsI2cRangeSensor.class, "senzor1");
//         distance_fata2 = hmap.get(ModernRoboticsI2cRangeSensor.class, "senzor2");
         navigation = new Navigation(this);
         tensorDetectionClass = new TensorDetectionClass(this);
//         imu = hmap.get(BNO055IMU.class, "imu");
     }
}
