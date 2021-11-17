package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class HardwareKnightbot{

    public double FL_POWER = 0;
    public double FR_POWER = 0;
    public double BL_POWER = 0;
    public double BR_POWER = 0;
    public double CAROUSEL_POWER = 0; 
    public long   SERVO_DELAY = 0;

    public DcMotor  frontLeft   = null;
    public DcMotor  frontRight  = null;
    public DcMotor  backLeft    = null;
    public DcMotor  backRight   = null;
    public DcMotor  arm         = null;
    public DcMotor  liftL       = null;
    public DcMotor  liftR       = null;
    public Servo    leftClaw    = null;
    public Servo    rightClaw   = null;
    public DcMotor  carousel    = null;

    HardwareMap hwMap           =  null;
    private ElapsedTime perio   = new ElapsedTime();

    public HardwareKnightbot(){

    }

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        frontLeft  = hwMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hwMap.get(DcMotorEx.class, "frontRight");
        backLeft   = hwMap.get(DcMotorEx.class, "backLeft");
        backRight  = hwMap.get(DcMotorEx.class, "backRight");
        arm        = hwMap.get(DcMotorEx.class, "arm");
        liftL      = hwMap.get(DcMotorEx.class, "liftL");
        liftR      = hwMap.get(DcMotorEx.class, "liftR");
        carousel   = hwMap.get(DcMotorEx.class, "carousel");
        
        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        liftL.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        liftR.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        carousel.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        arm.setPower(0);
        liftL.setPower(0);
        liftL.setPower(0);
        carousel.setPower(0);

        frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        liftL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        liftR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        carousel.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//
        frontLeft.setDirection(DcMotorEx.Direction.FORWARD);
        backLeft.setDirection(DcMotorEx.Direction.REVERSE);
        frontRight.setDirection(DcMotorEx.Direction.REVERSE);
        backRight.setDirection(DcMotorEx.Direction.FORWARD);
        arm.setDirection(DcMotorEx.Direction.FORWARD);
        liftL.setDirection(DcMotorEx.Direction.FORWARD);
        liftR.setDirection(DcMotorEx.Direction.REVERSE); 
        carousel.setDirection(DcMotorEx.Direction.FORWARD); 
        
        leftClaw  = hwMap.get(Servo.class, "leftClaw");
        rightClaw = hwMap.get(Servo.class, "rightClaw");
        rightClaw.setPosition(0.8);
        leftClaw.setPosition(0.2);
        
    }
 }
