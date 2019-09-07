package by.ormedia.library;

import by.ormedia.library.controller.Command;
import by.ormedia.library.core.ICommandLine;
import by.ormedia.library.core.ILibrary;
import by.ormedia.library.core.IView;
import by.ormedia.library.domain.Library;
import by.ormedia.library.ui.View;

public class Application {
	
	private ILibrary library;
	private ICommandLine commandLine;
	private IView view;
	
	{
		this.library = new Library();
		this.commandLine = new View();
		this.view = (IView)this.commandLine;
	}
	
	public void run(){
		while(true){
			this.commandLine.getNextCommand(Command.SHOW_READERS,Command.ADD);
		}
	}

}
