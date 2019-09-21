package by.ormedia.library.domain;

import java.util.List;

import by.ormedia.library.core.ILibrary;
import by.ormedia.library.core.ILibraryItem;
import by.ormedia.library.core.ILibraryObject;
import by.ormedia.library.core.IReader;
import by.ormedia.library.jdbc.JDBCConnector;

public class JDBCLibrary implements ILibrary{

	//сделать его синглтоном
	private JDBCConnector jdbc = new JDBCConnector();
	
	@Override
	public List<IReader> getReaders() {
		// TODO Auto-generated method stub
		return this.jdbc.getReaders();
	}

	@Override
	public List<ILibraryItem> getLibraryItemsList(Object ob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ILibraryItem> getFreeItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ILibraryItem> getBusyItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(ILibraryObject ob) {
		if(ob instanceof Reader){
			this.jdbc.saveReader((Reader)ob);
		}
		
	}

}
