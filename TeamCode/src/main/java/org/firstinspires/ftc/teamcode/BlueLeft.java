package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Blue Left|P.W", group="B_Knightbot")
//@Disabled
public class BlueLeft extends LinearOpMode {

    HardwareKnightbot         robot = new HardwareKnightbot();   // Use a Knightbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();  //This sets a timer

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        //it takes the configuration on the phones and uses their names and types of motors to identify everything plugged into the hub
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();
        sleep(15000);
        robot.arm.setPower(-0.7); 
        turnLeft(660);
        stopMotors();
        forward(3000); 
        stopMotors();
        
        telemetry.addData("Status", "Done");
        telemetry.update();
    }

    
        private void forward(int time) {
            robot.frontLeft.setPower(-1);
            robot.frontRight.setPower(-1);
            robot.backLeft.setPower(-1);
            robot.backRight.setPower(-1);
            sleep(time);
            stopMotors();
        }

        private void backward(int time) {
            robot.frontLeft.setPower(1);
            robot.frontRight.setPower(1);
            robot.backLeft.setPower(1);
            robot.backRight.setPower(-1);
            sleep(time);
            stopMotors();
        } 


        private void turnRight(int time) {
            robot.frontLeft.setPower(-1);
            robot.frontRight.setPower(1);
            robot.backLeft.setPower(-1);
            robot.backRight.setPower(1);
            sleep(time);
            stopMotors();
        }

        private void turnLeft(int time) {
            robot.frontLeft.setPower(1);
            robot.frontRight.setPower(-1);
            robot.backLeft.setPower(1);
            robot.backRight.setPower(-1);
            sleep(time);
            stopMotors();
        }
        
        //The sleep command makes the robot idle

        /*private void parallelLeft(int time) {
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
        }*/

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
