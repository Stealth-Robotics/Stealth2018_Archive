package org.usfirst.frc4089.Stealth2018.commands;

import org.usfirst.frc4089.Stealth2018.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGear extends CommandGroup {
	    
	    public  AutoGear() {
	    	System.out.println("AutoGear");
	        // Add Commands here:
	        // e.g. addSequential(new Command1());
	        //      addSequential(new Command2());
	        // these will run in order.

	        // To run multiple commands at the same time,
	        // use addParallel()
	        // e.g. addParallel(new Command1());
	        //      addSequential(new Command2());
	        // Command1 and Command2 will run in parallel.

	        // A command group will require all of the subsystems that each member
	        // would require.
	        // e.g. if Command1 requires chassis, and Command2 requires arm,
	        // a CommandGroup containing them would require both the chassis and the
	        // arm.
	    	
	    	
	    	
	    	//addSequential(new GoForwardFiveFeet());
	    	addSequential(new AutoDriveDistance(Constants.AutoGearDistS1, Constants.AutoGearDistS1));
	    	//System.out.println("AutoGear - drive FW Complete");
	    	addSequential(new AutoTurn(Constants.AutoGearAngS2,Constants.AutoGearAngRadS2));
	    	//System.out.println("AutoGear - Turn Complete");
	    	addSequential(new AutoDriveDistance(Constants.AutoGearDistS3, Constants.AutoGearDistS3));
	    	System.out.println("AutoGear - Complete");
	    }
}



