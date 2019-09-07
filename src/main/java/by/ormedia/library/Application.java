package by.ormedia.library;

import by.ormedia.library.controller.Command;
import by.ormedia.library.core.ICommandLine;
import by.ormedia.library.core.ILibrary;
import by.ormedia.library.core.IView;
import by.ormedia.library.domain.Library;
import by.ormedia.library.domain.Reader;
import by.ormedia.library.ui.View;
import static by.ormedia.library.controller.Command.*;

public class Application {
	
	private ILibrary library;
	private ICommandLine commandLine;
	private IView view;
	
	{
		this.library = new Library();
		this.commandLine = new View();
		this.view = (IView)this.commandLine;
	}
	
	@SuppressWarnings("incomplete-switch")
	public void run(){
		while(true){
			Command com = this.commandLine.getNextCommand(SHOW_READERS,ADD_READER,EXIT);
			switch(com){
			case ADD_READER:addReader();
			break;
			case SHOW_READERS:showReaders();
			break;
			}
		}
		
	}
	
	private void addReader(){
		String name = this.commandLine.getString("Введите имя читателя:");
		Command command = this.commandLine.getNextCommand("Добавить читателя с именем '"+name+"' ?",CONFIRM,DECLINE);
		switch(command){
		case CONFIRM:this.library.add(new Reader(name));
		this.view.showMessage("Новый читатель успешно добавлен");
		break;
		default:this.view.showMessage("...отмена");
		}
	}

	private void showReaders(){
		this.view.showReaders(this.library.getReaders());
	}
}
