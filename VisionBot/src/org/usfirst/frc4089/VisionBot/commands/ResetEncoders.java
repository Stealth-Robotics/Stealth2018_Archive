package org.usfirst.frc4089.VisionBot.commands;

import org.usfirst.frc4089.VisionBot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetEncoders extends Command {
	
    WPI_TalonSRX driveBaseLeftMain = RobotMap.driveBaseLeftMain;
    WPI_TalonSRX driveBaseRightMain = RobotMap.driveBaseRightMain;

    public ResetEncoders() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        driveBaseLeftMain.setSelectedSensorPosition(0,0,20);
        driveBaseRightMain.setSelectedSensorPosition(0,0,20);
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
