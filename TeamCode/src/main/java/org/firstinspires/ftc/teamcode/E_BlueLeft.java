package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="E_Blue left|P.W", group="Knightbot")
//@Disabled

public class E_BlueLeft extends LinearOpMode {

    HardwareKnightbot         robot   = new HardwareKnightbot();   // Use a Knightbot's hardware
    private ElapsedTime       runtime = new ElapsedTime();
    
    static final int MOTOR_TICK_COUNTS = 1120;  //declares tick count of motors  (40)
    
    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        telemetry.addData("Status", "Ready to run");
        telemetry.update();
        
        waitForStart();
        
        //driving to park in the warehouse
        robot.frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER); 
        robot.frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        int distanceToGo = 95; //inches to drive
        double circumference=3.14*2.953; //pi*diameter of wheel
        double rotationsNeeded = distanceToGo/circumference; //distance needed/circumference
        int encoderDrivingTarget = (int)(rotationsNeeded*MOTOR_TICK_COUNTS); //cast rotations needed as int
        robot.frontLeft.setTargetPosition(encoderDrivingTarget); //set each wheel to drive that distance
        robot.frontRight.setTargetPosition(encoderDrivingTarget); 
        robot.backLeft.setTargetPosition(encoderDrivingTarget); 
        robot.backRight.setTargetPosition(encoderDrivingTarget);
        robot.frontLeft.setPower(1);
        robot.frontRight.setPower(1);
        robot.backLeft.setPower(1);
        robot.backRight.setPower(1); 
        robot.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(robot.frontLeft.isBusy() || robot.frontRight.isBusy()|| robot.backLeft.isBusy() || robot.backRight.isBusy()){
            telemetry.addData("Driving", "95 inches");
            telemetry.update(); //waiting to finsih driving
        }
        stopMotors();
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
