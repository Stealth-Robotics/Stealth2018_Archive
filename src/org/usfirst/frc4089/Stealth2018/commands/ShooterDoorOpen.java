package org.usfirst.frc4089.Stealth2018.commands;

import org.usfirst.frc4089.Stealth2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterDoorOpen extends Command{

	public ShooterDoorOpen() {

	    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

	        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
	        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	    	requires(Robot.shooterDoor);
	    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	    }

	    // Called just before this Command runs the first timez
	    protected void initialize() {
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	Robot.shooterDoor.openDoor();
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return false;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    	//end();
	    }

}
