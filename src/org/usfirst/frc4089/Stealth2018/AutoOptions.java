package org.usfirst.frc4089.Stealth2018;


import org.usfirst.frc4089.Stealth2018.commands.*;

import edu.wpi.first.wpilibj.command.Command;

public class AutoOptions {
	public static final String[] Options = new String[] {
			"Go Forward Five Feet",
			"RunMP"};

	static Command[] allCommands = new Command[] {
			new AutoGoForwardFiveFeet(),
			new RunMP()
	};
	
	//get each individual command, no duplicates
	static Command getCommand(int i)
	{
		return allCommands[i];
	}
	
	public static Command getAutoCommandFromString(String chosen)
	{
		for(int i = 0; i < Options.length; i++)
		{
			if(Options[i].equals(chosen)){
				return getCommand(i);
			}
		}
		return null; //for now
	}
}

