package by.ormedia.library.controller;

public enum Type {
	
	BOOK("Книга"),
	MAGAZINE("Журнал"),
	NEWSPAPER("Газета");
	
	private String type;
	
	private Type(String type){
		this.type = type;
	}
	
	public String toString(){
		return this.type;
	}

}
