package org.firstinspires.ftc.teamcode;

import android.os.Environment;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerData {

    Hardware robot = null;

    public FileWriter writer;

    public double encoder_left_back;
    public double encoder_right_back;
    public double encoder_left_front;
    public double encoder_right_front;
    public double gyro_angle;
    public double range_distance;
    public double navigation_function;
    //1 - drive
    //2 - turn
    //3 - slide

    public LoggerData(Hardware r) {robot = r;}

    public String getValues() {

        String values = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());
        values += ", ";
        values += Double.toString(encoder_left_back);
        values += ", ";
        values += Double.toString(encoder_right_back);
        values += ", ";
        values += Double.toString(encoder_left_front);
        values += ", ";
        values += Double.toString(encoder_right_front);
        values += ", ";
        values += Double.toString(gyro_angle);
        values += ", ";
        values += Double.toString(navigation_function);

        return values;
    }

    public String getHeader() {
        return "time, encoder_left_back, encoder_right_back, encoder_left_front, encoder_right_front, gyro_angle, navigation_function";
    }

    public void generateLogFile(String mesaj) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
            timeStamp += "-";
            timeStamp += mesaj;
            timeStamp += ".csv";
            File gpxfile = new File(root, timeStamp);
            writer = new FileWriter(gpxfile);
            writer.append(getHeader() );
            writer.append( "\n" );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLogLine() {

        encoder_left_back = robot.leftMotorBack.getCurrentPosition();
        encoder_right_back = robot.rightMotorBack.getCurrentPosition();
        encoder_left_front = robot.leftMotorFront.getCurrentPosition();
        encoder_right_front = robot.rightMotorFront.getCurrentPosition();
        gyro_angle = robot.navigation.getAngle();

//        range_distance = robot.rangeSensorLeft.getDistance(DistanceUnit.CM);

        try {
            writer.append(getValues());
            writer.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

