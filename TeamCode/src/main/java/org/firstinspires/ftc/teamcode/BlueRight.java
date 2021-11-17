package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Blue Right|Carousel|P.A", group="Knightbot")
//@Disabled
public class BlueRight extends LinearOpMode {

    HardwareKnightbot         robot   = new HardwareKnightbot();   // Use a Knightbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();
        turnRight(500);
        stopMotors();
        forward(1000);
        stopMotors();
        turnLeft(500);
        stopMotors();
        robot.carousel.setPower(1);
        sleep(500);
        robot.carousel.setPower(0);
        forward(500); 
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
