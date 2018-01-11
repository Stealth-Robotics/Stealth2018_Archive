// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4089.VisionBot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4089.VisionBot.RobotMap;
import org.usfirst.frc4089.VisionBot.StopWatch;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class MoveDistance extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	int mDistance = 0;
	int mCurTarget = 0;
	StopWatch mForward = new StopWatch(5000);
    WPI_TalonSRX driveBaseLeftMain = RobotMap.driveBaseLeftMain;
    WPI_TalonSRX driveBaseRightMain = RobotMap.driveBaseRightMain;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public MoveDistance() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	mDistance = 10000;
    }

    public MoveDistance(int distance) {
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	mDistance = distance;
    }    
    
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	mForward.reset();
    	mCurTarget = mDistance + driveBaseLeftMain.getSelectedSensorPosition(0);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	RobotMap.driveBaseRobotDrive41.curvatureDrive(-0.3,0,true);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	int curLocation = mDistance + driveBaseLeftMain.getSelectedSensorPosition(0);
    	System.out.print(mCurTarget);
    	System.out.print(" ");
    	System.out.println(curLocation);
    	if((curLocation > mCurTarget) || (true == mForward.isExpired()))
		{
    		RobotMap.driveBaseRobotDrive41.tankDrive(0, 0);
			return true;
		}

    	return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
