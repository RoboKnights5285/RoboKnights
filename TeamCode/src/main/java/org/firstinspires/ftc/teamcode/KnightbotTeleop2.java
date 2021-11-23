package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

/**
 * This OpMode uses the common Knightbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwareKnightbot class.
 * The code is structured as a LinearOpMode
 */

@TeleOp(name="Knightbot Movement", group="T_Knightbot")
//@Disabled
public class KnightbotTeleop2 extends LinearOpMode {

    HardwareKnightbot robot = new HardwareKnightbot();   // Use Knightbot's hardware

    @Override
    //This function initializes all of the variables. We use doubles to be more exact than integars
    public void runOpMode() {
        double FL;
        double FR;
        double BL;
        double BR;
        double carousel;
        double leftClawPosition = 0.2;
        double rightClawPosition = 0.8;
        int    clawReverse = 0;

        robot.init(hardwareMap);

        telemetry.addData("Say", "Hello Drivers");
        telemetry.update();

        waitForStart();
        // op mode means controlled by a player
        while (opModeIsActive()) {

            // set drive power levels to power variables 
            FL = gamepad1.left_stick_y-gamepad1.left_stick_x;
            FR = gamepad1.right_stick_y+gamepad1.left_stick_x;
            BL = gamepad1.left_stick_y+gamepad1.left_stick_x;
            BR = gamepad1.right_stick_y-gamepad1.left_stick_x;

            FL = Range.clip(FL, -robot.FL_POWER, robot.FL_POWER);
            FR = Range.clip(FR, -robot.FR_POWER, robot.FR_POWER);
            BL = Range.clip(BL, -robot.BL_POWER, robot.BL_POWER);
            BR = Range.clip(BR, -robot.BR_POWER, robot.BR_POWER);

            robot.frontLeft.setPower(FL);
            robot.frontRight.setPower(FR);
            robot.backLeft.setPower(BL);
            robot.backRight.setPower(BR);

            telemetry.addData("Front Left", robot.frontLeft.getPower());
            telemetry.addData("Front Right", robot.frontRight.getPower());
            telemetry.addData("Back Left", robot.backLeft.getPower());
            telemetry.addData("Back Right", robot.backRight.getPower());
            telemetry.update();
            
            //((DcMotorEx) FL).setVelocity(10);
            //((DcMotorEx) FR).setVelocity(10);
            //((DcMotorEx) frontLeft).setVelocityPIDFCoefficients(2.926,0.2926,0,29.26);
            
            //arm
            //we divide by 2 so x is not included
            robot.arm.setPower(gamepad2.left_stick_y/2);
            
            //claws
            clawReverse = Range.clip(clawReverse, 0, 1);
            //we limit these positions to prevent the robot arms to get so far back it takes a long time for the variables to get set to a position where the arm is once open again
            leftClawPosition = Range.clip(leftClawPosition, 0.1, 0.52);
            rightClawPosition = Range.clip(rightClawPosition, 0.48, 1);
            
            //By pressing Y, you add a number to clawReverse which makes it default closed.
            //Once you press Y it won't change back so be careful!
            if(gamepad2.y){
                clawReverse++;
            }
            
            //holding it will keep it going on and on
            if(clawReverse>=1) {
                if (gamepad2.x){ //opens the claw in increments
                leftClawPosition = leftClawPosition + 0.1;
                rightClawPosition = rightClawPosition - 0.1;
                }
                else if(gamepad2.y){            //closes the claw in increments
                leftClawPosition = leftClawPosition - 0.1;
                rightClawPosition = rightClawPosition + 0.1;
                }
                
                robot.leftClaw.setPosition(leftClawPosition);
                robot.rightClaw.setPosition(rightClawPosition);
            }
                
            //carousel
            if(gamepad2.b == true){                 //counter-clockwise or Red
                robot.carousel.setPower(-1);
            }
            else if (gamepad2.a == true){              //clockwise or Blue
                robot.carousel.setPower(1);
            }
            else{
                robot.carousel.setPower(0); 
            }
                
            //move at a slow pace when left bumper is pressed on gamepad 1
            if (gamepad1.left_bumper) {
                robot.FL_POWER = .2;
                robot.FR_POWER = .2;
                robot.BL_POWER = .2;
                robot.BR_POWER = .2;
            }

            if (!gamepad1.left_bumper) {
                robot.FL_POWER = 1;
                robot.FR_POWER = 1;
                robot.BL_POWER = 1;
                robot.BR_POWER = 1;
                }

            //elevator
            robot.liftL.setPower(gamepad2.right_stick_y);
            //Since the motors are not the same in speed, we multiplied the right one by 0.8 to make them a lot more even
            robot.liftR.setPower(gamepad2.right_stick_y*.8);

            sleep(50);
        }
    }
}
