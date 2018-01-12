package org.usfirst.frc4089.Stealth2018.commands;

import org.usfirst.frc4089.Stealth2018.Constants;
import org.usfirst.frc4089.Stealth2018.Robot;
import org.usfirst.frc4089.Stealth2018.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {
	
	private double errorAvg;
	private double errorLeft;
	private double errorRight;
	private double errorTurn;
	private double turnAngle;

	private double distanceRight;
	private double distanceLeft;
	private int turnDirection;
	private double powerLeft;
	private double powerRight;

    public AutoTurn(double angle, double radius) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drive);
    	
    	double radiusRight;
    	double radiusLeft;
    	turnAngle = angle;
    	if(angle < 0){
    		radiusRight = radius + 2.35;
        	radiusLeft = radius;
        	turnDirection = -1;
    	}else{
    		radiusRight = radius;
        	radiusLeft = radius + 2.35;
        	turnDirection = 1;
    	}
    	
    	distanceRight = (float) (2 * Math.PI * radiusRight * (angle/360));
    	distanceLeft = (float) (2 * Math.PI * radiusLeft * (angle/360));
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/**
    	 * 
    	 */
    	errorTurn = turnAngle - Sensors.getADXAng();
    	if (Constants.defaultAutoSpeed * Constants.kPtr * errorTurn > Constants.defaultAutoSpeed) {
			powerLeft = Constants.defaultAutoSpeed;
			powerRight = Constants.defaultAutoSpeed;
    	
		} else {
			powerLeft = 0;
			powerRight = 0;
			System.out.println("Done Auto Turn");
		}
    	
    	Robot.drive.tankDrive(turnDirection*powerLeft,-turnDirection*powerRight);
    	/*
    	errorLeft = distanceLeft - Robot.drive.leftMotor1.getEncPosition();
    	errorRight = distanceRight - Robot.drive.rightMotor1.getEncPosition();
    	errorAvg = (errorLeft + errorRight)/2;
    	if (Constants.defaultAutoSpeed * Constants.kP * errorAvg >= Constants.defaultAutoSpeed) {
			Robot.drive.tankDrive(Constants.defaultAutoSpeed, Constants.defaultAutoSpeed);
    	
		} else {
			Robot.drive.tankDrive(Constants.defaultAutoSpeed * Constants.kP * errorLeft, Constants.defaultAutoSpeed * Constants.kP * errorRight);
		}*/
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//return (Math.abs(errorAvg) <= Constants.kTolerance) || isTimedOut();
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("AutoTurn - Complete");
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
