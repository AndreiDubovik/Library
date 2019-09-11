package by.ormedia.library.controller;

public enum Command {
	
	EXIT("Выход"),
	SHOW_READERS("Показать читателей"),
	CONTINUE("Продолжить"), 
	ADD_READER("Добавить читателя"),
	CONFIRM("Подтвердить"),
	DECLINE("Отклонить"),
	ADD_LIBRARY_ITEM("Добавить в библиотеку"),
	ADD_BOOK("Добавить книгу"),
	SHOW_ALL_LIBRARY_ITEMS("Показать весь список библиотеки");
	
	
	
	private Command(String command){
		this.command = command;
	}
	
	private String command;
	
	public String toString(){
		return this.command;
	}
}
