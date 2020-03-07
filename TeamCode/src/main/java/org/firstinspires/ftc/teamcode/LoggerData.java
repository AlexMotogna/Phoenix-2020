package org.firstinspires.ftc.teamcode;

import android.os.Environment;

import com.qualcomm.robotcore.util.ElapsedTime;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerData {

    Hardware robot = null;

    public FileWriter writer;

    boolean fileCreated;

    public double encoder_left_back;
    public double encoder_right_back;
    public double encoder_left_front;
    public double encoder_right_front;
    public double gyro_angle;
    public double range_distance;
    public double navigation_function;
    public double dist_left_back;
    public double dist_left_front;
    public double dist_right_front;
    public double dist_right_back;
    public double speed_left_back;
    public double speed_left_front;
    public double speed_right_back;
    public double speed_right_front;
    public ElapsedTime time_c;
    public double time_p;

    //1 - drive
    //2 - turn
    //3 - slide

    public LoggerData(Hardware r)
    {
        robot = r;
        fileCreated = false;
        dist_left_back = 0;
        dist_left_front = 0;
        dist_right_back = 0;
        dist_right_front = 0;
        speed_left_back = 0;
        speed_left_front = 0;
        speed_right_front = 0;
        speed_right_back = 0;
        time_c = new ElapsedTime();
        time_p = 0;
    }

    public String getValues() {

        String values = Double.toString(time_c.seconds());
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
        values += ", ";
        values += Double.toString(speed_left_back);
        values += ", ";
        values += Double.toString(speed_right_back);
        values += ", ";
        values += Double.toString(speed_left_front);
        values += ", ";
        values += Double.toString(speed_right_front);
        return values;
    }

    public String getHeader() {
        return "time, encoder_left_back, encoder_right_back, encoder_left_front, encoder_right_front, gyro_angle, navigation_function, speed_left_back, speed_right_back, speed_left_front, speed_right_front";
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
            fileCreated = true;
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

        speed_left_back = ( encoder_left_back -  dist_left_back ) / ( time_c.seconds() - time_p );
        speed_left_front = ( encoder_left_front - dist_left_front ) / (time_c.seconds() - time_p );
        speed_right_back = (encoder_right_back - dist_right_back ) / (time_c.seconds() - time_p );
        speed_right_front = (encoder_right_front - dist_right_front ) / (time_c.seconds() - time_p );

        time_p = time_c.seconds();

        dist_left_back = encoder_left_back;
        dist_left_front = encoder_left_front;
        dist_right_back = encoder_right_back;
        dist_right_front = encoder_right_front;

//        range_distance = robot.rangeSensorLeft.getDistance(DistanceUnit.CM);

        try {
            if ( fileCreated ) {
                writer.append(getValues());
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {

        try {
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}

