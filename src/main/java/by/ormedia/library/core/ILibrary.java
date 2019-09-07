package by.ormedia.library.core;

import java.util.List;

public interface ILibrary {
	List<IReader>getReaders();
	List<ILibraryItem>getLibraryItemsList(Object ob);
	void add(ILibraryObject ob);
}
