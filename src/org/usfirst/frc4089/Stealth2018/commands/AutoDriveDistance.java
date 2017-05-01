package org.usfirst.frc4089.Stealth2018.commands;

import org.usfirst.frc4089.Stealth2018.AutoOptions;
import org.usfirst.frc4089.Stealth2018.Constants;
import org.usfirst.frc4089.Stealth2018.Robot;
import org.usfirst.frc4089.Stealth2018.RobotMap;
import org.usfirst.frc4089.Stealth2018.subsystems.Climber;
import org.usfirst.frc4089.Stealth2018.subsystems.Collector;
import org.usfirst.frc4089.Stealth2018.subsystems.Drive;
import org.usfirst.frc4089.Stealth2018.subsystems.Ellevator;
import org.usfirst.frc4089.Stealth2018.subsystems.Shooter;
import org.usfirst.frc4089.Stealth2018.subsystems.ShooterDoor;
import org.usfirst.frc4089.Stealth2018.util.DriveMath;
import org.usfirst.frc4089.Stealth2018.util.LogMech;
import org.usfirst.frc4089.Stealth2018.util.Utilities;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class AutoDriveDistance extends Command {

	private double errorAvg;
	private double errorLeft;
	private double errorRight;
	//private boolean stopAuto;
	//public double distance;
	private double distanceRight;
	private double distanceLeft;
	private double powerLeft;
	private double powerRight;
	private double flipLeftEnc;
	
	/*public void stopAutos(){
		stopAuto = true;
	}*/
    public AutoDriveDistance(double distLeft, double distRight) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drive);
    	distanceLeft = distLeft;
    	distanceRight = distRight;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("AUTO-Drive-Dist-INIT");
    	Robot.stopAuto = false;
    	//Robot.drive.resetEncoders();
    	//setTimeout(3.0);
    	
    	 
    	
    	/*Robot.drive = null;
        Robot.collector = null;
        Robot.shooter = null;
        Robot.ellevator = null;
        Robot.climber = null;
        Robot.utilities = null;
        Robot.shooterDoor = null;
        Robot.autoOptions = null;
    	*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if(timeSinceInitialized() < 3000){
    	
    	//System.out.println("Auto Drive Dist");
	    //if(Robot.stopAuto = true){System.out.println("exit"); return;}	
    	flipLeftEnc = 
    	errorLeft = distanceLeft + DriveMath.calcDist(RobotMap.driveLeftMotor1.getEncPosition(), "IN");
    	errorRight = distanceRight - DriveMath.calcDist(RobotMap.driveRightMotor1.getEncPosition(), "IN");
    	errorAvg = (errorLeft + errorRight)/2;
    	
    	if (Constants.autoFWSpdLeft * Constants.kP * errorLeft > Constants.autoFWSpdLeft) {
			powerLeft = Constants.autoFWSpdLeft;
    	
		} else {
			powerLeft = 0;
			System.out.println("Done Auto FW Left");
		}
    	
    	if (Constants.autoFWSpdRight * Constants.kP * errorAvg > Constants.autoFWSpdRight) {
    		powerRight = Constants.autoFWSpdRight;
    		
    	
		} else {
			powerRight = 0;
			System.out.println("Done Auto FW Right");
		}
    	Robot.drive.tankDrive(powerLeft, powerRight);
    	LogMech.logMe();
	    	//SmartDashboard.putNumber("Left Encoder", Robot.drive.leftEncoder.getDistance());
    	//}else{
    	//	end();
    	//}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Math.abs(errorAvg) <= Constants.kTolerance) || isTimedOut();
    	//isTimedOut();
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	System.out.println("AutoDriveDist - Complete");
    	//Robot.drive.stop();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
