package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.internal.opmode.TelemetryImpl;

import java.util.List;

public class TensorDetectionClass {

    Hardware robot;
    OpModeAddition opMode;
    Telemetry telemetry;


    public static final String TFOD_MODEL_ASSET = "Skystone.tflite";
    public static final String LABEL_FIRST_ELEMENT = "Stone";
    public static final String LABEL_SECOND_ELEMENT = "Skystone";

    public HardwareMap hMap = null;

    public static final String VUFORIA_KEY =
            "AbJRubT/////AAABma6KEOwi/UjmpKjNKZN3/NWMSd1P03DjYNZUmfA4zeI/6iDpgj7s7Xvujkc5tKEYP4QwNmtgXUf2kml1Nb0Pozf+iAxWwM+CPmCTFYks5fp0ckAtACUxtCCOluwQCn5NlU8vgBHwBNeVis+2j/26tO8B2Lh1bNz/RZLK9jbIVCQVQRPPAZ2+IpBPQogX3Dc5I4jktld7zcoTEOV1a7y+0sV006TBpV0KnanLQwXyZfDDfjNC1xDsladUdQ35JHU5N2fEwDOnWC7DLAZNU7UgLIPUH1EoHUbbilp4K5HrDqk4SYovwrEeHWccA9tzIE2oT4vsejcEQ99zFVa5+MhQhWKJSBnUTWj696jXeCNwrbm/";

    public VuforiaLocalizer vuforia;

    public TFObjectDetector tfod;

    public TensorDetectionClass(Hardware r){
        robot = r;
    }

    public void setOpModeAddition(OpModeAddition opMode) {

        this.opMode = opMode;
    }

//    public void setTelemetry(OpMode opMode) {
//
//        telemetry = new TelemetryImpl(opMode);
//    }

    public void setHardwareMap(HardwareMap hmap) {

        this.hMap = hmap;

    }

    public void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    public void initTfod() {
        int tfodMonitorViewId = hMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minimumConfidence = 0.8;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }

    public void INITCAMERA() {

        initVuforia();

        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        }

        if (tfod != null) {
            tfod.activate();
        }

    }

    public int TensorDetection() {

        ElapsedTime time = new ElapsedTime();

        telemetry.addData("AFISEAZA", "CEVA");
        /**
         * Activate TensorFlow Object Detection before we wait for the start command.
         * Do it here so that the Camera Stream window will have the TensorFlow annotations visible.
         **/


        int k = -2;


        while (opMode.isOpModeIsActive() && k == -2 && time.seconds() < 20) {

                // getUpdatedRecognitions() will return null if no new information is available since
                // the last time that call was made.
                List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                if (updatedRecognitions != null) {

                    // step through the list of recognitions and display boundary info.
                    float leftstone = 0, skystone = 0;

                    for (Recognition recognition : updatedRecognitions) {

                        if (recognition.getLabel().equals("Skystone")) {
                            skystone = recognition.getLeft();

                        }
                        else {
                            leftstone = recognition.getLeft();
                        }

                    }

                    telemetry.addData("Skystoneul este ", skystone);

                    if (updatedRecognitions.size() > 1) {

                        if (skystone == 0 ) {
                            k = 1;

                        }

                         else {
                            if (leftstone < skystone) {
                                k = 0;
                            }
                            else {
                                k = -1;
                            }
                        }

                    }
                }

                telemetry.addData("f ", k);
                telemetry.update();
            }


        return k;

    }
}

