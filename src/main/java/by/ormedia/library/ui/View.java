package by.ormedia.library.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import by.ormedia.library.controller.Command;
import by.ormedia.library.core.ICommandLine;
import by.ormedia.library.core.ILibraryItem;
import by.ormedia.library.core.IReader;
import by.ormedia.library.core.IView;

public class View implements IView, ICommandLine{
	
	private Scanner scanner = new Scanner(System.in);

	@Override
	public void showReaders(List<IReader> list) {
		System.out.println("Список читателей:");
		for(IReader reader:list){
			System.out.println("reader: "+reader.getName()+" (id:"+reader.getId()+")");
		}
		System.out.println("   всего: "+list.size());
	}

	@Override
	public Command getNextCommand(Command...commands) {
		System.out.println("Варианты дальнейших действий:");
		boolean exit = false;
		boolean cont = false;
		int i = 1;
		Map<Integer,Command>commandMap = new HashMap<>();
		for(Command command:commands){
			if(command==Command.CONTINUE){
				cont = true;
				continue;
			}
			if(command==Command.EXIT){
				exit=true;
				continue;
			}
			commandMap.put(i, command);
			System.out.println((i++)+" - "+command.toString());
		}
		if(exit){
			commandMap.put(0, Command.EXIT);
			System.out.println("... для выхода из программы введите '0'");
		}
		if(cont){
			System.out.println("... любой другой ключ для выхода в главное меню");
		}
		Integer integer = this.getInteger("что делаем дальше?");
		Command command = commandMap.get(integer);
		return command!=null?command:Command.CONTINUE;
	}

	@Override
	public String getString(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}

	@Override
	public int getInteger(String question){
			System.out.println(question);
			String line = scanner.nextLine();
			try{
				int result = Integer.parseInt(line);
				return result;
			}catch(NumberFormatException e){
				System.out.println("некорректный ввод!");
				return getInteger(question);
			}	
	}

	@Override
	public Command getNextCommand(String message, Command... commands) {
		System.out.println(message);
		return this.getNextCommand(commands);
	}

	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void showLibraryItems(List<ILibraryItem> list) {
		System.out.println("список:");
		for(ILibraryItem item:list){
			System.out.println("id: "+item.getId()+"тип: "+item.getType()+"  наименование: "+item.getName()
					+" статус: "+(item.isFree()?"свободен":"занят"));
		}
		System.out.println("всего: "+list.size()+" пунктов");
		
	}

}
