package org.usfirst.frc4089.Stealth2018;

public class Constants {
	//assorted variables
	public static final double collectorSpeed = .5;
	public static final double ellevatorSpeedUp = 1;
	public static final double ellevatorSpeedDown = -.75;
	public static final double shooterSpeed = 1;
	public static final double climber1Speed = 1;
	public static final double climber2Speed = 1;
	public static final double rightSpeed = 1;
	public static final double leftSpeed = .9;
	public static final double curve = 0;//-0.2;

	
	//wheel info
	public static final int wheelDiaIn = 6; //in
	public static final double wheelCircIN = 6*Math.PI; //in
	public static final double wheelCircFT = wheelCircIN/12;
	
	//encoders
	public static final int E4TEncoderPulsePerRev = 1440;
	public static final double encoderRightDistanceFTPerPulse = wheelCircFT/E4TEncoderPulsePerRev;
	public static final double encoderLeftDistanceFTPerPulse = wheelCircFT/E4TEncoderPulsePerRev;
	public static final double encoderConversionDisFT = wheelCircFT/E4TEncoderPulsePerRev; //FT/pulse
	public static final double encoderConversionDisIN = wheelCircIN/E4TEncoderPulsePerRev; //FT/pulse
	
	//Motor IDs
	public static final int rightMotor1SpeedControl = 6; //normally 6
	public static final int rightMotor2SpeedControl = 7;
	public static final int left1MotorSpeedControl = 1; //normally 1
	public static final int left2MotorSpeedControl = 2;
	public static final int climbMotor1SpeedControl = 8; //normally 8
	public static final int climbMotor2SpeedControl = 4;
	public static final int ShooterMotorSpeedControl = 10;
	public static final int ellevatorMotorSpeedControl = 9; //normally 9
	public static final int agitatorMotorSpeedControl = 5;
	public static final int collectorMotorControl = 3;
	//servos
	public static final int shooterDoorPort = 1;
	public static final int RBarrelBlockerPort = 2;
	public static final int LBarrelBlockerPort = 3;
	
	//autoconfig
	public final static double kTolerance = 0.1;
	public final static double kP = .88;//-1.0 / 5.0;
	public final static double kPtr = .95; //kP for turn right
	public final static double kPrl = .95; //kP for turn left
	public final static double kI = -1.0 / 5.0;
	public final static double kD = -1.0 / 5.0;
	public final static double defaultAutoSpeed = .75;
	public final static double AutoGearDistS1 = 92; //IN
	public final static double AutoGearAngS2 = 30; //deg
	public final static double AutoGearDistS3 = 60; //IN
	public final static double AutoGearAngRadS2 = 2; //feet of radius
	public final static double AutoDriveFWTimed = 2.25; //sec
	public final static double autoFWSpdRight = 0.5;
	public final static double autoFWSpdLeft = 0.5872;//0.671;

}