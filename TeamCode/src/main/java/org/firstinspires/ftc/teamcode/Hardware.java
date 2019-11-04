package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
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

     public BNO055IMU imu = null;

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

         leftMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         rightMotorBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         leftMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         rightMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

         navigation = new Navigation(this);
         imu = hmap.get(BNO055IMU.class, "imu");
     }
}
