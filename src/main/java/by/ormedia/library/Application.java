package by.ormedia.library;

import by.ormedia.library.controller.Command;
import by.ormedia.library.core.ICommandLine;
import by.ormedia.library.core.ILibrary;
import by.ormedia.library.core.IView;
import by.ormedia.library.domain.Book;
import by.ormedia.library.domain.JDBCLibrary;
import by.ormedia.library.domain.Library;
import by.ormedia.library.domain.Reader;
import by.ormedia.library.thread.LibraryLife;
import by.ormedia.library.ui.View;
import static by.ormedia.library.controller.Command.*;

public class Application {
	
	private ILibrary library;
	private ICommandLine commandLine;
	private IView view;
	private LibraryLife life;
	
	{
		this.library = new JDBCLibrary();
		this.commandLine = new View();
		this.view = (IView)this.commandLine;
	}
	
	@SuppressWarnings("incomplete-switch")
	public void run(){
		boolean run = true;
		while(run){
			Command com = this.commandLine.getNextCommand(SHOW_READERS,ADD_READER,EXIT,ADD_LIBRARY_ITEM,SHOW_ALL_LIBRARY_ITEMS);
			switch(com){
			case ADD_READER:addReader();
			break;
			case SHOW_READERS:showReaders();
			break;
			case EXIT:close();
			run=false;
			break;
			case ADD_LIBRARY_ITEM:this.addLibraryItem();
			break;
			case SHOW_ALL_LIBRARY_ITEMS:this.showLibraryItems();
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
	
	private void close(){
		this.life.shutdown();
		this.view.showMessage("До свиданья");
		//Сохранение данных
	}
	
	private void showLibraryItems(){
		this.view.showLibraryItems(this.library.getLibraryItemsList(null));
	}
	
	private void addLibraryItem(){
		String name = this.commandLine.getString("Введите название книги:");
		Command command = this.commandLine.getNextCommand("Добавить книгу с именем '"+name+"' ?",CONFIRM,DECLINE);
		switch(command){
		case CONFIRM:this.library.add(new Book(name));
		this.view.showMessage("Новая книга успешно добавлена");
		break;
		default:this.view.showMessage("...отмена");
	}
}
}