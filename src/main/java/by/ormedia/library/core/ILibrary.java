package by.ormedia.library.core;

import java.util.List;

public interface ILibrary {
	List<IReader>getReaders();
	List<ILibraryItem>getLibraryItemsList(Object ob);
	List<ILibraryItem>getFreeItems();
	List<ILibraryItem>getBusyItems();
	void add(ILibraryObject ob);
}
