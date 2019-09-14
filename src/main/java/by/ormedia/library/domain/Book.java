package by.ormedia.library.domain;

import by.ormedia.library.controller.Type;

public class Book extends LibraryItem{

	public Book(String name) {
		super(name);
	}

	@Override
	public Type getType() {
		return Type.BOOK;
	}

}
