package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="E_Blue Right|Carousel|P.A", group="Knightbot")
//@Disabled

public class E_BlueRight extends LinearOpMode {

    HardwareKnightbot         robot   = new HardwareKnightbot();   // Use a Knightbot's hardware
    private ElapsedTime       runtime = new ElapsedTime();

    static final int MOTOR_TICK_COUNTS = 1680;  //declares tick count of motors  (60)

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();
        
        double circumference=3.14*2.953; //pi*diameter of wheel
        
        //driving to carousel
        robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER); //reset encoders
        robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        int distanceToGo1 = 20; //inches to drive
        double rotationsNeeded1 = distanceToGo1/circumference; //distance needed/circumference
        int encoderDrivingTarget1 = (int)(rotationsNeeded1*MOTOR_TICK_COUNTS); //cast rotations needed as int
        robot.frontLeft.setTargetPosition(encoderDrivingTarget1); //set each wheel to drive that distance
        robot.frontRight.setTargetPosition(encoderDrivingTarget1); 
        robot.backLeft.setTargetPosition(encoderDrivingTarget1); 
        robot.backRight.setTargetPosition(encoderDrivingTarget1);
        robot.frontLeft.setPower(1);
        robot.frontRight.setPower(1);
        robot.backLeft.setPower(1);
        robot.backRight.setPower(1); 
        robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(robot.frontLeft.isBusy() || robot.frontRight.isBusy()|| robot.backLeft.isBusy() || robot.backRight.isBusy()){
            telemetry.addData("Driving", "20 inches");
            telemetry.update(); //waiting to finish driving
        }
        stopMotors();
        telemetry.addData("Finished", "driving 20in");
        telemetry.update(); //done driving
        
        
        //spinningCarousel
        robot.carousel.setPower(1);
        sleep(500); 
        robot.carousel.setPower(0);
        
        
        //Driving forward into alliance station
        robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER); //reset encoders
        robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        int distanceToGo2 = 30; //inches to drive
        double rotationsNeeded2 = distanceToGo2/circumference; //distance needed/circumference
        int encoderDrivingTarget2 = (int)(rotationsNeeded2*MOTOR_TICK_COUNTS); //cast rotations needed as int
        robot.frontLeft.setTargetPosition(encoderDrivingTarget2); //set each wheel to drive that distance
        robot.frontRight.setTargetPosition(encoderDrivingTarget2); 
        robot.backLeft.setTargetPosition(encoderDrivingTarget2); 
        robot.backRight.setTargetPosition(encoderDrivingTarget2);
        robot.frontLeft.setPower(1);
        robot.frontRight.setPower(1);
        robot.backLeft.setPower(1);
        robot.backRight.setPower(1); 
        robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(robot.frontLeft.isBusy() || robot.frontRight.isBusy()|| robot.backLeft.isBusy() || robot.backRight.isBusy()){
            telemetry.addData("Driving", "30 inches");
            telemetry.update(); //waiting to finish driving
        }
        stopMotors();
        telemetry.addData("Finished", "driving 30in");
        telemetry.update(); //done driving
        
        //all done
        
    }
    

        private void forward(int time) {
            robot.frontLeft.setPower(-robot.FL_POWER);
            robot.frontRight.setPower(-robot.FR_POWER);
            robot.backLeft.setPower(-robot.BL_POWER);
            robot.backRight.setPower(-robot.BR_POWER);
            sleep(time);
            stopMotors();
        }

        private void backward(int time) {
            robot.frontLeft.setPower(robot.FL_POWER);
            robot.frontRight.setPower(robot.FR_POWER);
            robot.backLeft.setPower(robot.BL_POWER);
            robot.backRight.setPower(robot.BR_POWER);
            sleep(time);
            stopMotors();
        } 

        private void turnLeft(int time) {
            robot.frontLeft.setPower(robot.FL_POWER);
            robot.frontRight.setPower(-robot.FR_POWER);
            robot.backLeft.setPower(robot.BL_POWER);
            robot.backRight.setPower(-robot.BR_POWER);
            sleep(time);
            stopMotors();
        }

        private void turnRight(int time) {
            robot.frontLeft.setPower(-robot.FL_POWER);
            robot.frontRight.setPower(robot.FR_POWER);
            robot.backLeft.setPower(-robot.BL_POWER);
            robot.backRight.setPower(robot.BR_POWER);
            sleep(time);
            stopMotors();
        }

        private void parallelLeft(int time) {
            robot.frontLeft.setPower(robot.FL_POWER);
            robot.frontRight.setPower(-robot.FR_POWER);
            robot.backLeft.setPower(-robot.BL_POWER);
            robot.backRight.setPower(robot.BR_POWER);
            sleep(time);
            stopMotors();
        }

        private void parallelRight(int time) {
            robot.frontLeft.setPower(-robot.FL_POWER);
            robot.frontRight.setPower(robot.FR_POWER);
            robot.backLeft.setPower(robot.BL_POWER);
            robot.backRight.setPower(-robot.BR_POWER);
            sleep(time);
            stopMotors();
        }

        private void stopMotors() {
            robot.frontLeft.setPower(0);
            robot.frontRight.setPower(0);
            robot.backLeft.setPower(0);
            robot.backRight.setPower(0);
        }

        private void openClaw() {
            robot.leftClaw.setPosition(1);
            robot.rightClaw.setPosition(0);
        }

        private void closeClaw() {
            robot.leftClaw.setPosition(.4);
            robot.rightClaw.setPosition(1);
        }
        
        private void spinCarouselC() {
            robot.carousel.setPower(1);
        }
        
        private void spinCarouselCC() {
            robot.carousel.setPower(-1);
        }
}
