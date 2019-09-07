package by.ormedia.library.core;

import by.ormedia.library.controller.Command;

public interface ICommandLine {
	
	Command getNextCommand(Command...commands);
	String getString(String question);
	int getInteger(String question);
}
