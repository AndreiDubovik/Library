package by.ormedia.library.controller;

public enum Command {
	
	EXIT("Выход"),
	SHOW_READERS("Показать читателей"),
	CONTINUE("Продолжить"), 
	ADD_READER("Добавить читателя"),
	CONFIRM("Подтвердить"),
	DECLINE("Отклонить");
	
	
	private Command(String command){
		this.command = command;
	}
	
	private String command;
	
	public String toString(){
		return this.command;
	}
}
