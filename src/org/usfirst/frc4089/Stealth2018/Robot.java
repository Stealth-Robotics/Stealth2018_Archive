// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
/*
TO-DO List:
	ClimberMotor
	Servo digital programmer
	smart shooter door button
*/
package org.usfirst.frc4089.Stealth2018;

import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.nio.ByteBuffer;
import java.util.HashMap;

import org.usfirst.frc4089.Stealth2018.MP.MotionProfile;
import org.usfirst.frc4089.Stealth2018.commands.*;
import org.usfirst.frc4089.Stealth2018.subsystems.*;
import org.usfirst.frc4089.Stealth2018.util.ResetMe;
import org.usfirst.frc4089.Stealth2018.util.Utilities;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.cscore.UsbCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static boolean stopAuto = false;
    Command autonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drive drive;
    public static Collector collector;
    public static Shooter shooter;
    public static Ellevator ellevator;
    public static Climber climber;
    public static Utilities utilities;
    public static ShooterDoor shooterDoor;
    public static MotionProfile motionProfile;

    public static AutoOptions autoOptions;
    //public static I2C arduinoCom;
    public static DriverStation ds = DriverStation.getInstance();
    
    /*static HashMap<Integer, String> sampleDict = new HashMap<Integer, String>(){/**
		 * 
		 *
		private static final long serialVersionUID = 1L;

	{
    	put(16, "AutonCommandName1");
    	put(17, "AutonCommandName2");
    	put(19, "EllevatorRun");
    }};*/
    
    private void I2CTransaction()
	{
    	/*ByteBuffer sent, received;
    	sent = ByteBuffer.allocateDirect(4);
    	received = ByteBuffer.allocateDirect(2);
		if(Alliance.Blue == ds.getAlliance())
		{
			sent.put((byte)((int)'B'));
		}
		else
		{
			if(Alliance.Red == ds.getAlliance())
			{
				sent.put((byte)((int)'R'));
			}
			else
			{
				sent.put((byte)((int)'I'));
			}
		}
		
		sent.put((byte)ds.getLocation());
		if(ds.isEnabled())
		{
			sent.put((byte)((int)'E'));
		}
		else
		{
			sent.put((byte)((int)'D'));
		}
		
		sent.put((byte)0);

    	Robot.arduinoCom.transaction(sent, 4, received, 2);
    	Timer.delay(0.005);
    	int selection = received.getShort();
    	if(selection >= 16 && autonomousCommand == null)
    	{
	    	try {
				Class<?> autonClass = Class.forName(sampleDict.get(selection));
				autonomousCommand = (Command)autonClass.newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}*/
	}
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    MotionProfile MPL = new MotionProfile(RobotMap.driveLeftMotor1);
    MotionProfile MPR = new MotionProfile(RobotMap.driveRightMotor1);
    
    
       
    public void robotInit() {
    	System.out.println("robot int line 1");
    RobotMap.init();
    	System.out.println("robot int post robotmap.init");
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        stopAuto = true;
    	drive = new Drive();
        collector = new Collector();
        shooter = new Shooter();
        ellevator = new Ellevator();
        climber = new Climber();
        utilities = new Utilities();
        shooterDoor = new ShooterDoor();
        autoOptions = new AutoOptions();     
        System.out.println("commands constructed");
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        //TODO add constructors to subsystem --> moved to subsystem default init
        //RobotMap.driveLeftMotor1.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
        //RobotMap.driveRightMotor1.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
        //RobotMap.driveLeftMotor1.reverseSensor(false); /* keep sensor and motor in phase */
		
        /*new Thread(() -> {
        	UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        }).start();
        */// OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        System.out.println("robot init pre oi");
        oi = new OI();
        System.out.println("robot init post oi");
        //arduinoCom = new I2C(I2C.Port.kOnboard, 40);

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        //autonomousCommand = (Command) new AutoGoForwardFiveFeet();
        //autonomousCommand = (Command) new AutoDriveFTimed();
        //autonomousCommand = (Command) new AutoDriveDistance(96,96); //IN units
        autonomousCommand = (Command) new AutoGear();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        System.out.println("Robot Init pre feedback device");
        Sensors.resetADX();
        RobotMap.driveLeftMotor1.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
        RobotMap.driveRightMotor1.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	System.out.println("Robot disable Init");
    	//I2CTransaction();
    }

    public void disabledPeriodic() {
    	//System.out.println("disable Periodic");
        //Scheduler.getInstance().run();
        //I2CTransaction();
    	/* it's generally a good idea to put motor controllers back
		 * into a known state when robot is disabled.  That way when you
		 * enable the robot doesn't just continue doing what it was doing before.
		 * BUT if that's what the application/testing requires than modify this accordingly */
		RobotMap.driveLeftMotor1.changeControlMode(TalonControlMode.PercentVbus);
		RobotMap.driveRightMotor1.changeControlMode(TalonControlMode.PercentVbus);
		RobotMap.driveLeftMotor1.set(0);
		RobotMap.driveRightMotor1.set(0);
		/* clear our buffer and put everything into a known state */
//		MPR.reset();
		//MPL.reset();
    }

    public void autonomousInit() {
    	System.out.println("auto init");
        // schedule the autonomous command (example)
    	//autonomousCommand = AutoOptions.getCommand(0); //6=Motion Profile
    	//autonomousCommand = (Command) new AutoGoForwardFiveFeet();
    	System.out.println(autonomousCommand);
    	
    	//RobotMap.driveLeftMotor1.setEncPosition(0);
    	//RobotMap.driveRightMotor1.setEncPosition(0);
    	ResetMe.resetAutoInit();
    	if (autonomousCommand != null) autonomousCommand.start(); 
    
    	
    	//I2CTransaction();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	//System.out.println("auto periodic");
        Scheduler.getInstance().run();
        //I2CTransaction();
        // call this periodically, and catch the output.  Only apply it if user wants to run MP.
  //      MPL.control();
  //      MPR.control();
        
        /* switch to motion profile control mode => This is done in MotionProfileControl.
		 * When we transition from no-press to press,
		 * pass a "true" once to MotionProfileControl.
		 */
//		RobotMap.driveLeftMotor1.changeControlMode(TalonControlMode.MotionProfile);
//		RobotMap.driveRightMotor1.changeControlMode(TalonControlMode.MotionProfile);
		//RobotMap.driveLeftMotor2.changeControlMode(TalonControlMode.Follower);
//		CANTalon.SetValueMotionProfile setOutputR = MPR.getSetValue();
//		CANTalon.SetValueMotionProfile setOutputL = MPL.getSetValue();
		
//		RobotMap.driveLeftMotor1.set(setOutputL.value);
//		RobotMap.driveRightMotor1.set(setOutputR.value);

		//start Motion Profile
//		MPR.startMotionProfile();
//		MPL.startMotionProfile();
		
		
    }

    public void teleopInit() {
    	System.out.println("tele init");
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        //I2CTransaction();
        
        //AutoDriveDistance.stopAutos();
        /*drive = new Drive();
        collector = new Collector();
        shooter = new Shooter();
        ellevator = new Ellevator();
        climber = new Climber();
        utilities = new Utilities();
        shooterDoor = new ShooterDoor();
        autoOptions = new AutoOptions();
    */
        //RobotMap.driveLeftMotor1.changeControlMode(TalonControlMode.Voltage);
        //RobotMap.driveRightMotor1.changeControlMode(TalonControlMode.Voltage);
        RobotMap.driveLeftMotor1.changeControlMode(TalonControlMode.PercentVbus);
		RobotMap.driveRightMotor1.changeControlMode(TalonControlMode.PercentVbus);
		//reset the Talon encoders
		//RobotMap.driveLeftMotor1.reset();
    	//RobotMap.driveRightMotor1.reset();
		ResetMe.resetTeleInit();
    	//RobotMap.driveLeftMotor1.setEncPosition(0);
    	//RobotMap.driveRightMotor1.setEncPosition(0);
    	
        }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
        Scheduler.getInstance().run();
        //I2CTransaction();
        //System.out.println("TELE-PERIODIC");
        /* call this periodically, and catch the output.  Only apply it if user wants to run MP. */
		
        //TODO add periodic in subsystem
        //MPLeft.control();
		//MPRight.control();
        //RobotMap.driveLeftMotor1.changeControlMode(TalonControlMode.Voltage);
        //RobotMap.driveRightMotor1.changeControlMode(TalonControlMode.Voltage);
//		MPR.reset();
//		MPL.reset();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
